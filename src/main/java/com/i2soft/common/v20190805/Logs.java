package com.i2soft.common.v20190805;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Logs {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Logs(Auth auth) {
        this.auth = auth;
    }

    /**
     * 规则/任务日志（uuid）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTaskLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * HA日志（uuid_m_uuid）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHALog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点日志（m_uuid）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 任务日志
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNpsvrLog() throws I2softException {
        String url = String.format("%s/logs/npsvr", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * logs.traffic
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTrafficLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/traffic", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取操作日志列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/op_log", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除操作日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/op_log", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}