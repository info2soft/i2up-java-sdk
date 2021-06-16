package com.i2soft.common;

import com.i2soft.http.Client;
import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public final class Auth {
    /**
     * Auth 对象
     */
//    private final Auth auth;

    public static String AUTH_TYPE_TOKEN = "token";
    public static String AUTH_TYPE_AK_SK = "ak_sk";

    public String cc_url;

    public String token;
    public String sso_token;

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
        this.sso_token = sso_token;
        this.cachePath = cachePath;
        this.client = client;
        this.configuration = configuration;
        client.setAuth(this);
    }

    private Auth(String cc_url, String ak, String sk, Client client, Configuration configuration) {
        this.authType = AUTH_TYPE_AK_SK;
        this.cc_url = cc_url;
        this.ak = ak;
        this.sk = sk;
        this.client = client;
        this.configuration = configuration;
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
     * @param ip:
     * @param ak:
     * @param sk:
     * @param configuration:
     * @return Auth:
     */
    public static Auth access(String ip, String ak, String sk, Configuration configuration) {
        if (StringUtils.isNullOrEmpty(ip) || StringUtils.isNullOrEmpty(ak) || StringUtils.isNullOrEmpty(sk)) {
            throw new IllegalArgumentException("empty key");
        }

        Client client = new Client(ip, configuration);
        return new Auth(client.cc_url, ak, sk, client, configuration);
    }

    public static Auth access(String ip, String ak, String sk) {
        return access(ip, ak, sk, new Configuration());
    }

    /**
     * 获取token，构建 Auth 对象
     *
     * @param ip:            http://192.168.1.1:58080
     * @param user:
     * @param pwd:
     * @param cachePath:     E:\cache\
     * @param configuration:
     * @return Auth:
     * @throws I2softException :
     */
    public static Auth token(String ip, String user, String pwd, String cachePath, Configuration configuration) throws I2softException {
        if (StringUtils.isNullOrEmpty(ip) || StringUtils.isNullOrEmpty(user) || StringUtils.isNullOrEmpty(pwd)) {
            throw new IllegalArgumentException("empty key");
        }

        Client client = new Client(ip, configuration);

        String token;
        String ssoToken;
        StringMap cache = new StringMap();
        long timeStamp = System.currentTimeMillis() / 1000;
        File cacheFile = new File(cachePath + "i2up-java-sdk-cache.json");

        try {
            cache = IOHelper.readJsonFile(cacheFile); // 读取token缓存文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 没缓存，或缓存过期，就http获取最新的，并更新（创建）这个文件；有有效缓存，用缓存
        if (cache.size() == 0
                || (long) cache.get("time") < timeStamp - 3600 * 2
                || !cache.get("ip").equals(ip)
                || cache.get("token") == null
                || cache.get("sso_token") == null
        ) {
            // http获取最新
            String url = String.format("%s/auth/token", client.cc_url); // 地址
            StringMap body = new StringMap().put("username", user).put("pwd", pwd); // 参数
            Response r = client.post(url, body);
            I2Rs.AuthRs authRs = Objects.requireNonNull(r.jsonToObject(I2Rs.AuthRs.class)); // 响应

            token = authRs.token;
            ssoToken = authRs.sso_token;

            // 更新缓存
            try {
                cache.put("time", timeStamp).put("ip", ip).put("token", token).put("sso_token", ssoToken);
                IOHelper.saveJsonFile(cacheFile, cache);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            token = (String) cache.get("token");
            ssoToken = (String) cache.get("sso_token");
            if (Constants.LOG_HTTP) {
                StringUtils.printLog("Cache token: " + token + ", sso_token: " + ssoToken);
            }
        }

        return new Auth(client.cc_url, token, ssoToken, cachePath, client, configuration);
    }

    /**
     * auth-获取token
     *
     * @param
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public static Auth token(String ip, String user, String pwd, String cachePath) throws I2softException {
        return token(ip, user, pwd, cachePath, new Configuration());
    }

    // TODO: 后端没这个接口 2019.1.7
    public Map describePhoneCode(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/getPhoneCode", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToMap();
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
        Response r = this.client.get(url, new StringMap().put("access_token", this.sso_token));
        return Objects.requireNonNull(r.jsonToMap()).get("username").toString();
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
}
