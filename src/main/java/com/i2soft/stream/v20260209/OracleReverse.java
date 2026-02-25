package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class OracleReverse {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public OracleReverse(Auth auth) {
        this.auth = auth;
    }

    /**
     * 反向规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createReverse(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_reverse", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}