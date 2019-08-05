package com.i2soft.upmonitor.v20190805;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class UpMonitor {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public UpMonitor(Auth auth) {
        this.auth = auth;
    }

    /**
     * 子平台 - 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 获取子平台token
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUpMonitorToken(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/token", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyUpMonitor(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUpMonitor(String uuid) throws I2softException {
        String url = String.format("%s/up_monitor/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refreshUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitorStatus(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 子平台 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(Map.class);
    }
}