package com.i2soft.cloud.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CloudBackup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CloudBackup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份 - 准备 - 工作机获取设备列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDevice(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/device_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份 - 准备  备机获取可用云硬盘列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listIdleDevice(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/ecs/idle_device_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份(云容灾-整机复制) - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份(云容灾-整机复制) - 修改
     *
     * @param uuid: uuid
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyBackup(String uuid) throws I2softException {
        String url = String.format("%s/cloud/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.body();
    }

    /**
     * 备份(云容灾-整机复制) - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCloudBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份(云容灾-整机复制) - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份(云容灾-整机复制) - 启停
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份(云容灾-整机复制) - 启停
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份(云容灾-整机复制) - 启停
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startImmediatelyBackup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份(云容灾-整机复制) - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackup(String uuid) throws I2softException {
        String url = String.format("%s/cloud/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 整机复制 源端virtio驱动检查
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifySourceVirtioDriver(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/backup/verify_source_virtio_driver", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}