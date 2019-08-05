package com.i2soft.resource.v20190805;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.Rsa;
import com.i2soft.util.StringMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Node {
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
    public Node(Auth auth) {
        this.auth = auth;
        this.module_url = auth.cc_url + "/node";
    }

    /**
     * 获取节点容量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkCapacity(StringMap args) throws I2softException {
        String url = String.format("%s/check_capacity", module_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点卷组列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVg(StringMap args) throws I2softException {
        String url = String.format("%s/vg", module_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authNode(StringMap args) throws I2softException {
        args.fieldsRsa(new String[]{"os_pwd"});
        String url = String.format("%s/auth", module_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 检查节点在线
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkNodeOnline(StringMap args) throws I2softException {
        String url = String.format("%s/hello", module_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建节点
     *
     * @return code, message
     */
    public Map createNode(StringMap args) throws I2softException {
        Response r = auth.client.post(module_url, args);
        return r.jsonToMap();
    }

    /**
     * 新建节点（批量）
     *
     * @return code, message
     */
    public Map createBatchNode(StringMap args) throws I2softException {
        final Rsa rsa = new Rsa();
        if (args.get("base_info_list").getClass().equals(ArrayList.class)) {
            for (Map<String, String> base_info : (List<Map<String, String>>) args.get("base_info_list")) {
                base_info.put("os_pwd", rsa.encryptByPublicKey(base_info.get("os_pwd")));
            }
        }

        String url = String.format("%s/batch", module_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点列表
     *
     * @return 节点列表
     */
    public ResRs.NodeList listNode(I2Req.ListArgs args) throws I2softException {
        Response r = auth.client.get(module_url, args.toStringMap());
        return r.jsonToObject(ResRs.NodeList.class);
    }

    /**
     * 获取节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNode(StringMap args) throws I2softException {
        Response r = auth.client.get(module_url, args);
        return r.jsonToMap();
    }

    /**
     * 获取节点状态
     *
     * @return 节点列表
     */
    public Map listNodeStatus(String[] uuids) throws I2softException {
        String url = String.format("%s/status", module_url);
        Response r = auth.client.get(url, new StringMap().putNotEmpty("node_uuids", uuids));
        return r.jsonToMap();
    }

    /**
     * 获取节点
     *
     * @param uuid: 节点uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNode(String uuid) throws I2softException {
        Response r = auth.client.get(String.format("%s/%s", module_url, uuid));
        return r.jsonToMap();
    }

    /**
     * 获取节点存储信息
     *
     * @param uuid: 节点uuid
     * @return code, message
     * @throws I2softException:
     */
    public Map describeDeviceInfo(String uuid) throws I2softException {
        String url = String.format("%s/%s/device_info", module_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 修改节点
     *
     * @param uuid: 节点uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyNode(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/%s", module_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 节点 - 操作：升级
     *
     * @param uuids: 节点uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs upgradeNode(String[] uuids) throws I2softException {
        String url = String.format("%s/operate", module_url);
        StringMap newArgs = new StringMap().putNotEmpty("node_uuids", uuids).put("operate", "upgrade");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除节点
     *
     * @param uuids: 节点uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteNode(String[] uuids) throws I2softException {
        Response r = auth.client.delete(module_url, new StringMap().putNotEmpty("node_uuids", uuids));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}
