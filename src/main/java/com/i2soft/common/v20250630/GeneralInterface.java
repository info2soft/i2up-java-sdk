package com.i2soft.common.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GeneralInterface {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GeneralInterface(Auth auth) {
        this.auth = auth;
    }

    /**
     * 版本信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVersion() throws I2softException {
        String url = String.format("%s/version", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 新版本信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map latestVersion(StringMap args) throws I2softException {
        String url = String.format("%s/check/latest_version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取版本提交记录
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVersionHistory() throws I2softException {
        String url = String.format("%s/version_history", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 连接测试
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs nodeConnectTest(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/node/connect_test", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
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
        String url = String.format("%s/dashboard/overall", auth.cc_url);
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
        String url = String.format("%s/dashboard/user_summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 总览
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statusOverall() throws I2softException {
        String url = String.format("%s/dashboard/status_overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 概览 - 数据集成 总览
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statusStreamOverall() throws I2softException {
        String url = String.format("%s/dashboard/stream_overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
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
        String url = String.format("%s/dashboard/overall_logs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 概览 - 资源管理
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOverallResourceSta() throws I2softException {
        String url = String.format("%s/dashboard/overall_resource", auth.cc_url);
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
        String url = String.format("%s/dashboard/overall_real_time_copy", auth.cc_url);
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
        String url = String.format("%s/dashboard/overall_ha", auth.cc_url);
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
        String url = String.format("%s/dashboard/vp_rule", auth.cc_url);
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
        String url = String.format("%s/dashboard/schedule_list", auth.cc_url);
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
     * 概览 - 总览V9
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDashboardStatOverall(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/stat_overall", auth.cc_url);
        Response r = auth.client.get(url, args);
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
        String url = String.format("%s/dashboard/plate", auth.cc_url);
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
        String url = String.format("%s/dashboard/plate", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 展示列 - 新建|修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createColumnExt(StringMap args) throws I2softException {
        String url = String.format("%s/column_list", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 展示列 - 单个
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeColumnext(StringMap args) throws I2softException {
        String url = String.format("%s/column_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 导出规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] exportRules(StringMap args) throws I2softException {
        String url = String.format("%s/export_rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 导入规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs importRules(StringMap args) throws I2softException {
        String url = String.format("%s/import_rules", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsReport(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/report", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 签署CSR
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map csrSign(StringMap args) throws I2softException {
        String url = String.format("%s/pki/csr_sign", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 证书清单
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCerts() throws I2softException {
        String url = String.format("%s/pki/certs", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 下载根证书
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public byte[] downloadCa() throws I2softException {
        String url = String.format("%s/pki/download_ca", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * 异步rpc任务列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRpcTask() throws I2softException {
        String url = String.format("%s/rpc_task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 后台任务列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCronTask() throws I2softException {
        String url = String.format("%s/cron_task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 后台任务删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCronTask(StringMap args) throws I2softException {
        String url = String.format("%s/cron_task", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}