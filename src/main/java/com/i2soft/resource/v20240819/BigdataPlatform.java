package com.i2soft.resource.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BigdataPlatform {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BigdataPlatform(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份主机 - 认证
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs authBigdataBackupHost(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份主机 - 数据库认证
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs bigdataBackupHostDbAuth(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host/db_auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份主机 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBigdataBackupHost(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份主机 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupHost() throws I2softException {
        String url = String.format("%s/bigdata/backup_host", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份主机 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigdataBackupHost(String uuid) throws I2softException {
        String url = String.format("%s/bigdata/backup_host/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份主机 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBigdataBackupHost(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份主机 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBigdataBackupHost(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份主机 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupHoststatus(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/backup_host/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据平台 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBigdataPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/platform", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据平台 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigdataPlatform(String uuid) throws I2softException {
        String url = String.format("%s/bigdata/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大数据平台 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBigdataPlatform(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据平台 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataPlatform() throws I2softException {
        String url = String.format("%s/bigdata/platform", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大数据平台 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBigdataPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据平台 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataPlatformStatus(StringMap args) throws I2softException {
        String url = String.format("%s/bigdata/platform/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}