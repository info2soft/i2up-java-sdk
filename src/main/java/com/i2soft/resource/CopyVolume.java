package com.i2soft.resource;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CopyVolume {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CopyVolume(Auth auth) {
        this.auth = auth;
    }

    /**
     * 复制卷 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCopyVolume(StringMap args) throws I2softException {
        String url = String.format("%s/copy_volume", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制卷 - 修改
     *
     * @param uuid: uuid
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCopyVolume(String uuid) throws I2softException {
        String url = String.format("%s/copy_volume/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 复制卷 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCopyVolume(String uuid) throws I2softException {
        String url = String.format("%s/copy_volume/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 复制卷 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map copyVolumeList(StringMap args) throws I2softException {
        String url = String.format("%s/copy_volume", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制卷 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCopyVolume(StringMap args) throws I2softException {
        String url = String.format("%s/copy_volume", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 复制卷 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCopyVolumeStatus(StringMap args) throws I2softException {
        String url = String.format("%s/copy_volume/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个卷快照列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSnapshotList(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/copy_volume/%s/snapshot_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}