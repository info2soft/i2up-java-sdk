package com.i2soft.backupDomain.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BackupDomain {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BackupDomain(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份域 - 获取目标域存储单元列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTargetDomainStorageUnit(StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain/storage_unit", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份域 - 获取目标域存储单元状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTargetDomainStorageUnitStatus(StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain/storage_unit_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份域 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] createBackupDomain(StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 备份域 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyBackupDomain(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.body();
    }

    /**
     * 备份域 - 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authBackupDomain(StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份域 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupDomain() throws I2softException {
        String url = String.format("%s/backup_domain", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份域 - 单个查看
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupDomain(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份域 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] deleteBackupDomain(StringMap args) throws I2softException {
        String url = String.format("%s/backup_domain", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.body();
    }
}