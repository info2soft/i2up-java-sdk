package com.i2soft.cdm.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Cdm {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Cdm(Auth auth) {
        this.auth = auth;
    }

    /**
     * 整机复制 --- 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createCdm(StringMap args) throws I2softException {
        String url = String.format("%s/cdm", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机复制 --- 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCdm(String uuid) throws I2softException {
        String url = String.format("%s/cdm/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 整机复制 --- 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCdm(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/cdm/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机复制 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCdm(StringMap args) throws I2softException {
        String url = String.format("%s/cdm", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机复制 --- 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdm(StringMap args) throws I2softException {
        String url = String.format("%s/cdm", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机复制 --- 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdmStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机复制 --- 根据工作机获取规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getByWk(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/get_by_wk", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份点列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getPointList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/point_full_info_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getNetworkList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/network_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 根据存储获取工作机列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getNodeList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/restore_node_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取资源列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getResourceList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/drp_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取主机存储资源
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getHostStorageList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/host_storage_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 按虚机恢复获取磁盘
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVmInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/vm_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取备份点列表(刷新虚机规则对应关系)
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listDrillRestorePoint(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/auto_drill_restore_point_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 环境检测 -- Oracle是否开启归档
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyOracleArchiveMode(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/verify_oracle_archive_mode", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机复制 - 数据库保护自定义脚本检测
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cdmScriptPathCheck(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/script_path_check", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机复制 - 获取节点设备列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdmDriverInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cdm/device_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}