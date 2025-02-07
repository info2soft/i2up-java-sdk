package com.i2soft.retentionPolicy.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RetentionPolicy {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RetentionPolicy(Auth auth) {
        this.auth = auth;
    }

    /**
     * 全局保留期限设置 - 获取列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRetentionPolicy() throws I2softException {
        String url = String.format("%s/retention_policy", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 全局保留期限设置 - 修改保留期限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyRetentionPoliciy(StringMap args) throws I2softException {
        String url = String.format("%s/retention_policy", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}