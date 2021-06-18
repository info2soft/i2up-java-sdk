package com.i2soft.cloud;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CloudEcs {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CloudEcs(Auth auth) {
        this.auth = auth;
    }

    /**
     * 云主机 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 列表 - 远程登录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVncConsole(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/vnc_console", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 状态
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listEcsStatus() throws I2softException {
        String url = String.format("%s/cloud/ecs/status", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/cloud/ecs/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 云主机 - 获取公网私网IP等信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getTakeoverECSInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/takeover_ecs_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 获取空闲挂载点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map attachPoint(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/attach_point", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 节点操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/node_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 配置演练
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs configRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/rehearse_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 演练组 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRehearseGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/rehearse_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云主机 - 演练组 - 新建/更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRehearseGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/rehearse_group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 演练组 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteRehearseGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/rehearse_group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 演练组 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRehearseGroup(String uuid) throws I2softException {
        String url = String.format("%s/cloud/ecs/rehearse_group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}