package com.i2soft.cloud;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CloudPlatform {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CloudPlatform(Auth auth) {
        this.auth = auth;
    }

    /**
     * 云平台 - 准备 - 获取区域列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCloudPlatformRegion() throws I2softException {
        String url = String.format("%s/cloud/platform/region_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云平台 - 注册
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs registerCloudPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云平台 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCloudPlatform(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/:uuid([a-f0-9-] ])", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云平台 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCloudPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 云平台 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCloudPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云平台 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCloudPlatformStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云平台 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCloudPlatform(String uuid) throws I2softException {
        String url = String.format("%s/cloud/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云平台 - 同步云主机
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs syncEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/sync_ecs", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云平台 - 同步云硬盘
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs syncVolume(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/sync_volume", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云平台 - 获取规格信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFlavor(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/flavor_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云平台 - 获取关联节点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRelativeNode(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/node_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云平台 - 切换维护
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/platform/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}