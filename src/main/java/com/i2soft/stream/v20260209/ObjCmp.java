package com.i2soft.stream.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ObjCmp {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ObjCmp(Auth auth) {
        this.auth = auth;
    }

    /**
     * 对象比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDatacheckObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDatacheckObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cmpStopTimeObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cmpResumeTimeObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cmpImmediateObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncObjCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportSyncObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_obj_cmp/export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }
}