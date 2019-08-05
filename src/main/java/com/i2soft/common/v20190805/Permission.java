package com.i2soft.common.v20190805;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;

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
     * categories
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCategory() throws I2softException {
        String url = String.format("%s/permission/category", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 权限 - 类别权限
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCatPerms() throws I2softException {
        String url = String.format("%s/permission/cat_perms", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToObject(Map.class);
    }
}