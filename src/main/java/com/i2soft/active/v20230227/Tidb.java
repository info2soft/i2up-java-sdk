package com.i2soft.active.v20230227;


import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Tidb {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Tidb(Auth auth) {
        this.auth = auth;
    }

    /**
     * tidb规则管理-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createTidbRule(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * tidb规则管理-修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTidbRule(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * tidb规则管理-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTidbRule(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * tidb规则管理-获取单个信息
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTidbRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * tidb规则管理-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeTidbRule(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * tidb规则管理-规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTidbRules(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * tidb规则管理-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTidbStatus(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * tidb规则管理-日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTidbLog(StringMap args) throws I2softException {
        String url = String.format("%s/tidb/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}