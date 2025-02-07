package com.i2soft.dedupeStorage.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DedupeStorage {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DedupeStorage(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createDedupeStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDedupeStorage(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDedupeStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDedupeStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDedupeStorage(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDedupeStorageStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map recoverSpaceDedupeStorage(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取备份服务器重删存储已使用端口列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkSvrUsedPorts(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dedupe_storage/list_bk_used_port", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}