package com.i2soft.common.v20230227;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GeneralInterface {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GeneralInterface(Auth auth) {
        this.auth = auth;
    }

    /**
     * 统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsReport(StringMap args) throws I2softException {
        String url = String.format("%s/statistics/report", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}