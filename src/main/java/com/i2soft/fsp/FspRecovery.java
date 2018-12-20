package com.i2soft.fsp;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class FspRecovery {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public FspRecovery(Auth auth) {
        this.auth = auth;
    }

    /**
     * 0 获取源节点磁盘和文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryDir(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/dir_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 0 获取两节点网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryNic(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/nic_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 0 获取还原点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryPoint(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/point_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 1 检测条件-磁盘空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspRecoveryVolumeSpace(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_volume_space", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 1 检测条件-旧规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspRecoveryOldRule(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_old_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测条件-license
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspRecoveryLicense(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_license", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测条件-系统版本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspRecoveryOsVersion(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_os_version", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 2 新建规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 修改规则
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyFspRecovery(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取单个规则
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map desribeFspRecovery(String uuid) throws I2softException {
        String url = String.format("%s/fsp/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 3 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 获取规则列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 全服还原 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startFspRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服还原 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopFspRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服还原 - 操作：迁移
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs moveFspRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "move");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服还原 - 操作：重启备机
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs rebootFspRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/fsp/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("fsp_uuids", uuids).put("operate", "reboot");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 规则状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }
}