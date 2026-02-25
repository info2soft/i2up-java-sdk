package com.i2soft.fsp.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class FspMove {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public FspMove(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 检测迁移条件-获取两节点网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspMoveNic(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/move/nic_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 检测迁移条件-获取源节点磁盘和文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspMoveDir(StringMap args) throws I2softException {
        String url = String.format("%s/fsp/move/dir_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 检测迁移条件-检测迁移条件-磁盘
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspMoveVolumeSpace(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/verify_volume_space", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 检测迁移条件-检测迁移条件-license
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspMoveLicense(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/verify_license", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测迁移条件-检测迁移条件-旧规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspMoveOldRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/verify_old_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 1 检测迁移条件-检测迁移条件-系统版本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyFspMoveOsVersion(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/verify_os_version", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 检测迁移条件 - 环境监测
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyFspMoveEnvironment(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/verify_environment", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 检测迁移条件 - 获取节点网络配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeNetworks(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/networks", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建 - 准备 - 获取源端驱动列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspMoveDriverInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/driver_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 新建/编辑-新建规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createFspMove(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 新建/编辑-获取单个规则
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeFspMove(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2 新建/编辑-修改规则
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyFspMove(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 列表-删除规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteFspMove(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 列表-获取规则列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspMove(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 列表-规则操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startFspMove(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3 列表-规则状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspMoveStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 业务迁移 - 批量创建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs batchCreateFspMove(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/move/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}