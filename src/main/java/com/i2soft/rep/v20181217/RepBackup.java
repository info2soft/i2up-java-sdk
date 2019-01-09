package com.i2soft.rep.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
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
     * 新建规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个规则
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRepBackup(String uuid) throws I2softException {
        String url = String.format("%s/rep/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 修改规则
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
     * 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
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
     * 规则状态
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
     * 获取规则列表（基本信息）
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
     * cdp baseline 列表 获取
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupBaseLine(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/cdp_bl_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * cdp baseline 列表 删除
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
     * 孤儿文件 列表 获取
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
     * 孤儿文件 列表 删除
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
     * 孤儿文件 下载
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs downloadRepBackupOrphan(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/orphan_download", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 快照 列表 获取
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepBackupSnapshot(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 快照 列表 创建快照
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
     * 快照 列表 删除
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
}