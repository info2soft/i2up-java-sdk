package com.i2soft.stream.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class SyncRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public SyncRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createSyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resumeOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map restartOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startAnalysisOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopAnalysisOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map resetAnalysisOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopAndStopanalysisOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map duplicateOracleRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRules(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRulesStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 批量新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createBatchSyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/batch", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 批量修改
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchModifySyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/batch", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 装载信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesLoadInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/load_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 流量图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesMrtg(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/mrtg", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRules(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleSyncTable(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/sync_table", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 分片信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRulesSliceStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/slice_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步的对象
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesHasSync(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/sync_obj", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRuleLog(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步的对象具体信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesObjInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/sync_obj_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 修改维护模式
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchSyncRuleMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 选择表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleZStructure(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/z_structure", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 同步失败的对象
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesFailObj(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/fail_obj", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量失败DDL
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesIncreDdl(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_ddl", auth.cc_url);
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
    public I2Rs.I2SmpRs ruleTableFix(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/table_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 增量失败DML
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleIncreDml(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-获取scn号
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map ruleGetScn(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule//get_scn", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步的对象具体信息(DML解析)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeExtractSyncRulesObjInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/extract_sync_obj_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 从底层获取SCN
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map ruleGetRpcScn(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/get_rpc_scn", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步的对象具体信息(DML装载)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLoadSyncRulesObjInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/load_sync_obj_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 从底层获取接管SCN
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map ruleGetReverseScn(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/get_revert_rpc_scn", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量失败DML统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesDML(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml_summary", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-偏移量信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listKafkaOffsetInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/kafka_offset", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量失败统计删除（失败对象）副本
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteSyncRulesDML(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml_summary", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 全量状态统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getRuleFullSyncStat(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/full_sync_stat", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 装载统计统计表修复获取待修复表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map increDmlFixAll(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/table_fix_all", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 环境检查
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map syncRulePrecheck(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/pre_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - DB2获取源端时区
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getDbTimezone(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/timezone", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 数据库预检
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleDbCheck(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/db_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 导入
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] importSyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/import", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 同步规则 - 导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportSyncRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 同步规则 - 获取LSN
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getStreamRuleLsn(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/lsn", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据集成 - 总览
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map statusStreamOverall() throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/stream_overall", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量失败DDL清除所有信息副本
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteIncreDML(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则-选择用户
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleSelectUser(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/select_user", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 总览 - 数据库同步任务
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryView(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/list_view", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量表DML抽取统计副本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listIncreDmlExtract(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml_extract", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量表DML装载统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listIncreDmlLoad(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_dml_load", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 数据安全总览 - 数据库同步任务
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryMaskView(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/mask/rule/list_view", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 装载热点图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLoadHeatMap(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/load_heat_map", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 已同步表出错表内容导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportSyncRuleFailTable(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/fail_table_export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 同步规则 - 增量失败DDL导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportSyncRuleDdlError(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/ddl_error_export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 同步规则 - 全量状态统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRuleFullSyncSummary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/full_sync_summary", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 增量状态统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSyncRuleIncreSyncSummary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/incre_sync_summary", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 获取全局配置项
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getStreamGlobalSettings(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/global_settings", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 新增全局配置项
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map addStreamGlobalSettings(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/global_settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则 - 删除全局配置项
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteStreamGlobalSettings(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sync_rule/global_settings", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}