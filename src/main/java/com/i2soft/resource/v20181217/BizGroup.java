package com.i2soft.resource.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BizGroup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BizGroup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 添加
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBizGroup(StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 更新
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBizGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBizGroup(String uuid) throws I2softException {
        String url = String.format("%s/biz_grp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 5 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBizGroup(StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 4 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBizGroup(StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 更新绑定
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateBizGroupBind(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp/%s/bind", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取绑定情况
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBizGroupBind(String uuid) throws I2softException {
        String url = String.format("%s/biz_grp/%s/bind", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 1 获取 Res 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBizGroupResource(StringMap args) throws I2softException {
        String url = String.format("%s/biz_grp/res", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}