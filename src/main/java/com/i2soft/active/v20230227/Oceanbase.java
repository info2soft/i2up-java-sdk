package com.i2soft.active.v20230227;


import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Oceanbase {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Oceanbase(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步规则列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOceanRule() throws I2softException {
        String url = String.format("%s/ocean/rule", auth.cc_url);
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
    public I2Rs.I2SmpRs createOceanRule(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 批量新建规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBatchOceanRule(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改规则
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyOceanRule() throws I2softException {
        String url = String.format("%s/ocean/rule", auth.cc_url);
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
    public Map describeOceanRule(Integer id) throws I2softException {
        String url = String.format("%s/ocean/rule/%s", auth.cc_url, id);
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
    public Map deleteOceanRule(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule", auth.cc_url);
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
    public I2Rs.I2SmpRs resumeOceanRule(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule/operate", auth.cc_url);
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
    public I2Rs.I2SmpRs listOceanRuleLog(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Oceanbase表修复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createOceanTableFix(StringMap args) throws I2softException {
        String url = String.format("%s/ocean/rule/table_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}