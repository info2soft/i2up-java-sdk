package com.i2soft.util;

import com.i2soft.common.I2Rs;
import com.i2soft.common.I2softException;
import com.i2soft.http.Client;
import com.i2soft.http.Response;
import com.i2soft.common.Configuration;

import java.util.Objects;

public final class Auth {

    public String cc_url;
    public String token;
    public Client client;
    public Configuration configuration;

    private Auth(String cc_url, String token, Client client, Configuration configuration) {
        client.set_headers(new StringMap().put("Authorization", token));
        this.cc_url = cc_url;
        this.token = token;
        this.client = client;
        this.configuration = configuration;
    }

    /**
     * 获取token
     *
     * @param ip:
     * @param user:
     * @param pwd:
     * @param configuration:
     * @return Auth:
     * @throws I2softException:
     */
    public static Auth create(String ip, String user, String pwd, Configuration configuration) throws I2softException {
        if (StringUtils.isNullOrEmpty(ip) || StringUtils.isNullOrEmpty(user) || StringUtils.isNullOrEmpty(pwd)) {
            throw new IllegalArgumentException("empty key");
        }

        Client client = new Client(ip, configuration);
        String url = String.format("%s/auth/token", client.cc_url); // 地址
        StringMap body = new StringMap().put("username", user).put("pwd", pwd); // 参数
        Response r = client.post(url, body);
        String token = Objects.requireNonNull(r.jsonToObject(I2Rs.AuthRs.class)).token; // 响应
        return new Auth(client.cc_url, token, client, configuration);
    }
}
