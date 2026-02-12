package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class MaskRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public MaskRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 数据安全总览
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummary() throws I2softException {
        String url = String.format("%s/vers/v3/mask/summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 数据安全总览 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryView(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/summary/list_view", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 脱敏规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMaskRules(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 脱敏规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createMaskRules(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 脱敏规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startMaskRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 脱敏规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopMaskRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 脱敏规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteMaskRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 脱敏规则 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeMaskRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 脱敏规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMaskRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 脱敏规则 - 导入脱敏文件配置
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map importMaskRuleInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/import_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}