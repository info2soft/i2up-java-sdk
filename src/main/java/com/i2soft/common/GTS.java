package com.i2soft.common;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GTS {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GTS(Auth auth) {
        this.auth = auth;
    }

    /**
     * 解析许可授权
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic/describe", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 关闭服务
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map closeService() throws I2softException {
        String url = String.format("%s/gts/service/:uid([0-9] )", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 服务列表list
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listService(StringMap args) throws I2softException {
        String url = String.format("%s/gts/service/:uid([0-9] )", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 添加服务器
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createServer(StringMap args) throws I2softException {
        String url = String.format("%s/gts/hello", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 租户授权详情
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeQuota() throws I2softException {
        String url = String.format("%s/gts/quota", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 控制台概要
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSummary() throws I2softException {
        String url = String.format("%s/gts/summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}