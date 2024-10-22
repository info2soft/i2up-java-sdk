package com.i2soft.resource.v20240819;

import com.i2soft.http.I2Req;
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
     * 虚拟平台 - 新建
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
     * 虚拟平台 - 修改
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
     * 虚拟平台 - 列表
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
     * 虚拟平台 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVp(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 状态
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
     * 虚拟平台 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateDataAgentVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 虚拟平台 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 虚机列表
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
     * 获取不带层级结构的虚机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVmNoHierarchy(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/vm_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 单个虚机的详细信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVmInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/vm_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 平台属性
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpAttribute(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/info", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 备机上备份列表（RC）1
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
     * 虚拟平台 - 查 备份点信息（RC）2
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
     * 虚拟平台 - 存储下文件列表（RC）3
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
     * 虚拟平台 - 数据中心列表
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacenter(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datacenter", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 数据中心主机列表 （MOVE/REP）2
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
     * 虚拟平台 - 查 主机下资源池列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listResourcePool(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/resource_pool", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 查 存储列表 （MOVE/REP/RC）3
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
     * 虚拟平台 - 查 存储信息 （MOVE/REP/RC）4
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
     * 虚拟平台 - 数据存储视图对象列表查询
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastoreDir(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore_dir", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
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
     * 虚拟平台 - 查 平台网卡
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
     * 虚拟平台 -导入虚机 IP映射，模板下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] dl(StringMap args) throws I2softException {
        String url = String.format("%s/dl", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 虚拟平台 - 导入虚机 IP映射
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] importVmIpMapping(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/batch_vm_ip_mapping", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
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
     * 虚拟平台 - 获取指定操作系统的信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeOsVersion(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/os_version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 获取安全组
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSecurityGroup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/security_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 获取物理出口列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPhysicalInterface(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/physical_interface_list", auth.cc_url);
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
     * 应急演练，获取华云平台登录虚机地址
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map archerVmConsole(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/archer_vm_console", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟平台 - 获取虚机状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVmStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/vm_status", auth.cc_url);
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
     * 通过ip和port，获取备份点列表
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] listBakVerByIp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/bk_ver_by_ip", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 通过ip和port，获取备份点信息
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] listBakVerInfoByIp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/bk_ver_info_by_ip", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 测试连接节点
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs testNode(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/test_node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取规则目标机信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getTargetVmInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/target_vm_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取平台卷类型列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDiskType(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/disk_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 发现虚机
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map discoveryVm(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/discovery_vm", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Winstack - 获取主机池列表
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPools(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/pool_list/", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Winstack - 获取主机池主机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPoolHosts(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/pool_host_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * AIO - 获取集群列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAioClusters(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/aio_cluster_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * AIO - 获取主机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAioHosts(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/aio_host_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * AIO - 获取主机下存储池
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAioPools(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/aio_pool_list/", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * AIO - 获取主机架构和仿真机类型
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeAioHostCapability(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/aio_host_capability/", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * SCP - 获取主机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listScpHosts(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/scp_host_list/", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟化管理 - 分页获取虚机列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVmPagination(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/list_vm_pagination", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟化管理 - 导出虚机列表
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportVmList(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/list_vm_export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * Smartx - 获取vpc列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpc(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/list_vpc", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Smartx - 获取vpc子网列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpcSubnets(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/list_vpc_subnets", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}