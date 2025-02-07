package com.i2soft.guardData.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GuardData {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GuardData(Auth auth) {
        this.auth = auth;
    }

    /**
     * 节点管理 - 检查防篡改功能是否可用
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map nodeGuardDataEnabled(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data/node_guard_data_enabled", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点策略列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGuardData(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建策略
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createGuardData(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改策略
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyGuardData(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/guard_data/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除策略
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteGuardData(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取防篡改节点状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data/node_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点数据保护日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGuardDataLogs(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data/list_guard_data_logs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 威胁感知
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map threatPerception(StringMap args) throws I2softException {
        String url = String.format("%s/guard_data/threat_perception", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}