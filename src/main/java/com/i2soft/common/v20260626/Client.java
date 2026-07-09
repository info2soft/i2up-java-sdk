package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Client {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Client(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取控制机IP或节点代理开关
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRestRpcCcip(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cc_ip", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带信息更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/tape_media", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 快速注册节点
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs registerNodeFromNode(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步修改从类型节点
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSlaveNode(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/update_slave_node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 上报结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcresult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Ha动态节点切换后上报接口
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcHa(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/ha", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务器池更新底层传上来的中心节点IP
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcCluster(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cluster", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制/NAS规则，创建比较结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/create_compare_result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 上传比较与同步执行差异详情
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs uploadCompareDiffDetail(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/upload_diff_detail", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 上传比较与同步任务执行结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map collectCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/collect_compare_result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 创建结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyEcs(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cloud_ecs", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取所有虚拟平台
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVirtualPlatforms(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_virtual_platforms", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取指定虚拟平台上的所有规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVirtualPlatformRules(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_virtual_platform_rules", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取所有对象存储
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDtoStorageList(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_dto_storage_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取数据库同步规则（返回rpc下发的格式）
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] getAllActiveRules(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_active_rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * HDFS差异比较结果上传
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs uploadHdfsCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/upload_hdfs_compare_result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * CFS - 机头迁移
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cfsNodeMove(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/cfs_node_move", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * CFS - 机头迁移前停止规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cfsStopRule(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/cfs_stop_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带组名 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSlotTapeName() throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/slot_tapename", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 文件复制 - 修改规则自动启动配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateRepBackupNoStart(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/update_nostart", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}