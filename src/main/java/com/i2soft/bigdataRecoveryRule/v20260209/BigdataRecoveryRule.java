package com.i2soft.bigdataRecoveryRule.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BigdataRecoveryRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BigdataRecoveryRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 大数据恢复 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/recovery_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据恢复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBigdataRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/recovery_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据恢复 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBigdataRecoveryRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据恢复 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigdataRecoveryRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大数据恢复 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataRecoveryRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/recovery_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}