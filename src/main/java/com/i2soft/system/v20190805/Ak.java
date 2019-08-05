package com.i2soft.system.v20190805;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Ak {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Ak(Auth auth) {
        this.auth = auth;
    }

    /**
     * AccessKey列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAk() throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * AccessKey新建
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAk() throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * AccessKey更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * AccessKey删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}