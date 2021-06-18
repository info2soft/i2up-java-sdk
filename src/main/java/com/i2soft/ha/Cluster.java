package com.i2soft.ha;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Cluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Cluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * 应用高可用 - 集群服务器池 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHaCluster(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHaCluster(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/:uuid([a-f0-9-] ])", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 删除主机
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteHaClusterHost(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/host", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteHaCluster(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHaCluster(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 应用高可用 - 集群服务器池 hello
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs registerHaCluster(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/hello", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHaCluster(String uuid) throws I2softException {
        String url = String.format("%s/ha/cls_pool/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 集群服务器池 - 名称查重
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkDupName(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/duplicate_name", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 应用高可用 - 集群服务器池 虚IP查重
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listHaClusterIpDuplicate(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/cluster_ip_duplicate", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 UuID
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHaClusterID() throws I2softException {
        String url = String.format("%s/ha/cls_pool/cluster_uuid", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 应用高可用 - 集群服务器池 监控信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHaClusterMonitor(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/monitor", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 应用高可用 - 集群服务器池 网卡信息
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listNicInfo() throws I2softException {
        String url = String.format("%s/ha/net/if", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHaClusterStatus(StringMap args) throws I2softException {
        String url = String.format("%s/ha/cls_pool/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}