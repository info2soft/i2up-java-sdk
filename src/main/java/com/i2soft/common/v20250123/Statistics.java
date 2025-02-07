package com.i2soft.common.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Statistics {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Statistics(Auth auth) {
        this.auth = auth;
    }

    /**
     * 事件记录 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 事件记录 - 单条详情
     *
     * @param id: id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStatistics(Integer id) throws I2softException {
        String url = String.format("%s/statistics/%s", auth.cc_url, id);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 事件记录 - 标为已读
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map readStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/statistics", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 事件统计 - 整体统计 - 按功能统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsChart(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/chart", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 统计报表 - 发送配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateStatisticsConfig(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/config", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 统计报表 - 获取配置信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsConfig() throws I2softException {
        String url = String.format("%s/statistics/config", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 事件记录 - 下载
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map downloadStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 事件统计 - 整体统计下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadStatisticsChart(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/chart_download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 事件统计 - 整体统计 - 按规则统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public byte[] listStatisticsRuleChart(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/rule_chart", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 事件统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsTrendChart(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/trend_chart", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 事件统计 - 获取显示项目
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsDisplayItems() throws I2softException {
        String url = String.format("%s/statistics/display_items", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 事件统计 - 设置显示项目
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs setStatisticsDisplayItems(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/display_items", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}