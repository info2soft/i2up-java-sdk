package com.i2soft.dashboard.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dashboard {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dashboard(Auth auth) {
        this.auth = auth;
    }

    /**
     * 资源概览（旧）
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resourceView() throws I2softException {
        String url = String.format("%s/dashboard/source", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取资源池列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupCenter() throws I2softException {
        String url = String.format("%s/dashboard/list_backup_center", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取资源使用率和保护覆盖率
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getBackupCenterInfo(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/backup_center_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取接管、演练平台列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHosts() throws I2softException {
        String url = String.format("%s/dashboard/list_hosts", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 设置资源保护覆盖率
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resourceProtectionCoverage(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/resource_protection_coverage", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 任务概览列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map taskView() throws I2softException {
        String url = String.format("%s/dashboard/task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 5 Dashboard - 获取规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map repBackup(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/rep", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Dashboard - 高可用列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map ha() throws I2softException {
        String url = String.format("%s/dashboard/ha", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 3 Dashboard - 获取节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map node(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}