package com.i2soft.active;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Summary {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Summary(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取总览列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryView(StringMap args) throws I2softException {
        String url = String.format("%s/active/summary/list_view", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 总览页面
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummary() throws I2softException {
        String url = String.format("%s/active/summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 测试-总览拓补图
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryChart() throws I2softException {
        String url = String.format("%s/active/summary/chart", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}