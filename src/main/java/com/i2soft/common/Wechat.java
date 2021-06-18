package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Wechat {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Wechat(Auth auth) {
        this.auth = auth;
    }

    /**
     * 用户 - 绑定微信
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map bindUser(StringMap args) throws I2softException {
        String url = String.format("%s/wechat/bind", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 用户 - 解绑微信
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs unbindUser() throws I2softException {
        String url = String.format("%s/wechat/unbind", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取用户绑定状态
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map bindStatus() throws I2softException {
        String url = String.format("%s/wechat/bind", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}