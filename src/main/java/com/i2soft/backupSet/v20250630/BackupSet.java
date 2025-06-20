package com.i2soft.backupSet.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BackupSet {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BackupSet(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份集管理 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 获取列表查询候选信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listQueryArgsBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/query_args", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map extendBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map expireBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map setPrimaryBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map mountBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map unmountBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 手动删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDbBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 手动强制清理
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map manualForceDeleteDbBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/force_delete", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 标记删除（内部程序调用）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/delete", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集复制 - 提交复制规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBackupSetRepRule(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 单个
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/single", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 已删除备份集 单个
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeDeletedBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/single_deleted", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份集管理 - 查看副本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupSetCopy(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/copy_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集复制 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupSetRule(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 验证
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs validateBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份集管理 - 过期当前主副本 & 更新最小副本号备份集为主副本（内部程序调用）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resetPrimaryBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/reset_primary", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 查看备份链
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listBackupChain(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/backup_chain", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份集管理 - 演练
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs drillBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/drill", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取（存在备份集的）实例客户端列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSrcClient(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/list_src_client", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集管理 - 介质验证
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs validationBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/validation", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份集管理 - 获取介质验证结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getValidationResult(StringMap args) throws I2softException {
        String url = String.format("%s/backup_set/validation_result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}