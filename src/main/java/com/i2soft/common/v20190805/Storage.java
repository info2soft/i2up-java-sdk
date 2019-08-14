package com.i2soft.common.v20190805;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Storage {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Storage(Auth auth) {
        this.auth = auth;
    }

    /**
     * 存储配置 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createStorageConfig(StringMap args) throws I2softException {
        String url = String.format("%s/storage", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储配置 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStorageConfig(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/storage/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储配置 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStorageConfig(String uuid) throws I2softException {
        String url = String.format("%s/storage/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 存储配置 - 获取列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStorageConfig() throws I2softException {
        String url = String.format("%s/storage", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 存储配置 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteStorageConfig(StringMap args) throws I2softException {
        String url = String.format("%s/storage", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储配置 - 容量信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStorageInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ /storage/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储配置 - 获取可用节点列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAvailableNode() throws I2softException {
        String url = String.format("%s/storage/node", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 设备 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDevice(StringMap args) throws I2softException {
        String url = String.format("%s/storage/dev", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 设备 - 获取可用列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAvailableDevice(StringMap args) throws I2softException {
        String url = String.format("%s/storage/available_dev", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储池 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createPool(StringMap args) throws I2softException {
        String url = String.format("%s/storage/pool", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储池 - 扩展
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs expandPool(StringMap args) throws I2softException {
        String url = String.format("%s/storage/pool", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储池 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deletePool(StringMap args) throws I2softException {
        String url = String.format("%s/storage/pool", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储池 - 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPool(StringMap args) throws I2softException {
        String url = String.format("%s/storage/pool", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储池 - 获取信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPoolInfo(StringMap args) throws I2softException {
        String url = String.format("%s/storage/pool/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件系统 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFs(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFs(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 - 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFs(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件系统 / 快照 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFsSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 / 快照 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFsSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 / 快照 - 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFsSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件系统 / 快照 / 克隆 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFsCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap/clone", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 / 快照 / 克隆 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFsCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap/clone", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 文件系统 / 快照 / 克隆 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFsCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/file_system/snap/clone", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 卷 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVolume(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 卷 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVolume(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 卷 - 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVolume(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 卷 / 快照 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVolumeSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 卷 / 快照 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVolumeSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 卷 / 快照 - 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVolumeSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 卷 / 快照 / 克隆 - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVolumeCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap/clone", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 卷 / 快照 / 克隆 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVolumeCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap/clone", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 卷 / 快照 / 克隆 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVolumeCloneSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/storage/volume/snap/clone", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * VMDK - 创建
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVMDK() throws I2softException {
        String url = String.format("%s/storage/vmdk", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * VMDK - 删除
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVMDK() throws I2softException {
        String url = String.format("%s/storage/vmdk", auth.cc_url);
        Response r = auth.client.delete(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 后备存储（BackStore） - 创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBackStore(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 后备存储（BackStore） - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBackStore(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 后备存储（BackStore） - 获取信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackStore(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 后备存储（BackStore） - 分配给ISCSI发起者
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAssignBackStore(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore/assign", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 后备存储（BackStore） - 查看被分配给哪些ISCSI发起者
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAssignBackStore(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore/assign", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 后备存储（BackStore） - 获取可创建 块 的 盘 的 路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackStoreAvailablePath(StringMap args) throws I2softException {
        String url = String.format("%s/storage/backstore/available_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI - 获取版本信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeIscsiVersion(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI - 获取发现权限
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeIscsiAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auth", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI - 设置发现权限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiDiscoverAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI - 取消发现权限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiDiscoverAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auth", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI - 全局参数设置：自动添加 ISCSI目标端 门户
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAutoAddPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auto_add_portal", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI - 全局参数设置：自动添加 单元逻辑号映射
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAutoAddLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auto_add_luns", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI - 获取全局参数：自动添加ISCSI目标端 门户
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeAutoAddPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auto_add_portal", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI - 获取全局参数：自动添加单元逻辑映射
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeAutoAddLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/iscsi/auto_add_luns", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI目标端 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeIscsiTargetStatus(StringMap args) throws I2softException {
        String url = String.format("%s/storage/target/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI目标端 - 获取信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listIscsiTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/target/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI目标端 - 添加
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/target", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI目标端 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/target", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 添加
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiInitiator(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiInitiator(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 设置连接权限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiInitiatorConnectAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 添加 逻辑单元号（LUN）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiInitiatorLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/lun", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 删除 逻辑单元号（LUN）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiInitiatorLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/lun", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 发现目标端
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiInitiatorDiscoverTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/discover", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 连接目标端
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createIscsiInitiatorConnectTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/connect", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 断开目标段连接
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiInitiatorConnectTarget(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/connect", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ISCSI发起者 - 获取发现门户列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listIscsiInitiatorPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/portal", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * ISCSI发起者 - 删除发现门户
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIscsiInitiatorPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/initiator/portal", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 获取信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTpg(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目标门户组（TPG） - 添加
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createTpg(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 目标门户组（TPG） - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTpg(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 设置连接权限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTpgConnectAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 取消连接权限
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTpgConnectAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/auth", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 添加 逻辑单元（LUN）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTpgLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/lun", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG）- 是否开启连接权限
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTpgConnectAuth(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/auth", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目标门户组（TPG） - 删除 逻辑单元号（LUN）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTpgLun(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/lun", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 添加 门户（Portal）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTpgPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/portal", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目标门户组（TPG） - 删除 门户（Portal）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTpgPortal(StringMap args) throws I2softException {
        String url = String.format("%s/storage/tpg/portal", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}