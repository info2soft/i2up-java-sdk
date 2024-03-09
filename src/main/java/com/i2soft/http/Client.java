package com.i2soft.http;

import com.i2soft.common.Auth;
import com.i2soft.util.*;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.*;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
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
    private static final String[] NoneAuth = {"/api/auth/token", "/api/sys/public_settings"};
    private StringMap headers;
    private final OkHttpClient httpClient;
    public final String cc_url;
    protected String cachePath;
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

    public Client(String ip, Configuration cfg, String cachePath) {
        this(ip, cfg.dns, cfg.useDnsHostFirst, cfg.proxy,
                cfg.connectTimeout, cfg.readTimeout, cfg.writeTimeout,
                cfg.dispatcherMaxRequests, cfg.dispatcherMaxRequestsPerHost,
                cfg.connectionPoolMaxIdleCount, cfg.connectionPoolMaxIdleMinutes, cachePath);
    }

    public Client(final String ip, final Dns dns, final boolean hostFirst, final ProxyConfiguration proxy,
                  int connTimeout, int readTimeout, int writeTimeout, int dispatcherMaxRequests,
                  int dispatcherMaxRequestsPerHost, int connectionPoolMaxIdleCount,
                  int connectionPoolMaxIdleMinutes) {
        this(ip, dns, hostFirst, proxy, connTimeout, readTimeout, writeTimeout, dispatcherMaxRequests,
                dispatcherMaxRequestsPerHost, connectionPoolMaxIdleCount, connectionPoolMaxIdleMinutes, "");
    }

    /**
     * 构建一个自定义配置的 HTTP Client 类
     */
    public Client(final String ip, final Dns dns, final boolean hostFirst, final ProxyConfiguration proxy,
                  int connTimeout, int readTimeout, int writeTimeout, int dispatcherMaxRequests,
                  int dispatcherMaxRequestsPerHost, int connectionPoolMaxIdleCount,
                  int connectionPoolMaxIdleMinutes, String cachePath) {

        this.cc_url = String.format("%s/api", ip); // 控制机地址
        this.cachePath = cachePath;

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
        String tempUrl = url;
        signAndPrintLog(url, "GET", query);
        if (query.size() != 0) {
            url += query.formString();
        }
        Request.Builder requestBuilder = new Request.Builder().url(url).get();
        Response r = send(requestBuilder);
        // 如果返回403则重新刷新token并再次请求一次
        if (r.ret == 403) {
            r = resend(tempUrl, "GET", query);
        }
        return r;
    }

    public Response post(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "POST", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).post(body.toJson());
        Response r = send(requestBuilder);
        if (r.ret == 403) {
            r = resend(url, "POST", body);
        }
        return r;
    }

    public Response put(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "PUT", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).put(body.toJson());
        Response r = send(requestBuilder);
        if (r.ret == 403) {
            r = resend(url, "PUT", body);
        }
        return r;
    }

    public Response delete(String url, StringMap body) throws I2softException {
        signAndPrintLog(url, "DELETE", body);
        Request.Builder requestBuilder = new Request.Builder().url(url).delete(body.toJson());
        Response r = send(requestBuilder);
        if (r.ret == 403) {
            r = resend(url, "DELETE", body);
        }
        return r;
    }

    @NotNull
    private Response resend(String url, String method, StringMap body) throws I2softException {
        Request.Builder requestBuilder;
        Response r;
        signAndPrintLog(url, method, body);
        if (body.size() != 0) {
            url += body.formString();
        }
        switch (method) {
            case "POST":
                requestBuilder = new Request.Builder().url(url).post(body.toJson());
                break;
            case "PUT":
                requestBuilder = new Request.Builder().url(url).put(body.toJson());
                break;
            case "DELETE":
                requestBuilder = new Request.Builder().url(url).delete(body.toJson());
                break;
            case "GET":
            default:
                requestBuilder = new Request.Builder().url(url).get();
                break;
        }
        r = send(requestBuilder);
        return r;
    }

    // 加签名，打日志
    private void signAndPrintLog(String url, String method, StringMap args) {
        addSignToHeader(method, url, args);
        StringUtils.printLog("\nURL: [" + method + "] " + url
                + "\nHEADER: " + Json.encode(this.headers)
                + "\nARGS: " + Json.encode(args));
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
            if (e instanceof SocketTimeoutException) {
                String str = "{" +
                        "\"code\":11110001," +
                        "\"message\":\"Socket Timeout Exception\"" +
                        "}";
                return new Response(null, 500, tag.ip, duration, "timeout", str.getBytes(StandardCharsets.UTF_8), 500, "execute timeout");
            } else {
                throw new I2softException(e, e.getMessage());
            }
        }
        r = Response.create(res, tag.ip, duration);

        if (r.ret == 403) {
            StringUtils.printLog("Refresh token.");
            this.refreshToken();
            return r;
        }

        // err
        if (r.ret >= 300) {
            StringUtils.printLog("Http error code : " + r.ret + ", msg: " + r.msg);
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
        String enhance;
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
            StringBuilder signField = new StringBuilder();
            if (httpMethod.equals("GET")) {
                StringMap newArgs = args.removeEmptyValue();// 去除空值
                newArgs = new StringMap(ksort(newArgs));// 重新排序
                String temp = newArgs.formString();// 构建url参数
                signField.append(URLDecoder.decode(temp, "UTF-8"));
                signField.deleteCharAt(0);//删除url自动补全的问号
            } else {
                Map<String, Object> map = ksort(args);
                map.forEach((o, o2) -> {
                    if (!(o2 instanceof String)) {
                        o2 = Json.encode(o2);
                        o2 = ((String) o2).replaceAll("\\\\\\\\", "\\\\");//属性内的\\\\改为\\
                        o2 = ((String) o2).replaceAll("\\{}", "[]");//属性内的{}改为[]
                    }
                    if (o2.toString().isEmpty()) {
                        return;
                    }
                    signField.append(o).append("=").append(o2).append("&");
                });
                signField.deleteCharAt(signField.length() - 1);
            }
            String enhanceStr = signField.toString();
            enhanceStr = enhanceStr.replaceAll("\"", "");
            enhance = bytes2HexString(sha256_HMAC.doFinal(enhanceStr.getBytes(StandardCharsets.UTF_8))).toLowerCase();
            headers.put("enhanceStr", enhance);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
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

    // 自动刷新token
    public void refreshToken() throws I2softException {
        // http获取最新
        String url = String.format("%s/auth/refresh_token", this.cc_url); // 地址
        StringMap cache = new StringMap();
        String ip = this.cc_url.substring(0, this.cc_url.lastIndexOf("/api"));
        String token;
        String refreshToken;

        // 暂存缓存文件路径
        File cacheFile = new File(this.cachePath + "i2up-java-sdk-cache.json");

        try {
            cache = IOHelper.readJsonFile(cacheFile); // 读取token缓存文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        long timeStamp = System.currentTimeMillis() / 1000;

        // 请求refresh token接口并回写至缓存内
        StringMap body = new StringMap().put("refresh_token", (String) cache.get("refresh_token")); // 参数
        Response r = this.put(url, body);

        I2Rs.AuthRs authRs = Objects.requireNonNull(r.jsonToObject(I2Rs.AuthRs.class)); // 响应

        token = authRs.token;

        refreshToken = authRs.refresh_token;
        cache.put("time", timeStamp).put("ip", ip).put("token", token).put("refresh_token", refreshToken);
        this.auth.token = token;
        // 更新缓存
        try {
            cache.put("time", timeStamp).put("ip", ip).put("token", token).put("refresh_token", refreshToken);
            IOHelper.saveJsonFile(cacheFile, cache);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    // 实现php的ksort方法
    public static Map<String, Object> ksort(StringMap args) {
        Map<String, Object> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(args.map());
        return sortMap;
    }

    private static class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }
}
