package com.i2soft.common.v20181217;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

public final class DataBaseBackup {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DataBaseBackup(Auth auth) {
        this.auth = auth;
    }

    /**
     * 配置导入
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs importConfig() throws I2softException {
        String url = String.format("%s/cc/import", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置导出
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs exportConfig() throws I2softException {
        String url = String.format("%s/cc/export", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份历史
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listBackupHistory() throws I2softException {
        String url = String.format("%s/cc/backup_history", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份配置
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs backupConfig() throws I2softException {
        String url = String.format("%s/cc/backup", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份配置详情
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeBackupConfig() throws I2softException {
        String url = String.format("%s/cc/backup", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}