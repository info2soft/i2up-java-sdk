package com.i2soft.stream.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class OracleBkTakeover {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public OracleBkTakeover(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备端接管-获取网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeoveNetworkCard(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_bk_takeover/bk_network_card", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_bk_takeover", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-接管结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeoverResult(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_bk_takeover/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}