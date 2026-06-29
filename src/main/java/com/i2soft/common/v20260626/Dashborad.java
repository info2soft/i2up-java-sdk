package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dashborad {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dashborad(Auth auth) {
        this.auth = auth;
    }

    /**
     * Dashboard-统一监控平台
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map upMonitorOverall() throws I2softException {
        String url = String.format("%s/dashboard/up_monitor_overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Dashboard-整体状态统计
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map overall() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Dashboard-sysadmin
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map sysadmin() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/user_summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 总览V8
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statusOverall() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/status_overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 总览
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDashboardStatOverall(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/stat_overall", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 总览 日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallLogs(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/overall_logs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 资源管理&存储管理
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallResourceSta() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/overall_resource", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 实时数据复制
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallRealTimeCopy() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/overall_real_time_copy", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 应用高可用
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallHa() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/overall_ha", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 副本管理
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallCdm() throws I2softException {
        String url = String.format("%s/dashboard/overall_cdm", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 系统迁移
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallFspMv() throws I2softException {
        String url = String.format("%s/dashboard/overall_fsp_mv", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 节点/复制规则 兼容6.1
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map nodeRepSummary(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/node_rep_summary", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 虚机概览，获取任务成功率
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRuleStat(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/vp_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 周期性定时数据复制规则概览
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSchedule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/schedule_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 总览 大数据冷热数据
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDashboardHotColdData() throws I2softException {
        String url = String.format("%s/dashboard/hot_cold_data", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 总览 - 板块信息 - 更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateDashboardPlate(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/plate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 总览 - 板块信息 - 获取
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDashboardPlate() throws I2softException {
        String url = String.format("%s/vers/v3/dashboard/plate", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}