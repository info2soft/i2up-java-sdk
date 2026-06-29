package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GeneralSettings {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GeneralSettings(Auth auth) {
        this.auth = auth;
    }

    /**
     * etcd有效性检查
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs chkEtcdUrl(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/etcd/etcd_url_chk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ETCD - 新建/更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createUpdateEtcd(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/etcd", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * ETCD - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEtcd() throws I2softException {
        String url = String.format("%s/vers/v3/etcd", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * ETCD - 发现
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map scanEtcdConf(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/etcd/scan", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 服务调度器 - 新建/更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createUpdateScheduleSvr(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/schedule_svr", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 服务调度器 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listScheduleSvr() throws I2softException {
        String url = String.format("%s/vers/v3/schedule_svr", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}