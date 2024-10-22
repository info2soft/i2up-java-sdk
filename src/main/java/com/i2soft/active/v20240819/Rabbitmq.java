package com.i2soft.active.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Rabbitmq {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Rabbitmq(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步规则 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRabbitmqRule() throws I2softException {
        String url = String.format("%s/rabbitmq/rule", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRabbitMqRule(StringMap args) throws I2softException {
        String url = String.format("%s/rabbitmq/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 修改
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyRabbitmqRule() throws I2softException {
        String url = String.format("%s/rabbitmq/rule", auth.cc_url);
        Response r = auth.client.put(url, new StringMap());
        return r.body();
    }

    /**
     * 同步规则 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRabbitmqRule(String uuid) throws I2softException {
        String url = String.format("%s/rabbitmq/rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRabbitmqRule(StringMap args) throws I2softException {
        String url = String.format("%s/rabbitmq/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeRabbitmqRule(StringMap args) throws I2softException {
        String url = String.format("%s/rabbitmq/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopRabbitmqRule(StringMap args) throws I2softException {
        String url = String.format("%s/rabbitmq/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRulesStatus(StringMap args) throws I2softException {
        String url = String.format("%s/rabbitmq/rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}