package com.i2soft.fspRecoveryRule.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class FspRecoveryRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public FspRecoveryRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 整机恢复 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机恢复 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyFspRecoveryRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rebootFspRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 获取BIOS类型
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getFspRecoveryRuleBiosType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/bios_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机恢复 - 目标机驱动URL列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryRuleDriverListUrl() throws I2softException {
        String url = String.format("%s/vers/v3/fsp/recovery_rule/driver_url_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}