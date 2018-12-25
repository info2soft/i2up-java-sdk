package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GeneralInterface {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GeneralInterface(Auth auth) {
        this.auth = auth;
    }

    /**
     * 版本信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVersion() throws I2softException {
        String url = String.format("%s/version", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * migrate
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateDatabase() throws I2softException {
        String url = String.format("%s/migrate", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 统计详情
     *
     * @param id: id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStatistics(Integer id) throws I2softException {
        String url = String.format("%s/statistics/%s", auth.cc_url, id);
        Response r = auth.client.get(url);
        return r.jsonToObject(Map.class);
    }

    /**
     * 标为已读
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map readStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/statistics", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(Map.class);
    }
}