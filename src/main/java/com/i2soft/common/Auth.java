package com.i2soft.common;

import com.i2soft.http.Client;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import com.i2soft.util.StringUtils;

import java.util.Map;
import java.util.Objects;

public final class Auth {

    public String cc_url;
    public String token;
    public String sso_token;
    public Client client;
    public Configuration configuration;

    private Auth(String cc_url, I2Rs.AuthRs authRs, Client client, Configuration configuration) {
        client.set_headers(new StringMap().put("Authorization", authRs.token));
        this.cc_url = cc_url;
        this.token = authRs.token;
        this.sso_token = authRs.sso_token;
        this.client = client;
        this.configuration = configuration;
    }

    /**
     * 获取token，构建 Auth 对象
     *
     * @param ip:
     * @param user:
     * @param pwd:
     * @param configuration:
     * @return Auth:
     * @throws I2softException :
     */
    public static Auth token(String ip, String user, String pwd, Configuration configuration) throws I2softException {
        if (StringUtils.isNullOrEmpty(ip) || StringUtils.isNullOrEmpty(user) || StringUtils.isNullOrEmpty(pwd)) {
            throw new IllegalArgumentException("empty key");
        }

        Client client = new Client(ip, configuration);
        String url = String.format("%s/auth/token", client.cc_url); // 地址
        StringMap body = new StringMap().put("username", user).put("pwd", pwd); // 参数
        Response r = client.post(url, body);
        I2Rs.AuthRs authRs = Objects.requireNonNull(r.jsonToObject(I2Rs.AuthRs.class)); // 响应
        return new Auth(client.cc_url, authRs, client, configuration);
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
