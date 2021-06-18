package com.i2soft.cloud;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CloudRehearse {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CloudRehearse(Auth auth) {
        this.auth = auth;
    }

    /**
     * 云端演练-准备-主机列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHost() throws I2softException {
        String url = String.format("%s/cloud/rehearse/host_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-云主机列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEcs(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/ecs_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-恢复点信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRecoveryPoint(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/rc_point_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-区域可用区
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAvailabilityZone(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/availability_zone", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-规格列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFlavor(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/flavor_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-虚拟私有云列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpc(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/vpc_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-虚拟子网列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSubnet(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/subnet_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-准备-安全组列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSecureGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/secure_group_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 新建 - 批量
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBatchRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-列表-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRehearseStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 列表 - 远程登陆
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVncConsole(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/vnc_console", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-撤销
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs evacuateRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/evacuate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 批量撤销
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs evacuateBatchRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/batch_evacuate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练-演练详情
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRehearseDetail(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/detail", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练-获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRehearse(String uuid) throws I2softException {
        String url = String.format("%s/cloud/rehearse/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云端演练-删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练-演练历史（被撤销的演练列表）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEvacuatedRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/evacuated_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 状态 - 底层上传
     *
     * @param uuid: uuid
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listNpsvrRehearseStatus(String uuid) throws I2softException {
        String url = String.format("%s/cloud/rehearse/:uuid([a-fa-f0-9-] )/status", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 进度 - 底层上传
     *
     * @param uuid: uuid
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listNpsvrRehearseProgress(String uuid) throws I2softException {
        String url = String.format("%s/cloud/rehearse/:uuid([a-fa-f0-9-] )/progress", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 演练网络配置 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listNetwork(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/network_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 演练网络配置 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createNetwork(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/network_conf", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 子网下已使用的ip列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSubnetUsedIp(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/subnet_used_ip_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 组演练 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 组演练 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGroup() throws I2softException {
        String url = String.format("%s/cloud/rehearse/group", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 组演练 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeGroup(String uuid) throws I2softException {
        String url = String.format("%s/cloud/rehearse/group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 组演练 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 组演练 - 撤销
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createEvacuateGroup(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/group_evacuate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 云端演练 - 组演练 - 列表状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGroupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/group_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 组演练 - 历史列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEvacuatedGroup() throws I2softException {
        String url = String.format("%s/cloud/rehearse/evacuated_group_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 云端演练 - 批量获取演练信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBatchRehearse(StringMap args) throws I2softException {
        String url = String.format("%s/cloud/rehearse/batch", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}