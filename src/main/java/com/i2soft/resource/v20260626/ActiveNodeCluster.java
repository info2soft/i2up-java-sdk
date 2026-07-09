package com.i2soft.resource.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ActiveNodeCluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ActiveNodeCluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * Active集群 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveNodeCluster(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createActiveNodeCluster(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Active集群 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getActiveNodeClusterInfo(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Active集群 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyActiveNodeCluster(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Active集群 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteActiveNodeCluster(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 获取所有节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listClusterActiveNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/nodes", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 新增节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map addNodeActiveNodeCluster(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 移除节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map removeNodeActiveNodeCluster(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/node", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveNodeClusterStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Active集群 - 维护模式切换
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchAdtiveNodeClusterMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node_cluster/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}