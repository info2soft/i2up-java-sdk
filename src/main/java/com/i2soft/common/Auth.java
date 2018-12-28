package com.i2soft.common;

import com.i2soft.http.Client;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Configuration;
import com.i2soft.util.IOHelper;
import com.i2soft.util.StringMap;
import com.i2soft.util.StringUtils;

import java.io.*;
import java.util.Map;
import java.util.Objects;

public final class Auth {

    public String cc_url;
    public String token;
    public String sso_token;
    public String cachePath;
    public Client client;
    public Configuration configuration;

    private Auth(String cc_url, String token, String sso_token, String cachePath, Client client, Configuration configuration) {
        client.set_headers(new StringMap().put("Authorization", token));
        this.cc_url = cc_url;
        this.token = token;
        this.sso_token = sso_token;
        this.cachePath = cachePath;
        this.client = client;
        this.configuration = configuration;
    }

    /**
     * 获取token，构建 Auth 对象
     *
     * @param ip: http://192.168.1.1:58080
     * @param user:
     * @param pwd:
     * @param cachePath: E:\cache\
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
        double timeStamp = (double) System.currentTimeMillis() / 1000;
        File cacheFile = new File(cachePath + "i2up-java-sdk-cache.json");

        try {
            cache = IOHelper.readJsonFile(cacheFile); // 读取token缓存文件
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 没缓存，或缓存过期，就http获取最新的，并更新（创建）这个文件；有有效缓存，用缓存
        if (cache.size() == 0 || (double) cache.get("time") < timeStamp - 3600 * 2 || !cache.get("ip").equals(ip)) {
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
        }

        return new Auth(client.cc_url, token, ssoToken, cachePath, client, configuration);
    }

    public Map describePhoneCode(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/getPhoneCode", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    public I2Rs.I2SmpRs regAccount(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/register", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    public I2Rs.I2SmpRs resetPwd(StringMap args) throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/reset/password", this.cc_url);
        Response r = this.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 返回登陆的用户名
     *
     * @return username
     * @throws I2softException :
     */
    public String checkLoginStatus() throws I2softException {
        if (StringUtils.isNullOrEmpty(this.token)) {
            throw new IllegalArgumentException("empty key");
        }
        String url = String.format("%s/auth/reset/password", this.cc_url);
        Response r = this.client.get(url, new StringMap().put("assess_token", this.sso_token));
        return Objects.requireNonNull(r.jsonToObject(StringMap.class)).get("username").toString();
    }
}
