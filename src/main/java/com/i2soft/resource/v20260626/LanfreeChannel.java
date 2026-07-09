package com.i2soft.resource.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class LanfreeChannel {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public LanfreeChannel(Auth auth) {
        this.auth = auth;
    }

    /**
     * LANFREE通道 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createLanfreeChannel(StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * LANFREE通道 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLanfreeChannel() throws I2softException {
        String url = String.format("%s/lanfree_channel", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * LANFREE通道 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLanfreeChannel(String uuid) throws I2softException {
        String url = String.format("%s/lanfree_channel//%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * LANFREE通道 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyLanfreeChannel(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel//%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * LANFREE通道 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteLanfreeChannel(StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * LANFREE通道 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLanfreeChannelStatus(StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 根据客户端、备端获取lanfree列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLanfreeChannelByWkBk(StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel/list_by_wk_bk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * LANFREE通道 - 查看通道
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLanfreeChannelInfo(StringMap args) throws I2softException {
        String url = String.format("%s/lanfree_channel/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}