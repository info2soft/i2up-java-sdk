package com.i2soft.common.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class LicQuota {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public LicQuota(Auth auth) {
        this.auth = auth;
    }

    /**
     * 许可配额 - 总览
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map quotaOverview(StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota/quota_overview", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 许可配额 - 新增
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createLicQuota(StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 许可配额 - 退订
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map unsubscribeLicQuota(StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 许可配额 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicQuota(StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 许可配额 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLicQuota(String uuid) throws I2softException {
        String url = String.format("%s/lic_quota/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 许可配额 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateLicQuota(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 许可配额 - 获取绑定情况
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getLicQuotaBindList(StringMap args) throws I2softException {
        String url = String.format("%s/lic_quota/lic_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}