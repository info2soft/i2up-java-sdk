package com.i2soft.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Cluster {
    /**
     * Auth 对象
     */
    private final Auth auth;
    private String module_url;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Cluster(Auth auth) {
        this.auth = auth;
        this.module_url = auth.cc_url + "/cls";
    }

    /**
     * 集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authCls(StringMap args) throws I2softException {
        String url = String.format("%s/auth", module_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 集群节点验证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyClsNode(StringMap args) throws I2softException {
        String url = String.format("%s/node_verify", module_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 新建集群
     *
     * @return code, message
     */
    public I2Rs.I2SmpRs createCls(StringMap args) throws I2softException {
        Response r = auth.client.post(module_url, new StringMap().putNotNull("cls", args));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取集群列表
     *
     * @return 集群列表
     */
    public ResRs.NodeList listCls(I2Req.ListArgs args) throws I2softException {
        Response r = auth.client.get(module_url, args.toStringMap());
        return r.jsonToObject(ResRs.NodeList.class);
    }

    /**
     * 获取集群状态
     *
     * @return 集群列表
     */
    public Map listClsStatus(String[] uuids) throws I2softException {
        String url = String.format("%s/status", module_url);
        Response r = auth.client.get(url, new StringMap().putNotEmpty("node_uuids", uuids));
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取集群
     *
     * @param uuid: 集群uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCls(String uuid) throws I2softException {
        Response r = auth.client.get(String.format("%s/%s", module_url, uuid));
        return r.jsonToObject(Map.class);
    }

    /**
     * 修改集群
     *
     * @param uuid: 集群uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCls(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/%s", module_url, uuid);
        Response r = auth.client.put(url, new StringMap().putNotNull("cls", args));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 集群详情
     *
     * @param uuid: 集群uuid
     * @return code, message
     * @throws I2softException:
     */
    public Map clsDetail(String uuid) throws I2softException {
        String url = String.format("%s/operate", module_url);
        StringMap newArgs = new StringMap().putNotEmpty("node_uuid", uuid).put("operate", "detail");
        Response r = auth.client.delete(url, newArgs);
        return r.jsonToObject(Map.class);
    }

    /**
     * 删除集群
     *
     * @param uuids: 集群uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCls(String[] uuids) throws I2softException {
        Response r = auth.client.delete(module_url, new StringMap().putNotEmpty("node_uuids", uuids));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}
