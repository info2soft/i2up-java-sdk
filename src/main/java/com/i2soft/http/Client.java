package com.i2soft.http;

import com.i2soft.common.Auth;
import com.i2soft.util.*;
import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 定义HTTP请求管理相关方法
 */
public final class Client {
    static final String JsonMime = "application/json";
    public static final MediaType JSONMedia = MediaType.parse("application/json; charset=utf-8");
    private static final String[] NoneAuth = {"/api/auth/token"};
    private StringMap headers;
    private final OkHttpClient httpClient;
    public final String cc_url;

    private Auth auth;

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

        // 忽略 ssl 证书
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };

        X509TrustManager x509TrustManager = new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType)
                    throws CertificateException {
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }
        };

        SSLContext sslContext = null;

        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }

        final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        builder.sslSocketFactory(sslSocketFactory, x509TrustManager);

        builder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });

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

    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public void setHeader(String key, String value) {
        if (null == this.headers) {
            this.headers = new StringMap();
        }
        this.headers.put(key, value);
    }

    public Response get(String url) throws I2softException {
        return get(url, new StringMap());
    }

    public Response get(String url, StringMap query) throws I2softException {
        signAndPrintLog(url, "GET", query);
        if (query.size() != 0) {
            url += query.formString();
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).get();
        return send(requestBuilder);
    }

    public Response post(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "POST", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).post(body.toJson());
        return send(requestBuilder);
    }

    public Response put(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "PUT", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).put(body.toJson());
        return send(requestBuilder);
    }

    public Response delete(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "DELETE", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).delete(body.toJson());
        return send(requestBuilder);
    }

    // 加签名，打日志
    private void signAndPrintLog(String url, String method, StringMap args) {
        addSignToHeader(method, url, args);
        if (Constants.LOG_HTTP) {
            System.out.println("\nURL: [" + method + "] " + url
                    + "\nHEADER: " + Json.encode(this.headers)
                    + "\nARGS: " + Json.encode(args));
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
        requestBuilder.header("Content-Type", JsonMime);
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
        if (r.ret >= 300) {
            if (Constants.LOG_HTTP) {
                StringUtils.printLog("Http error code : " + r.ret + ", msg: " + r.msg);
            }
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

    private void addSignToHeader(String httpMethod, String url, StringMap args) {
        if (null == headers) {
            headers = new StringMap();
        }

        if (!url.contains("/api/")) {
            return;
        }

        String api = url.substring(url.indexOf("/api/")); // Eg: /api/node

        if (Arrays.asList(NoneAuth).contains(api)) {
            return;
        }

        String randomStr = getRandomString(16);
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        String uuid = UUID.randomUUID().toString();
        String secret;

        // AK or Token
        if (this.auth.authType.equals(Auth.AUTH_TYPE_AK_SK)) {
            headers.put("ACCESS-KEY", this.auth.ak);
            secret = this.auth.sk;
        } else {
            headers.put("Authorization", this.auth.token);
            secret = this.auth.token;
        }

        String signData = httpMethod.toUpperCase() + "\n" +
                api + "\n" +
                randomStr + "\n" +
                time + "\n" +
                uuid;

        try {
            // 加密生成签名
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = bytes2HexString(sha256_HMAC.doFinal(signData.getBytes())).toLowerCase();

            headers.put("timestamp", time)
                    .put("nonce", uuid)
                    .put("Signature", hash);

            // args
            args.put("_", randomStr); // 签名必备随机串

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    private static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    private static String bytes2HexString(byte[] b) {
        StringBuilder ret = new StringBuilder();
        for (byte b1 : b) {
            String hex = Integer.toHexString(b1 & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret.append(hex.toUpperCase());
        }
        return ret.toString();
    }
}
