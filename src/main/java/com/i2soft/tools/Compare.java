package com.i2soft.tools;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Compare {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Compare(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCompare(StringMap args) throws I2softException {
        String url = String.format("%s/compare", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取单个(包括比较结果)
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCompare(String uuid) throws I2softException {
        String url = String.format("%s/compare/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 2 获取比较结果详情
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeCompareResults() throws I2softException {
        String url = String.format("%s/logs", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCompare(StringMap args) throws I2softException {
        String url = String.format("%s/compare", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 2 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCompareStatus(StringMap args) throws I2softException {
        String url = String.format("%s/compare/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 比较与同步 - 操作：删除
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCompare(String[] uuids) throws I2softException {
        String url = String.format("%s/compare/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "delete");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 比较与同步 - 操作：下载
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public Map downloadCompare(String[] uuids) throws I2softException {
        String url = String.format("%s/compare/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "download");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(Map.class);
    }

    /**
     * 3 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCompare(StringMap args) throws I2softException {
        String url = String.format("%s/compare", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1.1 获取结果列表（周期）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCircleCompareResult(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/compare/%s/result_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }
}