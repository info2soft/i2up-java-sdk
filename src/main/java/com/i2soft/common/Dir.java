package com.i2soft.common;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dir {
    /**
     * Auth 对象
     */
    private final Auth auth;
    private String module_url;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dir(Auth auth) {
        this.auth = auth;
        this.module_url = auth.cc_url + "/dir";
    }

    /**
     * 检查路径
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public Map checkDir(StringMap args) throws I2softException {
        String url = String.format("%s/check", module_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 列举（子）目录结构
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDir(StringMap args) throws I2softException {
        Response r = auth.client.get(module_url);
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取控制台主机IP
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCCip() throws I2softException {
        Response r = auth.client.get(String.format("%s/ips", module_url));
        return r.jsonToObject(Map.class);
    }
}
