package com.i2soft.vp.v20190805;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class VirtualizationSupport {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public VirtualizationSupport(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVp(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 编辑
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 操作：更新数据代理版本
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateDataAgentVp(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/platform/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("vp_uuids", uuids).put("operate", "update_data_agent");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 查询 虚机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVM(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/vm", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 平台属性
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpAttribute(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/info", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 查询 备机上备份列表（RC）1
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakVer(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/bak_ver", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 备份点信息/虚机配置信息（RC）2
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakVerInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/bak_ver_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 数据存储下文件列表（RC）3
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastoreFile(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore_file", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 数据中心列表（MOVE/REP）1
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacenter(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datacenter", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 查询 数据中心主机列表 （MOVE/REP）2
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacenterHost(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datacenter_host", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 存储列表 （MOVE/REP）3
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastore(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询 存储信息 （MOVE/REP）4
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastoreInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 创建存储目录
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDatastore(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 虚机磁盘
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVmDisk(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/vm_disk", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 虚机网卡
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNetwork(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/network", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 演练配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map drilConfigInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/drill_config", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 导入虚机 IP映射
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs importVmIpMapping(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/batch_vm_ip_mapping", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 虚拟平台 - 获取虚机网卡信息列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNetworkInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/network_info_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取 虚机复制/整机备份 目标机状态信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map tgtVmStatusInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/tgt_vm_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 单个平台存储列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPlatformStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vp/storage/platform_storage_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改存储授权容量、启用状态
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs platformAuthorize(StringMap args) throws I2softException {
        String url = String.format("%s/vp/storage/platform_authorize", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vp/storage", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改（仅模板）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyVpBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpBackup(String uuid) throws I2softException {
        String url = String.format("%s/vp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 获取单个（组）
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpBackupGroup(String uuid) throws I2softException {
        String url = String.format("%s/vp/backup/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 列表（组）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupGroup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机备份 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startVpBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 虚机备份 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopVpBackup(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/backup/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个（组）
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpRecoveryGroup(String uuid) throws I2softException {
        String url = String.format("%s/vp/recovery/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机还原 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startVpRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 虚机还原 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopVpRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 虚机还原 - 操作：清除已完成的任务
     *
     * @param rule_type: 恢复类型：0：普通；1：瞬时；
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs clearFinishVpRecovery(Integer rule_type) throws I2softException {
        String url = String.format("%s/vp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotNull("rule_type", rule_type).put("operate", "clear_finish");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpMove(StringMap args) throws I2softException {
        String url = String.format("%s/vp/move", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpRep(StringMap args) throws I2softException {
        String url = String.format("%s/vp/rep", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpMove(String uuid) throws I2softException {
        String url = String.format("%s/vp/move/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpRep(String uuid) throws I2softException {
        String url = String.format("%s/vp/rep/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 修改（模板）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVpMove(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/move/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改（模板）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVpRep(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/rep/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpMove(StringMap args) throws I2softException {
        String url = String.format("%s/vp/move", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRep(StringMap args) throws I2softException {
        String url = String.format("%s/vp/rep", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpMoveStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/move/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRepStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/rep/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机迁移 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startVpMove(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/move/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机复制 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startVpRep(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/rep/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机迁移 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopVpMove(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/move/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机复制 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopVpRep(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/rep/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机迁移 - 操作：迁移
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map moveVpMove(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/move/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "move");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机复制 - 操作：切换
     *
     * @param uuids:      uuid数组
     * @param snap_point: 切换专用参数：选择需要切换到的时间点
     * @param op_code:    切换专用参数：0表示临时切换；1表示永久切换
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map failoverVpRep(String[] uuids, String snap_point, Integer op_code) throws I2softException {
        String url = String.format("%s/vp/rep/operate", auth.cc_url);
        StringMap newArgs = new StringMap()
                .putNotEmpty("rule_uuids", uuids)
                .putNotEmpty("snap_point", snap_point)
                .putNotNull("op_code", op_code)
                .put("operate", "failover");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 虚机复制 - 操作：回切
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map failbackVpRep(String[] uuids) throws I2softException {
        String url = String.format("%s/vp/rep/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rule_uuids", uuids).put("operate", "failback");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpMove(StringMap args) throws I2softException {
        String url = String.format("%s/vp/move", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpRep(StringMap args) throws I2softException {
        String url = String.format("%s/vp/rep", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取快照列表信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRepPointList(String uuid) throws I2softException {
        String url = String.format("%s/vp/rep/%s/point_list", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 1 获取恢复虚机ip
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpFileRecoveryVmIp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery/vm_ip", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 2 livecd磁盘分区
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map vpFileRecoveryLivecdPartition(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery/livecd_partition", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVpFileRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpFileRecovery(String uuid) throws I2softException {
        String url = String.format("%s/vp/file_recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpFileRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpFileRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚机恢复（vp_file_recovery）- 文件恢复 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVpFileRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/file_recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}