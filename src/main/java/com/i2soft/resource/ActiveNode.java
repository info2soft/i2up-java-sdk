package com.i2soft.resource;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ActiveNode {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ActiveNode(Auth auth) {
        this.auth = auth;
    }

    /**
     * 未激活节点列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listInactiveNodes() throws I2softException {
        String url = String.format("%s/active/node/inactive_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 激活
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map activeNode(StringMap args) throws I2softException {
        String url = String.format("%s/active/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/node/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点列表(搜索)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodes(StringMap args) throws I2softException {
        String url = String.format("%s/active/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个详细信息
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptNode(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/active/node/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptNodeDebugInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/node/debug_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyNode(StringMap args) throws I2softException {
        String url = String.format("%s/active/node", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNode(StringMap args) throws I2softException {
        String url = String.format("%s/active/node", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 节点升级
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs upgradeNode(StringMap args) throws I2softException {
        String url = String.format("%s/active/node/upgrade", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 维护模式切换
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/active/node/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbs(StringMap args) throws I2softException {
        String url = String.format("%s/active/db", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库健康信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDbHealthInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/db/health_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 测试数据库连接
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs checkDbLink(StringMap args) throws I2softException {
        String url = String.format("%s/active/db/db_check1", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/db/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建数据库节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDb(StringMap args) throws I2softException {
        String url = String.format("%s/active/db", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改数据库节点
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyDb(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/active/db/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 表空间查询接口
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeDbSpace(StringMap args) throws I2softException {
        String url = String.format("%s/active/db/space_query", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除数据库
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDb(StringMap args) throws I2softException {
        String url = String.format("%s/active/db", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 批量导入
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchCreateDbs() throws I2softException {
        String url = String.format("%s/active/db/batch", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个数据库节点信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDb(String uuid) throws I2softException {
        String url = String.format("%s/active/db/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 测试数据库连接（新格式）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkDbLinkNew(StringMap args) throws I2softException {
        String url = String.format("%s/active/db/db_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}