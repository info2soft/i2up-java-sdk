package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Client {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Client(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步修改从类型节点
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSlaveNode(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/update_slave_node", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取所有虚拟平台
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVirtualPlatforms(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_virtual_platforms", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取指定虚拟平台上的所有规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVirtualPlatformRules(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_virtual_platform_rules", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制/NAS规则，创建比较结果副本
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCompareResultBak(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/create_compare_result_bak", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制/NAS规则，创建比较结果
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/create_compare_result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 接收比较与同步任务执行结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map collectCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/collect_compare_result", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 上传比较与同步执行差异详情
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs uploadCompareDiffDetail(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/upload_diff_detail", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取所有对象存储
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDtoStorageList(StringMap args) throws I2softException {
        String url = String.format("%s/api/client/get_dto_storage_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}