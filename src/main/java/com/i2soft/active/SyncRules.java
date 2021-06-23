package com.i2soft.active;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.Json;
import com.i2soft.util.StringMap;

import java.util.Map;
import java.util.Objects;

public final class SyncRules {

    public static final String DB_TYPE_ORACLE = "oracle";
    public static final String DB_TYPE_MYSQL = "mysql";
    public static final String DB_TYPE_KAFKA = "kafka";

    /**
     * Auth 对象
     */
    private final Auth auth;

    private OracleRule oracleRule;
    private Mysql mysqlRule;
    private Kafka kafkaRule;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public SyncRules(Auth auth) {
        this.auth = auth;
        this.oracleRule = new OracleRule(auth);
        this.mysqlRule = new Mysql(auth);
        this.kafkaRule = new Kafka(auth);
    }

    /**
     * 同步规则 - 规则类型（实例）
     *
     * @param uuid: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Rule getRuleInstanceByUUID(String uuid) throws I2softException {
        String url = String.format("%s/active/rule_type/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        Map rs = r.jsonToMap();
        switch ((String) rs.get("rule_type")) {
            case DB_TYPE_KAFKA:
                return kafkaRule;
            case DB_TYPE_MYSQL:
                return mysqlRule;
            case DB_TYPE_ORACLE:
            default:
                return oracleRule;
        }
    }

    /**
     * 同步规则 - 规则类型
     *
     * @param uuid: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public String getRuleTypeByUUID(String uuid) throws I2softException {
        String url = String.format("%s/active/rule_type/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        Map rs = r.jsonToMap();
        return (String) rs.get("rule_type");
    }

    /**
     * 同步规则-增量失败DML统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesDML(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/incre_dml_summary", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-已同步的对象具体信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesObjInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/sync_obj_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步|对象比较|对象修复|表比较 - 新建-准备-获取代理状态
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesProxyStatus() throws I2softException {
        String url = String.format("%s/active/rule/proxy_status", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 新建
     *
     * @param paramString: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2CreateRs createSyncRule(String srcType, String paramString) throws I2softException {
        StringMap args = new StringMap().putAll(Objects.requireNonNull(Json.decode(paramString).map()));
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.createMysqlRule(args);
            case DB_TYPE_KAFKA:
                return kafkaRule.createConsumerRule(args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.createOracleRule(args);
        }
    }

    /**
     * 同步规则 - 修改
     *
     * @param uuid: 规则uuid
     * @param paramString: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifySyncRule(String uuid, String paramString) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        StringMap args = new StringMap().putAll(Objects.requireNonNull(Json.decode(paramString).map()));
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.modifyStreamRule(args);
            case DB_TYPE_KAFKA:
                return kafkaRule.modifyConsumerRule(args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.modifyOracleRule(args);
        }
    }

    /**
     * 同步规则-获取单个详细信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRule(String uuid) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.describeMysqlRule(uuid);
            case DB_TYPE_KAFKA:
                return kafkaRule.describeConsumerRule(uuid);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.describeOracleRule(uuid);
        }
    }

    /**
     * 同步规则-删除单个
     *
     * @param uuid: 规则uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSyncRule(String uuid) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.deleteMysqlRules((new StringMap()).put("mysql_uuids", new String[]{uuid}));
            case DB_TYPE_KAFKA:
                return kafkaRule.deleteConsumerRules((new StringMap()).put("uuids", new String[]{uuid}));
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.deleteOracleRules((new StringMap()).put("rule_uuids", new String[]{uuid}));
        }
    }

    /**
     * 同步规则-指定规则类型，批量删除
     *
     * @param srcType: 规则类型
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSyncRules(String srcType, StringMap args) throws I2softException {
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.deleteMysqlRules(args);
            case DB_TYPE_KAFKA:
                return kafkaRule.deleteConsumerRules(args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.deleteOracleRules(args);
        }
    }

    /**
     * 同步规则-指定规则类型的列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRules(String srcType, StringMap args) throws I2softException {
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.listMysqlRules(args);
            case DB_TYPE_KAFKA:
                return kafkaRule.listConsumerRules(args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.listOracleRules(args);
        }
    }

    /**
     * 同步规则 - 非通用操作入口
     * @param uuid 规则uuid
     * @param args  operate : start_analysis 开始日志解析 , stop_analysis 停止日志解析 , reset_analysis 重新日志解析 , stop_and_stopanalysis 停止规则并停止日志解析
     * @return
     * @throws I2softException
     */
    public I2Rs.I2SmpRs operateRule(String uuid, StringMap args) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
            case DB_TYPE_KAFKA:
                return null;
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.operateRule(uuid, args);
        }
    }

    /**
     * 同步规则 - 操作, 停止
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopSyncRule(String uuid, StringMap args) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                mysqlRule.stopMysqlRule(uuid, args);
            case DB_TYPE_KAFKA:
                kafkaRule.stopConsumerRule(uuid, args);
                return null;
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.stopOracleRule(uuid, args);
        }
    }

    /**
     * 同步规则 - 操作， 继续
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeOracleRule(String uuid, StringMap args) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.resumeMysqlRule(uuid, args);
            case DB_TYPE_KAFKA:
                return kafkaRule.resumeConsumerRule(uuid, args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.resumeOracleRule(uuid, args);
        }
    }

    /**
     * 同步规则 - 操作， 重启
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartOracleRule(String uuid, StringMap args) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.restartMysqlRule(uuid, args);
            case DB_TYPE_KAFKA:
                return null;
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.restartOracleRule(uuid, args);
        }
    }

    /**
     * 同步规则-单个规则状态
     *
     * @param uuid: 规则uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRuleStatus(String uuid) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        StringMap uuids = (new StringMap()).put("uuids", new String[]{uuid});
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.listMysqlStatus(uuids);
            case DB_TYPE_KAFKA:
                return kafkaRule.listConsumerStatus(uuids);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.listOracleRuleStatus(uuids);
        }
    }

    /**
     * 同步规则-指定规则类型，批量获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRulesStatus(String srcType, StringMap args) throws I2softException {
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.listMysqlStatus(args);
            case DB_TYPE_KAFKA:
                return kafkaRule.listConsumerStatus(args);
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.listOracleRuleStatus(args);
        }
    }

    /**
     * 同步规则-日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleLog(String uuid, StringMap args) throws I2softException {
        String srcType = getRuleTypeByUUID(uuid);
        switch (srcType) {
            case DB_TYPE_MYSQL:
                return mysqlRule.listMysqlLog(args);
            case DB_TYPE_KAFKA:
                return null;
            case DB_TYPE_ORACLE:
            default:
                return oracleRule.listRuleLog(args);
        }
    }

    /**
     * 同步规则-已同步的对象
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesHasSync(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/sync_obj", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-失败的对象
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesFailObj(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/fail_obj", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-装载信息流量图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesLoadInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/load_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-增量失败dml
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleIncreDml(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/incre_dml", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-已同步表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleSyncTable(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/sync_table", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-获取数据库表字段
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleZStructure(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/z_structure", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-流量图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesMrtg(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/mrtg", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-装载延迟统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleLoadDelayReport(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/load_delay_report", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-增量失败ddl
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesIncreDdl(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/incre_ddl", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-数据库预检
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleDbCheck(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/db_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-获取残留规则
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleGetFalseRule() throws I2softException {
        String url = String.format("%s/active/rule/get_false_rule", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则-选择用户
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleSelectUser(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/select_user", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-表修复
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeRuleTableFix(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/table_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则-获取scn号
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleGetScn(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/get_scn", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-装载统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleLoadReport(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/load_report", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjCmp(String uuid) throws I2softException {
        String url = String.format("%s/active/obj_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 对象比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/active/obj_cmp/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 对象比较-比较结果时间列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取对象比较状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象比较-比较结果详细信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpCmpInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_cmp/cmp_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjFix(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/active/obj_fix/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 对象修复 - 修复结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjFixResult(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 对象修复--获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjFixStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/obj_fix/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态接口
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/active/tb_cmp/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 表比较 - 历史结果（查看表比较时间结果集）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeTbCmpResuluTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-错误信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpErrorMsg(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/error_msg", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-比较结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/active/tb_cmp/cmp_result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-获取网卡列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeoveNetworkCard(StringMap args) throws I2softException {
        String url = String.format("%s/active/bk_takeover/bk_network_card", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/active/bk_takeover", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管-查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeover(String uuid) throws I2softException {
        String url = String.format("%s/active/bk_takeover/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备机接管-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/active/bk_takeover", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-接管结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeoverResult(StringMap args) throws I2softException {
        String url = String.format("%s/active/bk_takeover/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/active/bk_takeover/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 备端接管-获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeoverStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/bk_takeover/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备端接管列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBkTakeover() throws I2softException {
        String url = String.format("%s/active/bk_takeover", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 反向规则-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 反向规则-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 反向规则-获取单个规则信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse/rule_single", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 反向规则-获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 反向规则-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listReverseStatus(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 反向规则-停止
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse/stop", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 反向规则-重启反向任务
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse/restart", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 反向规则-查看
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSingleReverse(StringMap args) throws I2softException {
        String url = String.format("%s/active/reverse", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 日志下载
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs downloadLog(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/log_download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 偏移量信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listKafkaOffsetInfo(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/kafka_offset", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}