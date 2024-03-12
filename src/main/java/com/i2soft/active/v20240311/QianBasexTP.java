package com.i2soft.active.v20240311;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class QianBasexTP {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public QianBasexTP(Auth auth) {
        this.auth = auth;
    }

    /**
     * qianbasexTP同步规则
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listQianbasexTPRule(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createQianbasexTPRule(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyQianbasexTPRule(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteQianbasexTPRule(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * qianbase规则-状态
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listQianbasexTPStatus(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 启/停/重新同步/继续
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * qianbase日志
     * @deprecated
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listQianbasexTPRuleLog(StringMap args) throws I2softException {
        String url = String.format("%s/qianbasextp/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}