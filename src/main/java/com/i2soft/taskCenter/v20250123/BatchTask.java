package com.i2soft.taskCenter.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BatchTask {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BatchTask(Auth auth) {
        this.auth = auth;
    }

    /**
     * 任务列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchTaskList(StringMap args) throws I2softException {
        String url = String.format("%s/batch_task", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 任务状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchTaskStatus(StringMap args) throws I2softException {
        String url = String.format("%s/batch_task/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 任务操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startBatchTask(StringMap args) throws I2softException {
        String url = String.format("%s/batch_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 任务操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopBatchTask(StringMap args) throws I2softException {
        String url = String.format("%s/batch_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 任务操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBatchTask(StringMap args) throws I2softException {
        String url = String.format("%s/batch_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}