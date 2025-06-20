package com.i2soft.resource.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class StorageUnit {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public StorageUnit(Auth auth) {
        this.auth = auth;
    }

    /**
     * 存储单元 - 准备(查看容量)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getStorageUnitBkCapacity(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/capacity", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 获取驱动数量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getStorageUnitDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/drivers", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createStorageUnit(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储单元 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStorageUnit(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储单元 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStorageUnit(String uuid) throws I2softException {
        String url = String.format("%s/storage_unit/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStorageUnit(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteStorageUnit(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStorageUnitStatus(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 提交前检查
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map chkStorageUnitRules(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/rules_chk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元组 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createStorageUnitGroup(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit_group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储单元组 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStorageUnitGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit_group/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 存储单元组 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStorageUnitGroup(String uuid) throws I2softException {
        String url = String.format("%s/storage_unit_group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 存储单元组 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStorageUnitGroup(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit_group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元组 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteStorageUnitGroup(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit_group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 存储单元 - 可用并发数
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getStorageUnitAvailableConcurrent(StringMap args) throws I2softException {
        String url = String.format("%s/storage_unit/available_concurrent", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}