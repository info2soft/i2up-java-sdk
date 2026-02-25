package com.i2soft.active.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class MysqlRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public MysqlRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备端接管-获取网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeoveNetworkCard(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/bk_network_card", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeover(String uuid) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备机接管-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-接管结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeoverResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备机接管-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备端接管-获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeoverStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeover() throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}