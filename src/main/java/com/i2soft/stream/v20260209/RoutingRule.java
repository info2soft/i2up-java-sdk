package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RoutingRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RoutingRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 巡检规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createStreamReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 巡检规则 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStreamReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 巡检规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 巡检规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamReportRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 巡检规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteStreamReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 巡检规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateStreamReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 巡检规则 - 导出历史
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listStreamReportRuleHistory(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream_routing/history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 更新巡检kafka推送配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStreamRoutingConf(StringMap args) throws I2softException {
        String url = String.format("%s/stream_routing/config", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 查看巡检kafka推送配置副本
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamRoutingConf() throws I2softException {
        String url = String.format("%s/stream_routing/config", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 巡检规则 - 删除历史
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteReportRuleHistory(StringMap args) throws I2softException {
        String url = String.format("%s/stream_routing/history", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 巡检规则 - 获取巡检结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listReportRuleResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream_routing/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 巡检规则 - 获取资源
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBizGroupResource(StringMap args) throws I2softException {
        String url = String.format("%s/stream_routing/get_rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}