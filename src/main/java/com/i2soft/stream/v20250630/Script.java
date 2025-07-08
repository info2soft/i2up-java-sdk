package com.i2soft.stream.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Script {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Script(Auth auth) {
        this.auth = auth;
    }

    /**
     * 自定义脚本 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 自定义脚本 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyScript(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 自定义脚本 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 自定义脚本 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 自定义脚本 - 下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 自定义脚本 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptScript(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/mask/script/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}