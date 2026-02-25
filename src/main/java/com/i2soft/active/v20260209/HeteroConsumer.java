package com.i2soft.active.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class HeteroConsumer {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public HeteroConsumer(Auth auth) {
        this.auth = auth;
    }

    /**
     * 消费规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listConsumerRules(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 消费规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createConsumerRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 消费规则 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyConsumerRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 消费规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteConsumerRules(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 消费规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listConsumerStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 消费规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopConsumerRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 消费规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeConsumerRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 消费规则 - 获取单条
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeConsumerRules(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 消费规则 - 导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportConsumerRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 消费规则 - 导入映射文件配置副本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map importHeteroConsumerTopicMapping(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/consumer_rule/import_topic_mapping/", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}