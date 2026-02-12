package com.i2soft.i2up.v20260209.stream;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stream.v20260209.SyncRule;
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
public class SyncRuleTest {

    private static Auth auth;
    private static SyncRule syncRule;

    @BeforeClass
    public static void setUp() {
        if (syncRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        syncRule = new SyncRule(auth);
    }

    @Test
    public void T6225_createSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6225")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.createSyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_resumeOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.resumeOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_stopOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.stopOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_restartOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.restartOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_startAnalysisOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.startAnalysisOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_stopAnalysisOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.stopAnalysisOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_resetAnalysisOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.resetAnalysisOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_stopAndStopanalysisOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.stopAndStopanalysisOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5833_duplicateOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5833")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.duplicateOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5795_listSyncRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRules(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5797_listSyncRulesStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5797")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRulesStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6226_createBatchSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6226")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.createBatchSyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6478_batchModifySyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6478")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.batchModifySyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9190_describeSyncRulesLoadInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9190")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesLoadInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5804_deleteSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5804")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.deleteSyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9129_describeSyncRulesMrtg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9129")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesMrtg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5796_describeSyncRules() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5796")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRules(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9131_listRuleSyncTable() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9131")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listRuleSyncTable(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7282_listSyncRulesSliceStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7282")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRulesSliceStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9132_describeSyncRulesHasSync() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9132")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesHasSync(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5808_listSyncRuleLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5808")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRuleLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9133_describeSyncRulesObjInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9133")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesObjInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5803_switchSyncRuleMaintenance() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5803")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRule.switchSyncRuleMaintenance(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8540_describeRuleZStructure() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8540")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeRuleZStructure(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9134_describeSyncRulesFailObj() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9134")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesFailObj(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9135_describeSyncRulesIncreDdl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9135")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesIncreDdl(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5830_ruleTableFix() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5830")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRule.ruleTableFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9136_listRuleIncreDml() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9136")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listRuleIncreDml(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5815_ruleGetScn() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5815")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.ruleGetScn(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9137_describeExtractSyncRulesObjInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9137")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeExtractSyncRulesObjInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5828_ruleGetRpcScn() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5828")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.ruleGetRpcScn(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9138_describeLoadSyncRulesObjInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9138")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeLoadSyncRulesObjInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5836_ruleGetReverseScn() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5836")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.ruleGetReverseScn(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9139_describeSyncRulesDML() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9139")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeSyncRulesDML(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5822_listKafkaOffsetInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5822")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listKafkaOffsetInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9140_deleteSyncRulesDML() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9140")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRule.deleteSyncRulesDML(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7501_getRuleFullSyncStat() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7501")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.getRuleFullSyncStat(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9149_increDmlFixAll() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9149")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.increDmlFixAll(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7672_syncRulePrecheck() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7672")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.syncRulePrecheck(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7674_getDbTimezone() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7674")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.getDbTimezone(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9142_describeRuleDbCheck() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9142")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeRuleDbCheck(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8527_importSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8527")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = syncRule.importSyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8528_exportSyncRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8528")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = syncRule.exportSyncRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8619_getStreamRuleLsn() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8619")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.getStreamRuleLsn(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8842_statusStreamOverall() {
        try {
            Map rs = syncRule.statusStreamOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9143_deleteIncreDML() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9143")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRule.deleteIncreDML(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9144_describeRuleSelectUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9144")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.describeRuleSelectUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8844_listSummaryView() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8844")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSummaryView(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9145_listIncreDmlExtract() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9145")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listIncreDmlExtract(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9146_listIncreDmlLoad() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9146")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listIncreDmlLoad(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8853_listSummaryMaskView() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8853")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSummaryMaskView(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9148_listLoadHeatMap() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9148")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listLoadHeatMap(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9387_exportSyncRuleFailTable() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9387")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = syncRule.exportSyncRuleFailTable(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9388_exportSyncRuleDdlError() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9388")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = syncRule.exportSyncRuleDdlError(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9455_listSyncRuleFullSyncSummary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9455")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRuleFullSyncSummary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9510_listSyncRuleIncreSyncSummary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9510")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.listSyncRuleIncreSyncSummary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9524_getStreamGlobalSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9524")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.getStreamGlobalSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9525_addStreamGlobalSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9525")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = syncRule.addStreamGlobalSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9526_deleteStreamGlobalSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9526")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = syncRule.deleteStreamGlobalSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}