package com.i2soft.fsp;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class FspBackup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public FspBackup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 0 获取两节点网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupNic(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/nic_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 0 获取源节点磁盘和文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupDir(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/dir_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 1 检测条件-备份空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspBackupCoopySpace(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/verify_coopy_space", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 1 检测条件-license
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspBackupLicense(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/verify_license", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测条件-旧规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspBackupOldRule(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/verify_old_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测条件-系统版本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspBackupOsVersion(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/verify_os_version", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 2 新建规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFspBackup(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 修改规则
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyFspBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取单个规则
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeFspBackup(String uuid) throws I2softException {
        String url = String.format("%s/fsp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 3 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFspBackup(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 获取规则列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackup(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 全服备份 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startFspBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服备份 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopFspBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/move/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服备份 - 操作：结束
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs finishFspBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/move/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "finish");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 规则状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }
}