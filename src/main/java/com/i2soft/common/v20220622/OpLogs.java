package com.i2soft.common.v20220622;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class OpLogs {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public OpLogs(Auth auth) {
        this.auth = auth;
    }

    /**
     * 操作日志-获取操作日志列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/op_log", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * （未添加）操作日志-日志下载
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] downloadOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/op_log", auth.cc_url);
        Response r = auth.client.get(url, args);

        return r.body();
    }

    /**
     * 操作日志-删除操作日志
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteOpLog(StringMap args) throws I2softException {
        String url = String.format("%s/op_log", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}