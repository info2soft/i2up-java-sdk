package com.i2soft.http;

import com.i2soft.util.Constants;
import com.i2soft.util.Configuration;
import com.i2soft.util.Json;
import com.i2soft.util.StringMap;
import com.sun.istack.internal.Nullable;
import okhttp3.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 定义HTTP请求管理相关方法
 */
public final class Client {
    static final String JsonMime = "application/json";
    private StringMap headers;
    private final OkHttpClient httpClient;
    public final String cc_url;

    /**
     * 构建一个默认配置的 HTTP Client 类
     */
    public Client() {
        this(null, null, false, null,
                Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT,
                Constants.DISPATCHER_MAX_REQUESTS, Constants.DISPATCHER_MAX_REQUESTS_PER_HOST,
                Constants.CONNECTION_POOL_MAX_IDLE_COUNT, Constants.CONNECTION_POOL_MAX_IDLE_MINUTES);
    }

    /**
     * 构建一个自定义配置的 HTTP Client 类
     */
    public Client(String ip, Configuration cfg) {
        this(ip, cfg.dns, cfg.useDnsHostFirst, cfg.proxy,
                cfg.connectTimeout, cfg.readTimeout, cfg.writeTimeout,
                cfg.dispatcherMaxRequests, cfg.dispatcherMaxRequestsPerHost,
                cfg.connectionPoolMaxIdleCount, cfg.connectionPoolMaxIdleMinutes);
    }

    /**
     * 构建一个自定义配置的 HTTP Client 类
     */
    public Client(final String ip, final Dns dns, final boolean hostFirst, final ProxyConfiguration proxy,
                  int connTimeout, int readTimeout, int writeTimeout, int dispatcherMaxRequests,
                  int dispatcherMaxRequestsPerHost, int connectionPoolMaxIdleCount,
                  int connectionPoolMaxIdleMinutes) {

        this.cc_url = String.format("%s/api", ip); // 控制机地址

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequests(dispatcherMaxRequests);
        dispatcher.setMaxRequestsPerHost(dispatcherMaxRequestsPerHost);
        ConnectionPool connectionPool = new ConnectionPool(connectionPoolMaxIdleCount,
                connectionPoolMaxIdleMinutes, TimeUnit.MINUTES);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        builder.dispatcher(dispatcher);
        builder.connectionPool(connectionPool);
        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                okhttp3.Response response = chain.proceed(request);
                IpTag tag = (IpTag) request.tag();
                try {
                    tag.ip = Objects.requireNonNull(chain.connection()).socket().getRemoteSocketAddress().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    tag.ip = "";
                }
                return response;
            }
        });
        if (dns != null) {
            builder.dns(new okhttp3.Dns() {
                @Override
                public List<InetAddress> lookup(String hostname) throws UnknownHostException {
                    try {
                        return dns.lookup(hostname);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return okhttp3.Dns.SYSTEM.lookup(hostname);
                }
            });
        }
        if (proxy != null) {
            builder.proxy(proxy.proxy());
            if (proxy.user != null && proxy.password != null) {
                builder.proxyAuthenticator(proxy.authenticator());
            }
        }
        builder.connectTimeout(connTimeout, TimeUnit.SECONDS);
        builder.readTimeout(readTimeout, TimeUnit.SECONDS);
        builder.writeTimeout(writeTimeout, TimeUnit.SECONDS);
        httpClient = builder.build();
    }

    public void set_headers(StringMap headers) {
        this.headers = headers;
    }

    public Response get(String url) throws I2softException {
        printLog(url);
        Request.Builder requestBuilder = new Request.Builder().url(url).get();
        return send(requestBuilder);
    }

    public Response get(String url, StringMap query) throws I2softException {
        printLog(url, query);
        if (query.size() != 0) {
            url += query.formString();
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).get();
        return send(requestBuilder);
    }

    public Response post(String url, StringMap body) throws I2softException {
        printLog(url, body);
        Request.Builder requestBuilder = new Request.Builder().url(url).post(body.toJson());
        return send(requestBuilder);
    }

    public Response put(String url, StringMap body) throws I2softException {
        printLog(url, body);
        Request.Builder requestBuilder = new Request.Builder().url(url).put(body.toJson());
        return send(requestBuilder);
    }

    public Response delete(String url, StringMap body) throws I2softException {
        printLog(url, body);
        Request.Builder requestBuilder = new Request.Builder().url(url).delete(body.toJson());
        return send(requestBuilder);
    }

    private void printLog(String url) {
        if (Constants.LOG_HTTP) {
            System.out.println("\nURL: " + url);
        }
    }

    private void printLog(String url, @Nullable StringMap args) {
        if (Constants.LOG_HTTP) {
            System.out.println("\nURL: " + url + "\nARGS: " + Json.encode(args));
        }
    }

    private Response send(final Request.Builder requestBuilder) throws I2softException {

        if (this.headers != null) {
            this.headers.forEach(new StringMap.Consumer() {
                @Override
                public void accept(String key, Object value) {
                    requestBuilder.header(key, value.toString());
                }
            });
        }

        requestBuilder.header("User-Agent", userAgent());
        long start = System.currentTimeMillis();
        okhttp3.Response res;
        Response r;
        double duration = (System.currentTimeMillis() - start) / 1000.0;
        IpTag tag = new IpTag();
        try {
            res = httpClient.newCall(requestBuilder.tag(tag).build()).execute();
        } catch (IOException e) {
            e.printStackTrace();
            throw new I2softException(e);
        }
        r = Response.create(res, tag.ip, duration);
        // err
        if (r.ret >= 300 || (r.ret == 200 && r.code != 0)) {
            throw new I2softException(r);
        }

        return r;
    }

    private static String userAgent() {
        String javaVersion = "Java/" + System.getProperty("java.version");
        String os = System.getProperty("os.name") + " "
                + System.getProperty("os.arch") + " " + System.getProperty("os.version");
        String sdk = "Info2soft/" + Constants.VERSION;
        return sdk + " (" + os + ") " + javaVersion;
    }

    private static class IpTag {
        private String ip = null;
    }
}
