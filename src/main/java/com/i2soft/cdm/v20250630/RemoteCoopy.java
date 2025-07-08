package com.i2soft.cdm.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RemoteCoopy {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RemoteCoopy(Auth auth) {
        this.auth = auth;
    }

    /**
     * 环境检测 -- 目标机器是否存在重复规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyDuplicateCdmCoopyRule(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/verify_duplicate_cdm_coopy_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] createCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 远程复制 - 列表获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs migrateCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startImmediatelyCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdmRemoteCoopyStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCdmRemoteCoopy(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制规则单独获取
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCdmRemoteCoopy(String uuid) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 环境检测 -- 存储空间容量检查
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyCdmCapacity(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/verify_cdm_capacity", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * CDM 检查原备存储是否有多余CDM许可
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listCdmRemoteCoopyLicense(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/verify_license", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * CDM 目标存储已存在目录检查
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyCdmDirExist(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_remote_coopy/verify_dir_exist", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}