package com.i2soft.snapshotTask.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class SnapshotTask {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public SnapshotTask(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createSnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改
     *
     * @param uuid: uuid
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifySnapshotTask(String uuid) throws I2softException {
        String url = String.format("%s/snapshot_task/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.body();
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSnapshotTaskStatus(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 快照任务-获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSnapshotTask(String uuid) throws I2softException {
        String url = String.format("%s/snapshot_task/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startImmediatelySnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startSnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopSnapshotTask(StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取任务快照列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSnapshotList(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除任务快照
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSnapshotList(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/snapshot_task/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}