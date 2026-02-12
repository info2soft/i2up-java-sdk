package com.i2soft.resource.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ActiveDbType {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ActiveDbType(Auth auth) {
        this.auth = auth;
    }

    /**
     * 数据库支持类型 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveDbType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库支持类型 - 支持的映射类型
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listActiveDbTypeAvailMappingType() throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type/mapping_type", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 数据库支持类型 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createActiveDbType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库支持类型 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyActiveDbType(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库支持类型 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteActiveDbType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取特定菜单可用源端类型 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAvailActiveDbSourceType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type/avail_src_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库备端支持类型 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAvailActiveDbType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type/avail_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据库备端支持类型 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyAvailActiveDbType(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/active/db_type/type_mapping", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}