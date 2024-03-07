package com.i2soft.resource.v20220622;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Cluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Cluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1准备-1 集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authCls(StringMap args) throws I2softException {
        String url = String.format("%s/cls/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1准备-2 集群节点验证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyClsNode(StringMap args) throws I2softException {
        String url = String.format("%s/cls/node_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1准备-3 根据集群IP获取节点信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsNodeInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cls/node_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2编辑/新建-1 新建集群
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCls(StringMap args) throws I2softException {
        String url = String.format("%s/cls", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2编辑/新建-2 获取单个集群
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCls(String uuid) throws I2softException {
        String url = String.format("%s/cls/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2编辑/新建-3 修改集群
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCls(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/cls/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3列表-1 获取集群列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCls(StringMap args) throws I2softException {
        String url = String.format("%s/cls", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-4 集群操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDetail(StringMap args) throws I2softException {
        String url = String.format("%s/cls/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-2 集群状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listClsStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cls/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-3 删除集群
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCls(StringMap args) throws I2softException {
        String url = String.format("%s/cls", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 列表 - 状态(RAC)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRacStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cls/rac_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 切换维护
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/cls/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取GAUSS集群信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getGaussInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cls/gauss_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}