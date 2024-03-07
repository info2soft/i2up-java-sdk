package com.i2soft.resource.v20230227;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ServiceCluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ServiceCluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * 服务集群 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createServiceCls(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务集群 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyServiceCls(StringMap args, String uuid) throws I2softException {
        String url = String.format("%s/service_cls/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务集群 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteServiceCls(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeServiceCls(String uuid) throws I2softException {
        String url = String.format("%s/service_cls/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listServiceCls(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listServiceClsStatus(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 集群节点检查 是否可删
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map chkServiceClsNode(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls/cls_node_chk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 配置 编辑
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs configServiceCls(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls/config", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务集群 - 配置 获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeServiceClsConfig(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls/config", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务集群 - 获取有效节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listServiceClsValidNode(StringMap args) throws I2softException {
        String url = String.format("%s/service_cls/valid_node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}