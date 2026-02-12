package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class TrafficReport {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public TrafficReport(Auth auth) {
        this.auth = auth;
    }

    /**
     * 报表规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/report_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 报表规则 - 查看报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listReportRuleStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/report_rule/statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 报表规则 - 导出历史
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listReportRuleHistory(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/report_rule/history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}