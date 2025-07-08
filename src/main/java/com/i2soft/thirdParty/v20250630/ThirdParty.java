package com.i2soft.thirdParty.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ThirdParty {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ThirdParty(Auth auth) {
        this.auth = auth;
    }

    /**
     * 第三方系统接入- 获取跳转url
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getThirdPartiesUrl(StringMap args) throws I2softException {
        String url = String.format("%s/third_parties/url", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}