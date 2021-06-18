package com.i2soft.ha;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Label {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Label(Auth auth) {
        this.auth = auth;
    }

    /**
     * 应用高可用 - 集群服务器池 标签 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createLabel(StringMap args) throws I2softException {
        String url = String.format("%s/ha/service_label", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 标签 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyLabel(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/service_label/:uuid([a-f0-9-] ])", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 标签 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteLabel(StringMap args) throws I2softException {
        String url = String.format("%s/ha/service_label", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 应用高可用 - 集群服务器池 标签 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLabel(StringMap args) throws I2softException {
        String url = String.format("%s/ha/service_label", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}