package com.i2soft.common.v20240819;

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
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPermission() throws I2softException {
        String url = String.format("%s/permission", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 权限 - 类别
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listCategory() throws I2softException {
        String url = String.format("%s/permission/category", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 权限 - 类别权限
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCatPerms(StringMap args) throws I2softException {
        String url = String.format("%s/permission/cat_perms", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 权限 - 类别权限（9版本双门户）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCatPerms9(StringMap args) throws I2softException {
        String url = String.format("%s/permission/cat_perms9", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}