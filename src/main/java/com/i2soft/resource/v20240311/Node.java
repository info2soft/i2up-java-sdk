package com.i2soft.resource.v20240311;

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
    public Map modifyNode(StringMap args) throws I2softException {
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
    public Map describeNode(String uuid, StringMap args) throws I2softException {
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
    public I2Rs.I2SmpRs operateNode(StringMap args) throws I2softException {
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
        args.put("operate", "renew_key");
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
    public I2Rs.I2SmpRs upgradeNode(StringMap args) throws I2softException {
        args.put("operate", "upgrade");
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
    public I2Rs.I2SmpRs updateNode(StringMap args) throws I2softException {
        args.put("operate", "update");
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
}