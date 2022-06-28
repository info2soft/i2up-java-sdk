package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Menu {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Menu(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取菜单列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMenu() throws I2softException {
        String url = String.format("%s/menu", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}