package com.i2soft.ContainerCls.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ContainerCls {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ContainerCls(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createContinerClusterBackup(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterBackup(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份 - 单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeContainerClusterBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyContainerClusterBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteContainerClusterBackup(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs backupImmediateContainerClusterBackup(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份 - 查看子任务列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterBackupSubTask(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/sub_task", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份 - 查看备份信息(rpc获取)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getContainerClusterBackupInfo(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/backup/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createContainerClusterRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 还原 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterRecovery() throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 还原 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeContainerClusterRecovery(String uuid) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 还原 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyContainerClusterRecovery(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 还原 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteContainerClusterRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 还原 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 获取还原时间点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterRecoveryPoint(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/rc_point", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 还原 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startContainerClusterRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 还原 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopContainerClusterRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 还原 - 查看还原信息(rpc获取)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getContainerClusterRecoveryInfo(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster_protect/recovery/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}