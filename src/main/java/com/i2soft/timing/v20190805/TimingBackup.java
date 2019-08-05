package com.i2soft.timing.v20190805;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class TimingBackup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public TimingBackup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 备份 准备-4 备份 获取MsSql数据源
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingBackupMssqlSource(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/mssql_source", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 备份 准备-1 备份/恢复 认证Oracle信息（目前未使用）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyTimingBackupOracleInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/verify_oracle_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 备份 准备-2 备份/恢复 获取Oracle表空间（目前未使用）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingBackupOracleContent(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/oracle_content", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 备份 准备-3 备份 获取Oracle脚本路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descibeTimingBackupOracleSriptPath(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/oracle_script_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 备份 准备-5 备份 获取MsSql数据库列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingBackupMssqlDbList(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/mssql_db_list", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 备份 新建/编辑-1 备份 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTimingBackup(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 备份 新建/编辑-2 备份 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingBackup(String uuid) throws I2softException {
        String url = String.format("%s/timing/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 2 备份 新建/编辑-3 备份 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTimingBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 备份 列表-1 备份 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingBackup(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 备份 列表-2 备份 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 备份 列表-3 备份 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTimingBackup(StringMap args) throws I2softException {
        String url = String.format("%s/timing/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时备份 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startTimingBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/timing/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时备份 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopTimingBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/timing/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}