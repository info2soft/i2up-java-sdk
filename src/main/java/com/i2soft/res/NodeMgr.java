package com.i2soft.res;

import com.i2soft.common.I2Req;
import com.i2soft.common.I2Rs;
import com.i2soft.common.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Auth;
import com.i2soft.util.StringMap;

public final class NodeMgr {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public NodeMgr(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建节点
     *
     * @return code, message
     */
    public I2Rs.I2SmpRs createNode(StringMap args) throws I2softException {
        Response r = auth.client.post(String.format("%s/node", auth.cc_url), new StringMap().putNotNull("node", args));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取用户的所有节点列表
     *
     * @return 节点列表
     */
    public ResResult.NodeList getList(I2Req.ListArgs args) throws I2softException {
        String url = String.format("%s/node", auth.cc_url);
        Response r = auth.client.get(url, args.toStringMap());
        return r.jsonToObject(ResResult.NodeList.class);
    }
}
