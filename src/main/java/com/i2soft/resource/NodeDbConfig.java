package com.i2soft.resource;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class NodeDbConfig {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public NodeDbConfig(Auth auth) {
        this.auth = auth;
    }

    /**
     * 数据库配置信息-发现实例
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map nodeGetDatabaseInstances(StringMap args) throws I2softException {
        String url = String.format("%s/node/db_instances", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库信息配置 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createNodeDbConfig(StringMap args) throws I2softException {
        String url = String.format("%s/node/db_config", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库信息配置 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeDbConfig(StringMap args) throws I2softException {
        String url = String.format("%s/node/db_config", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}