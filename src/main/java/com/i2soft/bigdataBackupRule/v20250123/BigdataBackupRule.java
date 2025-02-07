package com.i2soft.bigdataBackupRule.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BigdataBackupRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BigdataBackupRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 大数据备份 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupRule() throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大数据备份 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBigdataBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据备份 - 修改
     *
     * @param uuid: uuid
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyBigdataBackupRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, new StringMap());
        return r.body();
    }

    /**
     * 大数据备份 - 单个
     *
     * @param uuid: uuid
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] describeBigdataBackupRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * 大数据备份 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs manualStartBigdataBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs disableBigdataBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs enableBigdataBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大数据备份 - 获取备份历史信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupRuleBakHistory(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/bak_history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据备份 - 获取Hive表信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupRuleHiveTableInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/hive_table_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大数据备份 - 获取Hive分区信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigdataBackupRuleHivePartitionInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/bigdata/backup_rule/hive_partition_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}