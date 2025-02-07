package com.i2soft.vpRecoveryRule.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class VpRecoveryRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public VpRecoveryRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyVpRecoveryRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/recovery_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpRecoveryRule(String uuid) throws I2softException {
        String url = String.format("%s/vp/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVpRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map operateVpRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecoveryRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/recovery_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}