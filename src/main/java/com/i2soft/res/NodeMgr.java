package com.i2soft.res;

import com.i2soft.common.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Auth;

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
     * 获取用户的所有节点列表
     *
     * @return 节点列表
     */
    public ResResult.NodeList getList() throws I2softException {
        String url = String.format("%s/node", auth.url_prefix);
        Response r = auth.client.get(url);
        return r.jsonToObject(ResResult.NodeList.class);
    }
}
