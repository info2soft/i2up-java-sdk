package com.i2soft.stream.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class MaskSensType {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public MaskSensType(Auth auth) {
        this.auth = auth;
    }

    /**
     * 敏感类型 - 修改
     *
     * @param id: id
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifySensType(Integer id, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/sens_type/%s", auth.cc_url, id);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 敏感类型 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTypes(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/sens_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 敏感类型 - 单个
     *
     * @param id: id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptSensType(Integer id) throws I2softException {
        String url = String.format("%s/vers/v3/mask/sens_type/%s", auth.cc_url, id);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}