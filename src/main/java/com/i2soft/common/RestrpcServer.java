package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RestrpcServer {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RestrpcServer(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取规则和任务
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRestRpcTasks(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/task_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 底层推送日志接口，日志、状态等
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcLog(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 上报结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcresult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取控制机IP或节点代理开关
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRestRpcCcip(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cc_ip", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Ha动态节点切换后上报接口
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcHa(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/ha", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务器池更新底层传上来的中心节点IP
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs addRestRpcCluster(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cluster", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云主机 - 创建结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyEcs(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/rest_rpc/cloud_ecs", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}