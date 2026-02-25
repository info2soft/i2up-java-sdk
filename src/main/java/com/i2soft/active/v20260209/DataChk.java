package com.i2soft.active.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DataChk {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DataChk(Auth auth) {
        this.auth = auth;
    }

    /**
     * 对象比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacheckObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createDatacheckObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp", auth.cc_url);
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
        String url = String.format("%s/datacheck/obj_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDatacheckObjCmp(String uuid) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
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
        String url = String.format("%s/datacheck/obj_cmp/operate", auth.cc_url);
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
        String url = String.format("%s/datacheck/obj_cmp/operate", auth.cc_url);
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
        String url = String.format("%s/datacheck/obj_cmp/operate", auth.cc_url);
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
        String url = String.format("%s/datacheck/obj_cmp/operate", auth.cc_url);
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
        String url = String.format("%s/datacheck/obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较-比较结果时间列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacheckObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDatacheckObjCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取对象比较状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacheckObjCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeDatacheckObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较-比较结果详细信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacheckObjCmpCmpInfo(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/obj_cmp/cmp_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 历史结果（查看表比较时间结果集）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeTbCmpResuluTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-错误信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpErrorMsg(StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/error_msg", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-比较结果
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpCmpResult(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/cmp_result/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-表比对的详细信息
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpCmpDesc(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/%s/describe", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-启动表比对
     *
     * @param uuid: uuid
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeTbCmpStart(String uuid) throws I2softException {
        String url = String.format("%s/datacheck/tb_cmp/%s/start", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}