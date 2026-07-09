package com.i2soft.resource.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Ukey {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Ukey(Auth auth) {
        this.auth = auth;
    }

    /**
     * Ukey - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Ukey - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUkey(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ukey/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Ukey - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map discribeUkey(String uuid) throws I2softException {
        String url = String.format("%s/ukey/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Ukey - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUkey() throws I2softException {
        String url = String.format("%s/ukey", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Ukey - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resetUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map keyUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cloneUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getPwdUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map bindNodeUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map untieNodeUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUkeyStatus(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 获取关联节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUkeyNodeList(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/node_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 扫描
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map scanUkey(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/scan", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Ukey - 口令导出接口
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportUkeyInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/export_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * Ukey - 口令导入接口
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs importUkeyInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ukey/import_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}