package com.i2soft.rep.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RepRecovery {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RepRecovery(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 新建任务
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRepRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 获取单个任务
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRepRecovery(String uuid) throws I2softException {
        String url = String.format("%s/rep/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 1 修改单个任务
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyRepRecovery(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 删除任务
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteRepRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取任务列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制规则恢复 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startRepRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/rep/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rc_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则恢复 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopRepRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/rep/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("rc_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制规则恢复 - 操作：清除已完成的任务
     *
     * @param rc_type: 清除的 rc_type： 0普通，1 CDP，2镜像
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs clearFinishRepRecovery(Integer rc_type) throws I2softException {
        String url = String.format("%s/rep/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotNull("rc_type", rc_type).put("operate", "clear_finish");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 任务状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 获取CDP时间范围
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepRecoveryCdpRange(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery/cdp_range", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 获取CDP日志列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRepRecoveryCdpLog(StringMap args) throws I2softException {
        String url = String.format("%s/rep/recovery/cdp_log", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}