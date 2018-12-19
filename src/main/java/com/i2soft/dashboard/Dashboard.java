package com.i2soft.dashboard;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dashboard {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dashboard(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map node(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 高可用列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map ha(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 虚机规则 成功率
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpRuleRate(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/vp_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 虚机 保护率
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVmProtectRate(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/vp_vm", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }
}
