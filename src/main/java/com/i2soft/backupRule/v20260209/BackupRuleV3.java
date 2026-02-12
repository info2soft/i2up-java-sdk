package com.i2soft.backupRule.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BackupRuleV3 {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BackupRuleV3(Auth auth) {
        this.auth = auth;
    }

    /**
     * 备份规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBackupRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备份规则 - 批量设置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchModifyBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/batch_update", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 获取单个详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map enableBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map disableBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map manualStartBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cloneBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rebootBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备份规则 - NBU备份清理临时数据
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs cleanNbuCache(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/clean_nbu_cache", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Oracle备份 - 获取脚本路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeScriptPath(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/script_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * oracle - 获取备份脚本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBackupScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/script", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * oracle - 修改备份脚本
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBackupScript(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/script", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * oracle - 获取数据库列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOracleDatabases(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/oracle_database", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * oracle - 获取数据库对象信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listOracleObjects(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/oracle_object", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * doris - 获取数据库列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDorisDb(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/list_doris_db", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * polardbx备份加密开关状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkPolardbXEncrypt(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/check_polardb_x_encrypt", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * exchange获取备份内容
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeExchangeInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/exchange_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Elasticsearch获取索引
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listElasticsearchIndics(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/elasticsearch_indices", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * MongoDB - 获取数据库
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMongoDBDatabases(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/mongodb_database", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * MongoDB - 获取表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMongoDBTables(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/backup_rule/mongodb_tables", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}