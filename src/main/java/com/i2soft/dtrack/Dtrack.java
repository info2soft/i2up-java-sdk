package com.i2soft.dtrack;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dtrack {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dtrack(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取工作机设备列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackupDev(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/dev", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询工作机系统信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackupSystemInfo(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/system_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 检查是否重名
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyDtrackBackupName(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/verify_name", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDtrackBackup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDtrackBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackBackup(String uuid) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 策略 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDtrackBackup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/dtrack/backup/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 策略 - 添加历史记录（底层调）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addDtrackBackupHistory(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s/history", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略 - 查询历史记录
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackupHistory(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s/history", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 获取快照列表
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackBackupSnap(String uuid) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s/snap", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 安装卸载驱动
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs dtrackBackupCtlDrv(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/ctl_drv", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 重启系统
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs dtrackBackupRebootSystem(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/reboot", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略 - 获取服务功能
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map dtrackBackupFeatureMatrix(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/feature_matrix", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI发起者 - 获取名称
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackNodeInitiatorName(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/initiator_name", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI发起者 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackNodeInitiatorStatus(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/initiator_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI发起者 - 获取版本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackNodeInitiatorVersion(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/initiator_version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * MySQL - 配置访问参数
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs mysqlConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/mysql_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * MySQL - 获取访问参数
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/mysql_conf", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * MySQL - 获取数据库名
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlDb(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/mysql_db", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Oracle - 配置访问参数
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs oracleConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/oracle_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Oracle - 获取访问参数
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOracleConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/oracle_conf", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Oracle - 获取表空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOracleDb(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/oracle_db", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * SqlServer - 配置访问参数
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map sqlserverConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/sqlserver_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * SqlServer - 获取访问参数副本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSqlserverConf(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/node/sqlserver_conf", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 获取目标端列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackRecoveryTarget(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/recovery/target", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 是否发现目标端
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackRecoveryTargetDiscovered(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/recovery/target_discovered", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略组 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDtrackGroup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略组 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDtrackGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略组 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtrackGroup(String uuid) throws I2softException {
        String url = String.format("%s/dtrack/group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 策略组 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackGroup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略组 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackGroupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略组 - 更新绑定
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map updateDtrackGroupBind(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group/%s/bind", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略 - 更新绑定
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateDtrackBackupBind(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/backup/%s/bind", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略组 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteDtrackGroup(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 策略组 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/dtrack/group/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 策略组 - 获取快照列表
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtrackGroupSnap(String uuid) throws I2softException {
        String url = String.format("%s/dtrack/group/%s/snap", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}