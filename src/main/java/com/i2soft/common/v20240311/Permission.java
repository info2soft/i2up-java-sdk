package com.i2soft.common.v20240311;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Permission {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Permission(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取权限列表
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listPermission() throws I2softException {
        String url = String.format("%s/permission", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}