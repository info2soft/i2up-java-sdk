package com.i2soft.distributor;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DistributorSystem {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DistributorSystem(Auth auth) {
        this.auth = auth;
    }

    /**
     * 系统管理-获取配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSysSetting() throws I2softException {
        String url = String.format("%s/sys/settings", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 系统管理 - 更新配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSetting(StringMap args) throws I2softException {
        String url = String.format("%s/sys/settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 系统管理 - 命令列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map queueList(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/queue_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 系统管理 - 命令列表 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs queueDelete(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/queue_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 系统管理 - 一键升级 - 获取版本
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map upgradeVersion() throws I2softException {
        String url = String.format("%s/distribution/sys/upgrade_version", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 系统管理 - 一键升级
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs update(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/upgrade", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 系统管理 - 告警统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map alarmStat(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/alarm_stat", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 系统管理 - 告警日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map alarmLog(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/alarm_log", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 系统管理 - 告警日志 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/alarm_log_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新增用户
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createUser(StringMap args) throws I2softException {
        String url = String.format("%s/user", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改用户信息
     *
     * @param id: id
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyUser(Integer id, StringMap args) throws I2softException {
        String url = String.format("%s/user/%s", auth.cc_url, id);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 用户列表
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listUser(StringMap args) throws I2softException {
        String url = String.format("%s/user", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statUser(StringMap args) throws I2softException {
        String url = String.format("%s/user/stat", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步网关
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncGateway(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/sync_gateway", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步账号
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncAccount(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/sync_account", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取发送文件信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map sendFiles(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/sys/send_files", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}