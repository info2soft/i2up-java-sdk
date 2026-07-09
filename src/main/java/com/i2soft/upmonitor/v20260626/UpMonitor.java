package com.i2soft.upmonitor.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class UpMonitor {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public UpMonitor(Auth auth) {
        this.auth = auth;
    }

    /**
     * Dashborad-虚拟化概览
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map upMonitorVpRuleStat(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/vp_overall", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Dashboard-总览（系统概览）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map upMonitorOverall(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/overall", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 平台监控-概览概要
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitorPlatSummary(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/plat_summary", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 平台监控 - 事件记录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 平台监控 - 事件记录下载
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public byte[] downloadStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/statistics/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 平台监控 - 规则监控
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitorRules(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 平台监控-操作日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/op_log", auth.cc_url);
        args.put("download", false);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    public byte[] downloadOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/op_log", auth.cc_url);
        args.put("download", true);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 平台监控 - 用户信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUser(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/user", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 平台监控 - 用户导出
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] exportUsers(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/user/export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 子平台 - 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 获取子平台token
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUpMonitorToken(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/token", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyUpMonitor(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUpMonitor(String uuid) throws I2softException {
        String url = String.format("%s/up_monitor/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 子平台 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refreshUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUpMonitorStatus(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 子平台 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteUpMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/up_monitor", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}