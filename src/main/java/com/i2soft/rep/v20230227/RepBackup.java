package com.i2soft.rep.v20230227;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RepBackup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RepBackup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 复制规则 - 获取 cdp zfs池列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupCdpZfs(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/cdp_zfs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 检查是否挂载盘
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map repBackupVerifyDevice(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/verify_device", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 获取可配置CDP快照数
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getRepBackupCdpSnapNum(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/cdp_snap_num", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2CreateRs createRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2CreateRs.class);
    }

    /**
     * 复制规则 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRepBackup(String uuid) throws I2softException {
        String url = String.format("%s/rep/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyRepBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startRepBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/rep/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rep_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopRepBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/rep/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rep_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - cdp baseline 列表 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupBaseLine(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/cdp_bl_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - cdp baseline 列表 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRepBackupBaseline(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/cdp_bl_list", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 孤儿文件 列表 获取
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupOrphan(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/orphan_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 孤儿文件 列表 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRepBackupOrphan(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/orphan_list", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 孤儿文件 下载
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public String downloadRepBackupOrphan(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/orphan_download", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.toString();
    }

    /**
     * 复制规则 - 快照 列表 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/snapshot_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 快照 创建
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createRepBackupSnapshot(String uuid) throws I2softException {
        String url = String.format("%s/rep/backup/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 快照 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRepBackupSnapshot(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 获取集群组信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupMscsGroup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/mscs_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}