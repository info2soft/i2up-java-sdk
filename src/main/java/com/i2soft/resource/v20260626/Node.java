package com.i2soft.resource.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Node {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Node(Auth auth) {
        this.auth = auth;
    }

    /**
     * 0 准备-节点认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 0 准备-获取节点安装包列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodePackageList(StringMap args) throws I2softException {
        String url = String.format("%s/node/package_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 0 准备-获取节点容量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkCapacity(StringMap args) throws I2softException {
        String url = String.format("%s/node/check_capacity", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 0 准备-获取节点卷组列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVg(StringMap args) throws I2softException {
        String url = String.format("%s/node/vg", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点- 扫描集群IP获取节点信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHostInfo(StringMap args) throws I2softException {
        String url = String.format("%s/node/host_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 0 准备-检查节点在线
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkNodeOnline(StringMap args) throws I2softException {
        String url = String.format("%s/node/hello", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 按端口批量搜索节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchSearchByPort(StringMap args) throws I2softException {
        String url = String.format("%s/node/hello_port_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - 获取绑定云主机信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeBindEcs(StringMap args) throws I2softException {
        String url = String.format("%s/node/ecs_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 单项-新建节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createNode(StringMap args) throws I2softException {
        String url = String.format("%s/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 单项-脚本预创建节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map precreateNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/precreate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 单项-修改节点
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyNode(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/node/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 单项-获取单个节点
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNode(String uuid) throws I2softException {
        String url = String.format("%s/node/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 1 单项-新建节点 - 批量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBatchNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 单项-获取节点存储信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDeviceInfo(String uuid) throws I2softException {
        String url = String.format("%s/node/%s/device_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 单项 - (Win)节点获取磁盘挂载点
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDriverLetter(String uuid) throws I2softException {
        String url = String.format("%s/node/%s/driver_letter", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 1 单项-添加从类型节点
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addSlaveNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/add_slave_node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 多项-修改节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchModifyNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/batch_update", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 单项 - 获取节点信息
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNodeInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/node/%s/info", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 列表-节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNode(StringMap args) throws I2softException {
        String url = String.format("%s/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 列表-节点操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs upgradeNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 列表-节点操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs maintainNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 列表-节点操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs renewKeyNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 列表-节点状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/node/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 列表-删除节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNode(StringMap args) throws I2softException {
        String url = String.format("%s/node", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取Oracle DB信息 - 表空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map nodeGetOracleInfo(StringMap args) throws I2softException {
        String url = String.format("%s/node/oracle_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取MySQL信息 - 数据库名
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map nodeGetMysqlInfo(StringMap args) throws I2softException {
        String url = String.format("%s/node/mysql_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取数据地址列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map dataIpList(StringMap args) throws I2softException {
        String url = String.format("%s/node/data_ip_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改数据地址
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyDataIp(StringMap args) throws I2softException {
        String url = String.format("%s/node/data_ip", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取 fc 客户端 hba卡信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHbaInfo(StringMap args) throws I2softException {
        String url = String.format("%s/node/hba_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 解绑云主机检查
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkUnbindEcs(StringMap args) throws I2softException {
        String url = String.format("%s/node/check_unbind_ecs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - version
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getNodeVersion(StringMap args) throws I2softException {
        String url = String.format("%s/node/version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - 激活
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map activeNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/active", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - 待激活列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listWaitingActiveNode() throws I2softException {
        String url = String.format("%s/node/inactive_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 节点 - Linux安装脚本下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadNodeInstallScript(StringMap args) throws I2softException {
        String url = String.format("%s/node/install_script", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 节点 - 获取安装包下载链接-URL
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getNodePackageUrl(StringMap args) throws I2softException {
        String url = String.format("%s/node/packge_url", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点关联规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRules(StringMap args) throws I2softException {
        String url = String.format("%s/node/rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - 删除待激活节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteInactiveNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/inactive", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点 - 获取关联的ukey
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeUkey(StringMap args) throws I2softException {
        String url = String.format("%s/node/ukey", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取关联平台列表（云平台 Fusion）
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPlatform() throws I2softException {
        String url = String.format("%s/node/platform", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取Mysql数据库
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlDatabases(StringMap args) throws I2softException {
        String url = String.format("%s/node/mysql_databases", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取Mysql（库当中的）表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlTables(StringMap args) throws I2softException {
        String url = String.format("%s/node/mysql_tables", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查询节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map restartNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map insmodNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rmmodNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作节点进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map installNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 批量设置节点auth.conf
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchAuthNode(StringMap args) throws I2softException {
        String url = String.format("%s/node/batch_auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 查询内核模块
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listKernels(StringMap args) throws I2softException {
        String url = String.format("%s/node/kernels", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点是否开启指纹域服务
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeFpServer(StringMap args) throws I2softException {
        String url = String.format("%s/node/fp_server", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}