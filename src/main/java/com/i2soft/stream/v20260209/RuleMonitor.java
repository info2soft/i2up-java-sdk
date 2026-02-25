package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RuleMonitor {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RuleMonitor(Auth auth) {
        this.auth = auth;
    }

    /**
     * 监控统计 - 机器节点折线图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveNodeChart(StringMap args) throws I2softException {
        String url = String.format("%s/stream/resource/node_chart", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 监控统计 - 机器节点资源占用
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveNodeResources(StringMap args) throws I2softException {
        String url = String.format("%s/stream/resource/node_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 监控统计 - 设置机器节点默认监控路径
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateNodeDefaultMonitorPath(StringMap args) throws I2softException {
        String url = String.format("%s/stream/resource/node_path", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 获取监控配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getSyncRuleMonitorConf() throws I2softException {
        String url = String.format("%s/vers/v3/stream/monitor", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 更新监控配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifySyncRuleMonitorConf(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/stream/monitor", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 监控信息导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportSyncRuleMonitorStat(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/statistics_export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 同步规则 - 规则状态监控 解析统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncRuleExtractStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/extract_statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 规则状态监控 装载统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncRuleLoadStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/load_statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 规则状态监控 表解析统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncRuleTableExtractStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/table_extract_statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 规则状态监控 表装载统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncRuleTableLoadStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/table_load_statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}