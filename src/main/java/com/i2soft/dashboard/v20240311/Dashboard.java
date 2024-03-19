package com.i2soft.dashboard.v20240311;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dashboard {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dashboard(Auth auth) {
        this.auth = auth;
    }

    /**
     * 资源概览（旧）
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resourceView() throws I2softException {
        String url = String.format("%s/dashboard/source", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取资源池列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupCenter() throws I2softException {
        String url = String.format("%s/dashboard/list_backup_center", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取资源使用率和保护覆盖率
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getBackupCenterInfo(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/backup_center_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 资源概览 - 获取接管、演练平台列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHosts() throws I2softException {
        String url = String.format("%s/dashboard/list_hosts", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 设置资源保护覆盖率
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resourceProtectionCoverage(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/resource_protection_coverage", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 任务概览列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map taskView() throws I2softException {
        String url = String.format("%s/dashboard/task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 5 Dashboard - 获取规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map repBackup(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/rep", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则 - 批量新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchCreateRepBackup(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则 - 检查目标路径
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs checkBkPath(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/check_bk_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则 - 提交前检查
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map chkRules(StringMap args) throws I2softException {
        String url = String.format("%s/rep/backup/rules_chk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 Dashboard - 获取节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map node(StringMap args) throws I2softException {
        String url = String.format("%s/dashboard/node", auth.cc_url);
        Response r = auth.client.get(url, args);
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
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs downloadNodeInstallScript(StringMap args) throws I2softException {
        String url = String.format("%s/node/install_script", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
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
    public Map operateNodeProcess(StringMap args) throws I2softException {
        String url = String.format("%s/node/process_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
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
     * 高可用 - 节点网卡信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNicInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ha/netif", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - HA脚本目录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHAScriptPath(StringMap args) throws I2softException {
        String url = String.format("%s/ha/script_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 磁盘信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVolumeInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ha/volume_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 检查是否重名
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs haVerifyName(StringMap args) throws I2softException {
        String url = String.format("%s/ha/verify_name", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 高可用 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 高可用 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 高可用 - 查看详细信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHA(String uuid) throws I2softException {
        String url = String.format("%s/ha/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 高可用 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHAStatus(StringMap args) throws I2softException {
        String url = String.format("%s/ha/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}