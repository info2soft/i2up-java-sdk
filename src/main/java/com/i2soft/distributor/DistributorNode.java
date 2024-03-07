package com.i2soft.distributor;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DistributorNode {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DistributorNode(Auth auth) {
        this.auth = auth;
    }

    /**
     * 分发节点 - 【字段说明】
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs readme(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/readme", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 分发节点 - 注册（底层）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map register(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 更新状态（底层）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map updateStatus(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s/status", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNode(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 获取 节点
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNode(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 设置 文件
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map fileConfig(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s/file_config", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 设置 警告
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map warnConfig(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s/warn_config", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 升级
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map upgrade(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s/upgrade", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 删除
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map delete(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/%s", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 拓扑图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map topography(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/topography", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 分发节点 - 延迟图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map latency(StringMap args) throws I2softException {
        String url = String.format("%s/distribution/node/latency", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}