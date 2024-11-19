package com.i2soft.common;

import com.i2soft.http.Client;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Configuration;
import com.i2soft.util.IOHelper;
import com.i2soft.util.StringMap;
import com.i2soft.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import static com.i2soft.http.Client.bytes2HexString;

public final class Auth {
    /**
     * Auth 对象
     */
//    private final Auth auth;

    public static String AUTH_TYPE_TOKEN = "token";
    public static String AUTH_TYPE_AK_SK = "ak_sk";
    public static String cachePathDefault = "";
    public static String ccUrlDefault = "";
    public static Client clientDefault = null;

    public String cc_url;

    public String token;
    public String refresh_token;

    public String ak;
    public String sk;

    public String authType;

    public String cachePath;
    public Client client;

    public Configuration configuration;

    private Auth(String cc_url, String token, String sso_token, String cachePath, Client client, Configuration configuration) {
        this.authType = AUTH_TYPE_TOKEN;
        this.cc_url = cc_url;
        this.token = token;
        this.refresh_token = sso_token;
        this.cachePath = cachePath;
        this.client = client;
        this.configuration = configuration;
        cachePathDefault = cachePath;
        ccUrlDefault = cc_url;
        clientDefault = client;
        client.setAuth(this);
    }

    private Auth(String cc_url, String ak, String sk, Client client, String cachePath, Configuration configuration) {
        this.authType = AUTH_TYPE_AK_SK;
        this.cc_url = cc_url;
        this.ak = ak;
        this.sk = sk;
        this.cachePath = cachePath;
        this.client = client;
        this.configuration = configuration;
        cachePathDefault = cachePath;
        ccUrlDefault = cc_url;
        clientDefault = client;
        client.setAuth(this);
    }

    /**
     * 短信-1.时间戳
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeTimeStamp(StringMap args) throws I2softException {
        String url = String.format("%s/auth/t", this.cc_url);
        Response r = this.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 短信-2.生成短信、邮件、图片验证码关联信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs authGenerate() throws I2softException {
        String url = String.format("%s/auth/generate", this.cc_url);
        Response r = this.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-获取手机、邮件、图片验证码
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeVerificationCode(StringMap args) throws I2softException {
        String url = String.format("%s/auth/verification_code", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-检查用户是否需要验证码
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs checkCaptcha(StringMap args) throws I2softException {
        String url = String.format("%s/auth/check_captcha", this.cc_url);
        Response r = this.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用 ACCESS-KEY，构建 Auth 对象
     *
     * @param addr:
     * @param ak:
     * @param sk:
     * @param configuration:
     * @return Auth:
     */
    @Deprecated
    public static Auth access(String addr, String ak, String sk, Configuration configuration) {
        return access(addr, ak, sk, "", configuration);
    }

    /**
     * 用 ACCESS-KEY，构建 Auth 对象
     *
     * @param addr:
     * @param ak:
     * @param sk:
     * @param configuration:
     * @return Auth:
     */
    public static Auth access(String addr, String ak, String sk, String cachePath, Configuration configuration) {
        if (StringUtils.isNullOrEmpty(addr) || StringUtils.isNullOrEmpty(ak) || StringUtils.isNullOrEmpty(sk)) {
            throw new IllegalArgumentException("empty ip or ak/sk key");
        }

        Client client = new Client(addr, configuration);
        return new Auth(client.cc_url, ak, sk, client, cachePath, configuration);
    }

    /**
     * Deprecated: Use Auth access(String addr, String ak, String sk, String cachePath) instead
     * @param addr
     * @param ak
     * @param sk
     * @return
     */
    @Deprecated
    public static Auth access(String addr, String ak, String sk) {
        return access(addr, ak, sk, new Configuration());
    }

    public static Auth access(String addr, String ak, String sk, String cachePath) {
        return access(addr, ak, sk, cachePath, new Configuration());
    }

    /**
     * 获取token，构建 Auth 对象
     *
     * @param addr:            https://192.168.1.1:58086
     * @param user:
     * @param pwd:
     * @param cachePath:     E:\cache\
     * @param configuration:
     * @return Auth:
     * @throws I2softException :
     */
    public static Auth token(String addr, String user, String pwd, String cachePath, Configuration configuration) throws I2softException {
        if (StringUtils.isNullOrEmpty(addr) || StringUtils.isNullOrEmpty(user) || StringUtils.isNullOrEmpty(pwd)) {
            throw new IllegalArgumentException("empty key");
        }

        Client client = new Client(addr, configuration, cachePath);

        String token;
        String refreshToken;
        StringMap cache = new StringMap();
        long timeStamp = System.currentTimeMillis() / 1000;
        // 通过ip生成hash作为路径
        String hash = "temp";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(addr.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            hash = bytes2HexString(sha256_HMAC.doFinal(addr.getBytes())).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        File cacheFile = new File(cachePath + "/" + hash + "/up-java-sdk-cache.json");

        try {
            cache = IOHelper.readJsonFile(cacheFile); // 读取token缓存文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 没缓存，或缓存过期，就http获取最新的，并更新（创建）这个文件；有有效缓存，用缓存
        if (cache.size() == 0
                || (long) cache.get("time") < timeStamp - 60 * 10
                || !cache.get("ip").equals(addr)
                || cache.get("token") == null
                || cache.get("refresh_token") == null
        ) {
            // http获取最新
            String url = String.format("%s/auth/token", client.cc_url); // 地址
            StringMap body = new StringMap().put("username", user).put("password", pwd).put("pwd", pwd); // 参数
            Response r = client.post(url, body);
            I2Rs.AuthRs authRs = Objects.requireNonNull(r.jsonToObject(I2Rs.AuthRs.class)); // 响应

            Integer code = authRs.code;
            if (code != 0) {
                throw new IllegalArgumentException("token generate failed" + authRs.code + " - " + authRs.message);
            }
            token = authRs.token;
            refreshToken = authRs.refresh_token;
            // 更新缓存
            try {
                cache.put("time", timeStamp).put("ip", addr).put("token", token).put("refresh_token", refreshToken);
                IOHelper.saveJsonFile(cacheFile, cache);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            token = (String) cache.get("token");
            refreshToken = (String) cache.get("refresh_token");
            StringUtils.printLog("Cache token: " + token + ", refresh_token: " + refreshToken);
        }

        return new Auth(client.cc_url, token, refreshToken, cachePath, client, configuration);
    }

    /**
     * auth-获取token
     *
     * @param
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public static Auth token(String addr, String user, String pwd, String cachePath) throws I2softException {
        return token(addr, user, pwd, cachePath, new Configuration());
    }

    /**
     * auth-注册账号(不开放)
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs regAccount(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/register", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-重置密码
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resetPwd(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/reset_password", this.cc_url);
        return this.client.post(url, args).jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-check用户登录状态
     *
     * @return username
     * @throws I2softException:
     */
    public String checkLoginStatus() throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/token", this.cc_url);
        Response r = this.client.get(url, new StringMap().put("refresh_token", this.refresh_token));
        return Objects.requireNonNull(r.jsonToMap()).toString();
    }

    /**
     * auth-是否超时或账号失效
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs heartbeat(StringMap args) throws I2softException {
        String url = String.format("%s/auth/heartbeat", this.cc_url);
        Response r = this.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    public static String getCachePath() {
        return cachePathDefault;
    }

    public static String getCcUrlDefault() {
        return ccUrlDefault;
    }

    public static Client getClientDefault() {
        return clientDefault;
    }
}
