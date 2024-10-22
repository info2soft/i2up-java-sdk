package com.i2soft.resource.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ActiveNodeV3 {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ActiveNodeV3(Auth auth) {
        this.auth = auth;
    }

    /**
     * 库节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbs(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 测试连接
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkDbLink(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/db_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDbUnified(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyDb(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 查询表空间
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeDbSpace(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/space_query", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库节点 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDb(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 导入
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchCreateDbs() throws I2softException {
        String url = String.format("%s/vers/v3/active/db/batch", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库节点 - 维护模式切换
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchDbMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库节点 - 查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDb(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 身份认证信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getActiveDbAuthInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/auth_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库节点 - 批量新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchCreateSqlserverDbs(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db/db_batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库节点 - 获取字符集
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs getCharset() throws I2softException {
        String url = String.format("%s/vers/v3/active/db/charset", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 机器节点 - 未激活节点
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listInactiveNodes() throws I2softException {
        String url = String.format("%s/vers/v3/active/node/inactive_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 激活（新建）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map activeNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodes(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 查看
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptNode(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 状态信息实时流量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptNodeDebugInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/debug_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 升级
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs upgradeNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/upgrade", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 机器节点 - 维护模式切换
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 机器节点 - 重新生成调试信息
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs rebuildActiveNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/rebuild", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 机器节点 - 刷新调试信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refresgActiveNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/refresh", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 机器节点 - 重启进程
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map restartAllProcess(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/node/process_restart", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}