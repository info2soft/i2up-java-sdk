package com.i2soft.fsp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
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
     * 全服恢复-0 获取源节点磁盘和文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryDir(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/dir_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-0 获取还原点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryPoint(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/point_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-1 检测条件-磁盘空间
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspRecoveryVolumeSpace(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_volume_space", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * （废除）全服恢复-1 检测条件-license
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
     * 全服恢复-1 检测条件-旧规则
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
     * 全服恢复-1 检测条件-系统版本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspRecoveryOsVersion(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/verify_os_version", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-2 新建规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-2 修改规则
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
     * 全服恢复-2 获取单个规则
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map desribeFspRecovery(String uuid) throws I2softException {
        String url = String.format("%s/fsp/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 全服恢复-3 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-3 获取规则列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 全服恢复-3 规则操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateFspRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服恢复-3 规则状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 环境检查
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyEnvironment(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/backup/verify_environment", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 全服恢复-获取磁盘信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspRecoveryDriverInfo(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/recovery/driver_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}