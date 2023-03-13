package com.i2soft.distributor;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Group {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Group(Auth auth) {
        this.auth = auth;
    }

    /**
     * 节点组 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createNodeGroup(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node_group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点组 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeGroup(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点组 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNodeGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node_group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点组 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyNodeGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node_group/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点组 - 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNodeGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node_group/%s", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * （废弃）类别组 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBlockGroup(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/block_group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * （废弃）类别组 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBlockGroup(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/block_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * （废弃）类别组 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBlockGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/block_group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * （废弃）类别组 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyBlockGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/block_group/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * （废弃）类别组 - 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBlockGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/block_group/%s", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}