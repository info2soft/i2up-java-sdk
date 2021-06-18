package com.i2soft.resource;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class NodeProxy {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public NodeProxy(Auth auth) {
        this.auth = auth;
    }

    /**
     * 节点代理 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createNodeProxy(StringMap args) throws I2softException {
        String url = String.format("%s/node_proxy", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 节点代理 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeProxy(StringMap args) throws I2softException {
        String url = String.format("%s/node_proxy", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点代理 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNodeProxy(String uuid) throws I2softException {
        String url = String.format("%s/node_proxy/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 节点代理 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyNodeProxy(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/node_proxy/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 节点代理 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNodeProxy(StringMap args) throws I2softException {
        String url = String.format("%s/node_proxy", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}