package com.i2soft.common.v20181217;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Qr {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Qr(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1.时间戳
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimeStamp(StringMap args) throws I2softException {
        String url = String.format("%s/qr/t", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3.生成二维码图片
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createQrPic(StringMap args) throws I2softException {
        String url = String.format("%s/qr", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 二维码 - 操作：检查登陆状态
     *
     * @param uuid: 二维码唯一ID
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs checkQrValidity(String uuid) throws I2softException {
        String url = String.format("%s/qr/event", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("uuid", uuid).put("action", 0);
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 二维码 - 操作：确认登陆
     *
     * @param uuid: 二维码唯一ID
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs confirmLogin(String uuid) throws I2softException {
        String url = String.format("%s/qr/event", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("uuid", uuid).put("action", 1);
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 二维码 - 操作：取消登陆
     *
     * @param uuid: 二维码唯一ID
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cancelLogin(String uuid) throws I2softException {
        String url = String.format("%s/qr/event", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("uuid", uuid).put("action", 2);
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2.获取二维码内容
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map obtainQrContent(StringMap args) throws I2softException {
        String url = String.format("%s/qr/generate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 5.检查二维码状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkQrStatus(StringMap args) throws I2softException {
        String url = String.format("%s/qr/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}