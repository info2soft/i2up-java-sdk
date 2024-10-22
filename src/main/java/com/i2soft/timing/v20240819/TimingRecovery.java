package com.i2soft.timing.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class TimingRecovery {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public TimingRecovery(Auth auth) {
        this.auth = auth;
    }

    /**
     * 2-1 恢复 准备-2 恢复 获取还原时间点 - Mssql
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryMssqlTime(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_mssql_time", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-1 恢复 准备-3 恢复 获取Mssql初始信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingRecoveryMssqlInitInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_mssql_init_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-1 恢复 准备-1 恢复 获取还原时间点 - 文件
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryPathList(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_path_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-1 恢复 准备-4 恢复 认证MsSql数据库
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyTimingRecoveryMssqlInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_verify_mssql_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 恢复 准备 获取oracle恢复点日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryOracleRcPointInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_sbt", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复 准备 获取MySQL备份目录信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRcMysqlInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_mysql_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复 获取控制文件参数文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSbtContrlFile(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/sbt_contrlfile", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复 获取DBID
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSbtDbid(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/sbt_dbid", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-2 恢复 新建/编辑-1 恢复 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2-2 恢复 新建/编辑-3 恢复 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTimingRecovery(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2-2 恢复 新建/编辑-2 恢复 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingRecovery(String uuid) throws I2softException {
        String url = String.format("%s/timing/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2-3 恢复 列表-1 恢复 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-3 恢复 列表-3 恢复 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-3 恢复 列表-2 恢复 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2-3 恢复 列表-4 恢复 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2-3 恢复 列表-4 恢复 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2-4 恢复 mssql 获取单个组
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeGroupTimingRecovery(String uuid) throws I2softException {
        String url = String.format("%s/timing/recovery/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 恢复 检查 目录是否存在
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs timingRecoveryCheckDir(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/check_dir", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2-5 恢复 多库备份获取数据库列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryDbInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/db_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复 - 准备1 - DB2获取时间列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryDb2Time(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_db2_time", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复 获取GAUSS还原时间点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryGaussTime(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/gaussdb_rc_time", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 达梦 获取备份集信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingRecoveryDmBackupInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/dm_backup_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 临时挂载复制卷
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map mountVolume(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/volume_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 临时挂载复制卷
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statusVolume(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/volume_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件还原 - 挂载路径动作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs taskMountDir(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/task_mount_dir", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 合成恢复获取还原时间点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFileSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/file_snapshot_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 合成恢复获取备份点数据库详细信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbNames(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/db_names", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Mysql表恢复 - 获取数据库表信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlDbTableInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/mysql_db_table_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}