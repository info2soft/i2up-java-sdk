package com.i2soft.i2up.v20190805.active;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.active.SyncRules;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SyncRulesTest {

    private static Auth auth;
    private static SyncRules syncRules;

    @BeforeClass
    public static void setUp() {
        if (syncRules != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        syncRules = new SyncRules(auth);
    }

    @Test
    public void T1351_describeSyncRulesDML() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesDML(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1349_describeSyncRulesObjInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1349")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesObjInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1249_describeSyncRulesProxyStatus() {
        try {
            Map rs = syncRules.describeSyncRulesProxyStatus(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    // 同步规则:1248 mysql:1468 kfk:1598
    public void T1248_createSyncRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1598")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2CreateRs rs = syncRules.createSyncRule("kafka", r.bodyString()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2068_modifySyncRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2069")); // 获取请求数据 kafka:2069 mysql: 1553 oracle:2068
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            System.out.println(args.get("rule_uuid"));
//            System.out.println(r.bodyString());


            //region 参数字符串
            String paramsString = "{\"rule_uuid\":\"3E14A9BF-0A7F-CEE4-66D7-7AC96B2C489C\",\"src_db_uuid\":\"B8A129C4-EA11-415A-A816-1E882A626269\",\"tgt_db_uuid\":\"FA4A7EF2-B944-6B0C-5B20-FD9C3680A9D5\",\"rule_type\":0,\"rule_name\":\"test2\",\"user_uuid\":\"1BCFCAA3-E3C8-3E28-BDC5-BE36FDC2B5DC\",\"node_uuid\":\"\",\"tgt_type\":\"kafka\",\"db_user_map\":\"{\\\"TEST2\\\":\\\"test2\\\"}\",\"row_map_mode\":\"rowid\",\"map_type\":\"user\",\"table_map\":\"\",\"dbmap_topic\":\"\",\"sync_mode\":1,\"start_scn\":0,\"storage_settings\":{\"tgt_extern_table\":\"\",\"src_max_mem\":\"512\",\"src_max_disk\":\"5000\",\"txn_max_mem\":\"10000\",\"tf_max_size\":\"100\",\"max_ld_mem\":\"512\"},\"table_space_map\":{\"tgt_table_space\":\"\",\"table_mapping_way\":\"ptop\",\"table_path_map\":{},\"table_space_name\":{}},\"other_settings\":{\"dly_constraint_load\":0,\"keep_usr_pwd\":0,\"ignore_foreign_key\":0,\"keep_dyn_data\":0,\"dyn_thread\":1,\"ddl_cv\":0,\"keep_bad_act\":0,\"fill_lob_column\":0,\"keep_seq_sync\":0,\"convert_urp_of_key\":0,\"gen_txn\":0,\"zip_level\":0},\"error_handling\":{\"irp\":\"irpafterdel\",\"urp\":\"toirp\",\"drp\":\"ignore\",\"load_err_set\":\"continue\",\"report_failed_dml\":0},\"bw_settings\":{\"bw_limit\":\"\"},\"strate\":null,\"full_sync_settings\":{\"load_mode\":\"direct\",\"ld_dir_opt\":0,\"dump_thd\":1,\"load_thd\":1,\"try_split_part_table\":1,\"clean_user_before_dump\":0,\"existing_table\":\"drop_to_recycle\",\"concurrent_table\":\"[]\",\"sync_mode\":1,\"start_scn\":0},\"full_sync_obj_filter\":{\"full_sync_obj_data\":[\"INDEX\",\"VIEW\",\"FUNCTION\",\"PROCEDURE\",\"PACKAGE\",\"PACKAGE BODY\",\"SYNONYM\",\"TRIGGER\",\"SEQUENCE\",\"JAVA CLASS\",\"TYPE\",\"TYPE BODY\",\"MATERIALIZED VIEW\",\"DATABASE LINK\",\"OLD JOB\",\"JOB\",\"PRIVS\",\"CONSTRAINT\",\"JAVA RESOURCE\",\"JAVA SOURCE\"]},\"inc_sync_ddl_filter\":{\"inc_sync_ddl_data\":[\"CREATE TABLE\",\"DROP TABLE\",\"ALTER TABLE\",\"TABLE ADD\",\"TABLE DROP\",\"TABLE MODIFY\",\"TABLE RENAME\",\"TRUNCATE TABLE\",\"MOVE TABLE\",\"CREATE COMMENT\",\"ADD PARTITION\",\"DROP PARTITION\",\"ADD SUBPARTITION\",\"DROP SUBPARTITION\",\"SPLIT PARTITION\",\"SPLIT SUBPARTITION\",\"MERGE SUBPARTITION\",\"MERGE PARTITION\",\"SWAP\",\"ALTER LVAL\",\"SET TEMPLATE\",\"CREATE INDEX\",\"DROP INDEX\",\"ALTER INDEX\",\"RENAME INDEX\",\"CREATE TYPE\",\"DROP TYPE\",\"CREATE VIEW\",\"DROP VIEW\",\"CREATE SYN\",\"DROP SYN\",\"ADD CONSTRAINT\",\"DROP CONSTRAINT\",\"ALTER CONSTRAINT\",\"CREATE SEQUENCE\",\"DROP SEQUENCE\",\"ALTER SEQUENCE\",\"CREATE ROLE\",\"DROP ROLE\",\"ALTER ROLE\",\"GRANT SYS\",\"GRANT OBJ\",\"REVOKE SYS\",\"REVOKE OBJ\",\"CREATE MVIEW LOG\",\"DROP MVIEW LOG\",\"CREATE MVIEW\",\"DROP MVIEW\",\"CREATE JAVA\",\"DROP JAVA\",\"CREATE CLASS\",\"DROP CLASS\",\"CREATE RESOURCE\",\"DROP RESOURCE\",\"CREATE PROFILE\",\"DROP PROFILE\",\"ALTER PROFILE\",\"CREATE PROC\",\"DROP PROC\",\"ALTER PROC\",\"CREATE DROP DBLINK\",\"CREATE QUEUE\",\"DROP QUEUE\",\"ALTER QUEUE\",\"CREATE TABLESPACE\",\"DROP TABLESPACE\",\"ALTER TABLESPACE\",\"RENAME TABLESPACE\",\"ADD HASH PARTITION\",\"SWAPS\",\"ADD CONSTRAINTS\"]},\"filter_table_settings\":{\"exclude_table\":\"[]\"},\"etl_settings\":{\"etl_table\":[]},\"create_time\":1626849310,\"start_rule_now\":1,\"kafka_time_out\":\"2400000\",\"part_load_balance\":\"by_table\",\"kafka_message_encoding\":\"UTF-8\",\"db_map_uuid\":\"\",\"dml_track\":{\"enable\":0,\"urp\":0,\"drp\":0,\"tmcol\":\"\",\"delcol\":\"\"},\"kafka\":{\"binary_code\":\"hex\"},\"kafkaTimeout\":\"12000\",\"partLoadBalance\":\"by_key\",\"registered\":1,\"active_flag\":\"modify\",\"_\":\"44353ff251021\"}";

            I2Rs.I2SmpRs rs = syncRules.modifySyncRule("3E14A9BF-0A7F-CEE4-66D7-7AC96B2C489C", paramsString); // 发送请求

            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1416_listRuleLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1416")); // 获取请求数据 oracle:1416 mysql:1533
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listRuleLog("rule_uuid", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1348_describeSyncRulesHasSync() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1348")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesHasSync(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1350_describeSyncRulesFailObj() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1350")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesFailObj(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1347_describeSyncRulesLoadInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1347")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesLoadInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1432_listRuleIncreDml() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1432")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listRuleIncreDml(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1254_deleteSyncRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1599")); // 获取请求数据 oracle:1254 mysql:1470 kafka:1599
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteSyncRule((String) args.get("rule_uuids")); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1251_listSyncRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1602")); // 获取请求数据  oracle:1251 mysql:1472 kafka:1602
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listSyncRules("oracle", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1431_listRuleSyncTable() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1431")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listRuleSyncTable(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1291_operateRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1291")); // 获取请求数据 oracle:1291 mysql:1471 kafka:1601
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.operateRule((String)args.get("uuid"), args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1291_stopSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1291")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.stopSyncRule("CADE1309-6751-CA40-B93B-D58C8580E069", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1291_resumeSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1291")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.resumeSyncRule("CADE1309-6751-CA40-B93B-D58C8580E069", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1291_restartSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1291")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.restartSyncRule("uuid", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1296_listSyncRulesStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1296")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listSyncRulesStatus("kafka", args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2876_listSyncRulesGeneralStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1296")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listSyncRulesGeneralStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1405_describeRuleZStructure() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1405")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeRuleZStructure(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1346_describeSyncRulesMrtg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1346")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesMrtg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1760_listRuleLoadDelayReport() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1760")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listRuleLoadDelayReport(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1375_describeSyncRulesIncreDdl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1375")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRulesIncreDdl(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1761_describeRuleDbCheck() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1761")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeRuleDbCheck(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1433_describeRuleGetFalseRule() {
        try {
            Map rs = syncRules.describeRuleGetFalseRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1392_describeRuleSelectUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1392")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeRuleSelectUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1252_describeSyncRules() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1252")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSyncRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1420_describeRuleTableFix() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1420")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.describeRuleTableFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1512_describeRuleGetScn() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1512")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeRuleGetScn(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1755_listRuleLoadReport() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1755")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listRuleLoadReport(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1255_listObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1255")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1256_createObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1256")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.createObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1257_deleteObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1257")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1276_describeObjCmp() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = syncRules.describeObjCmp(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T1290_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1290")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = syncRules.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void T1335_listObjCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1335")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1336_describeObjCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1336")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeObjCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1341_listObjCmpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1341")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjCmpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1337_describeObjCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1337")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.describeObjCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1338_listObjCmpCmpInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1338")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjCmpCmpInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1278_createObjFix() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1278")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.createObjFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1279_describeObjFix() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1279")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeObjFix(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1281_deleteObjFix() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1281")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteObjFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1282_listObjFix() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1282")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T1294_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1294")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = syncRules.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void T1283_describeObjFixResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1283")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeObjFixResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1372_listObjFixStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1372")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listObjFixStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1285_createTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1285")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.createTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1286_describeTbCmp() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1286")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeTbCmp(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1287_deleteTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1287")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1288_listTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1288")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1297_listTbCmpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1297")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listTbCmpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T1298_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1298")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = syncRules.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void T1289_listTbCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1289")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listTbCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1300_describeTbCmpResuluTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1300")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.describeTbCmpResuluTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1301_describeTbCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1301")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeTbCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1302_describeTbCmpErrorMsg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1302")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeTbCmpErrorMsg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1669_describeTbCmpCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1669")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeTbCmpCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1305_listBkTakeoveNetworkCard() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1305")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listBkTakeoveNetworkCard(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1306_createBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1306")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.createBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1307_describeBkTakeover() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = syncRules.describeBkTakeover(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1308_deleteBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1308")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1310_describeBkTakeoverResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1310")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeBkTakeoverResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T1311_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1311")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = syncRules.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void T1391_listBkTakeoverStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1391")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listBkTakeoverStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1389_listBkTakeover() {
        try {
            Map rs = syncRules.listBkTakeover(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1313_createReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1313")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.createReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1314_deleteReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1314")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.deleteReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1328_describeReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1328")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1329_listReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1329")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1330_listReverseStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1330")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listReverseStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1331_stopReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1331")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.stopReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1333_restartReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1333")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.restartReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1332_describeSingleReverse() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1332")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.describeSingleReverse(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2075_downloadLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2075")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRules.downloadLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2507_listKafkaOffsetInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2507")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRules.listKafkaOffsetInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}