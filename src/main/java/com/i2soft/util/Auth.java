package com.i2soft.util;

import com.i2soft.common.I2Result;
import com.i2soft.common.I2softException;
import com.i2soft.http.Client;
import com.i2soft.http.Response;
import com.i2soft.common.Configuration;

import java.util.Objects;

public final class Auth {

    public String url_prefix;
    public String token;
    public Client client;
    public Configuration configuration;

    private Auth(String url_prefix, String token, Client client, Configuration configuration) {
        client.set_headers(new StringMap().put("Authorization", token));
        this.url_prefix = url_prefix;
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

        String url_prefix = String.format("http://%s:58080/api", ip); // 地址
        String url = url_prefix + "/auth/token"; // 地址
        Client client = new Client(configuration);
        StringMap body = new StringMap().put("username", user).put("pwd", pwd); // 参数
        Response r = client.post(url, body);
        String token = Objects.requireNonNull(r.jsonToObject(I2Result.AuthRs.class)).token; // 响应
        return new Auth(url_prefix, token, client, configuration);
    }
}
