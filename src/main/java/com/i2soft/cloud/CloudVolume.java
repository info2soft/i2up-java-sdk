package com.i2soft.cloud;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CloudVolume {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CloudVolume(Auth auth) {
        this.auth = auth;
    }

    /**
     * 云硬盘 - 准备 - 获取可用区
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listZone(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume/zone_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云硬盘 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云硬盘 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 云硬盘 - 挂载
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume/attach", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云硬盘 - 卸载
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs detachVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume/detach", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云硬盘 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云硬盘 - 状态
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listVolumeStatus() throws I2softException {
        String url = String.format("%s/cloud/volume/status", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云硬盘 - 查询镜像列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listImage(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume/image_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云硬盘 - 挂载 获取同一可用区云主机
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVolumeEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/volume/ecs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}