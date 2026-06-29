package com.i2soft.backupWork.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BackupWork {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BackupWork(Auth auth) {
        this.auth = auth;
    }

    /**
     * 定时任务 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 获取单个任务
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupWork(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBackupWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 获取日志
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWorkLogs(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/%s/logs", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 获取关键事件
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWorkKeyEvents(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/%s/key_events", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 查看任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupWorkResult(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 查看备份集相关任务结果
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupMigrateWorkResult(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/%s/result_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 定时任务 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs rebootBackupWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时任务 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopBackupWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时任务 - 下载失败文件清单
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] downloadFailedFileList(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/download_failed_file_list", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 定时任务 - 下载转储记录
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] downloadMigrateWorkList(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/download_migrate_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 定时任务 - 设置虚机优先级
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs seVmpriority(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/set_vm_priority", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时任务 - 获取任务CDP延迟信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWorkCdpResult(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/cdp_result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 过滤器 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWorkFilter() throws I2softException {
        String url = String.format("%s/vers/v3/backup_work_filter", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 过滤器 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBackupWorkFilter(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work_filter", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 过滤器 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBackupWorkFilter(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work_filter/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 过滤器 - 详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupWorkFilter(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work_filter/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 过滤器 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBackupWorkFilter(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work_filter", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集验证任务 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupVerifyWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/verify_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份集验证记录 - 获取单个任务
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupVerifyWork(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/verify_list/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份集验证记录 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBackupVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_work/verify_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}