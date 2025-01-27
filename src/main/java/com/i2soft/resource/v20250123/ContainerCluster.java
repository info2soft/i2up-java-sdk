package com.i2soft.resource.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ContainerCluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ContainerCluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份目标位置 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBackupDestination(StringMap args) throws I2softException {
        String url = String.format("%s/backup_destination", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份目标位置 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupDestination() throws I2softException {
        String url = String.format("%s/backup_destination", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份目标位置 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descibeBackupDestination(String uuid) throws I2softException {
        String url = String.format("%s/backup_destination/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份目标位置 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBackupDestination(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/backup_destination/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份目标位置 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBackupDestination(StringMap args) throws I2softException {
        String url = String.format("%s/backup_destination", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份目标位置 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupDestinationStatus(StringMap args) throws I2softException {
        String url = String.format("%s/backup_destination/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 容器集群 - 集群信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterInfo(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster/cls_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 容器集群 - 同步信息
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs syncContainerClusterInfo(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster/sync_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 容器集群 - 资源信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClusterResource(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster/resource", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 容器集群 - 名字空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerClsNamespace(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster/namespace", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 容器集群-概览-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map containerClusterMonitoringOverview(StringMap args) throws I2softException {
        String url = String.format("%s/v3/container_cluster/monitoring/overview", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 容器集群-概览-节点
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] containerClusterMonitoringNode() throws I2softException {
        String url = String.format("%s/v3/container_cluster/monitoring/node", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * 容器集群 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createContainerCluster(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 容器集群 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listContainerCluster() throws I2softException {
        String url = String.format("%s/container_cluster", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 容器集群 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeContainerCluster(String uuid) throws I2softException {
        String url = String.format("%s/container_cluster/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 容器集群 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyContainerCluster(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.body();
    }

    /**
     * 容器集群 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteContainerCluster(StringMap args) throws I2softException {
        String url = String.format("%s/container_cluster", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 回调设置 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCallbackSettings(StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 回调设置 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCallbackSettings(StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 回调设置 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCallbackSettings(String uuid) throws I2softException {
        String url = String.format("%s/callback_settings/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 回调设置 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCallbackSettings(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 回调设置 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCallbackSettings(StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 回调设置 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cloneCallbackSettings(StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 回调设置 - 验证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyCallbackSettingsPod(StringMap args) throws I2softException {
        String url = String.format("%s/callback_settings/pod_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}