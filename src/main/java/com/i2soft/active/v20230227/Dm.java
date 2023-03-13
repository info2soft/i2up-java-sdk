package com.i2soft.active.v20230227;


import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dm {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dm(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步规则列
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDmRule() throws I2softException {
        String url = String.format("%s/dm/rule", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 新建规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createDmRule(StringMap args) throws I2softException {
        String url = String.format("%s/dm/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改规则
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDmRule() throws I2softException {
        String url = String.format("%s/dm/rule", auth.cc_url);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 单条规则
     *
     * @param id: id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDmRule(Integer id) throws I2softException {
        String url = String.format("%s/dm/rule/%s", auth.cc_url, id);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDmRule(StringMap args) throws I2softException {
        String url = String.format("%s/dm/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeDmRule(StringMap args) throws I2softException {
        String url = String.format("%s/dm/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 日志
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listDmRuleLog(StringMap args) throws I2softException {
        String url = String.format("%s/dm/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}