package com.i2soft.nas;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class NAS {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public NAS(Auth auth) {
        this.auth = auth;
    }

    /**
     * 组 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createNAS(StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 组 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNASGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 组 编辑
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyNAS(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync/%s/group", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNAS() throws I2softException {
        String url = String.format("%s/nas/sync", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNASStatus(StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteNAS(StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 操作：启停
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/nas/sync/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }
}