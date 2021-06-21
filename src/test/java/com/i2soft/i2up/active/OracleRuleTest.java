package com.i2soft.i2up.active;

import com.i2soft.active.OracleRule;
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OracleRuleTest {

    private static Auth auth;
    private static OracleRule oracleRule;

    @BeforeClass
    public static void setUp() {
        if (oracleRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        oracleRule = new OracleRule(auth);
    }

    @Test
    public void T1351_describeOracleRuleDML() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleDML(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1349_describeOracleRuleObjInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1349")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleObjInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1249_describeOracleRuleProxyStatus() {
        try {
            Map rs = oracleRule.describeOracleRuleProxyStatus(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1248_createOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1248")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2CreateRs rs = oracleRule.createOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2068_modifyOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2068")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.modifyOracleRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1416_listRuleLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listRuleLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1348_describeOracleRuleHasSync() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1348")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleHasSync(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1350_describeOracleRuleFailObj() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1350")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleFailObj(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1347_describeOracleRuleLoadInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1347")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleLoadInfo(args); // 发送请求
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
            Map rs = oracleRule.listRuleIncreDml(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1254_deleteOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1254")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.deleteOracleRules(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1251_listOracleRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1251")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listOracleRules(args); // 发送请求
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
            Map rs = oracleRule.listRuleSyncTable(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1291_operateRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1291")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.operateRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1296_listOracleRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1296")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listOracleRuleStatus(args); // 发送请求
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
            Map rs = oracleRule.describeRuleZStructure(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1346_describeOracleRuleMrtg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1346")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleMrtg(args); // 发送请求
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
            Map rs = oracleRule.listRuleLoadDelayReport(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1375_describeOracleRuleIncreDdl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1375")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRuleIncreDdl(args); // 发送请求
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
            Map rs = oracleRule.describeRuleDbCheck(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1433_describeRuleGetFalseRule() {
        try {
            Map rs = oracleRule.describeRuleGetFalseRule(); // 发送请求
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
            Map rs = oracleRule.describeRuleSelectUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1252_describeOracleRule() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1252")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeOracleRule(uuid); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.describeRuleTableFix(args); // 发送请求
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
            Map rs = oracleRule.describeRuleGetScn(args); // 发送请求
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
            Map rs = oracleRule.listRuleLoadReport(args); // 发送请求
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
            Map rs = oracleRule.listObjCmp(args); // 发送请求
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
            Map rs = oracleRule.createObjCmp(args); // 发送请求
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
            Map rs = oracleRule.deleteObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1276_describeObjCmp() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = oracleRule.describeObjCmp(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1290_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1290")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1335_listObjCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1335")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listObjCmpResultTimeList(args); // 发送请求
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
            Map rs = oracleRule.describeObjCmpResult(args); // 发送请求
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
            Map rs = oracleRule.listObjCmpStatus(args); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.describeObjCmpResultTimeList(args); // 发送请求
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
            Map rs = oracleRule.listObjCmpCmpInfo(args); // 发送请求
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
            Map rs = oracleRule.createObjFix(args); // 发送请求
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
            Map rs = oracleRule.describeObjFix(uuid, args); // 发送请求
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
            Map rs = oracleRule.deleteObjFix(args); // 发送请求
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
            Map rs = oracleRule.listObjFix(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1294_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1294")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1283_describeObjFixResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1283")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.describeObjFixResult(args); // 发送请求
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
            Map rs = oracleRule.listObjFixStatus(args); // 发送请求
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
            Map rs = oracleRule.createTbCmp(args); // 发送请求
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
            Map rs = oracleRule.describeTbCmp(uuid, args); // 发送请求
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
            Map rs = oracleRule.deleteTbCmp(args); // 发送请求
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
            Map rs = oracleRule.listTbCmp(args); // 发送请求
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
            Map rs = oracleRule.listTbCmpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1298_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1298")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1289_listTbCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1289")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listTbCmpResultTimeList(args); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.describeTbCmpResuluTimeList(args); // 发送请求
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
            Map rs = oracleRule.describeTbCmpResult(args); // 发送请求
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
            Map rs = oracleRule.describeTbCmpErrorMsg(args); // 发送请求
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
            Map rs = oracleRule.describeTbCmpCmpResult(args); // 发送请求
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
            Map rs = oracleRule.listBkTakeoveNetworkCard(args); // 发送请求
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
            Map rs = oracleRule.createBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1307_describeBkTakeover() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = oracleRule.describeBkTakeover(uuid); // 发送请求
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
            Map rs = oracleRule.deleteBkTakeover(args); // 发送请求
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
            Map rs = oracleRule.describeBkTakeoverResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1311_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1311")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = oracleRule.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1391_listBkTakeoverStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1391")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleRule.listBkTakeoverStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1389_listBkTakeover() {
        try {
            Map rs = oracleRule.listBkTakeover(); // 发送请求
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
            Map rs = oracleRule.createReverse(args); // 发送请求
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
            Map rs = oracleRule.deleteReverse(args); // 发送请求
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
            Map rs = oracleRule.describeReverse(args); // 发送请求
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
            Map rs = oracleRule.listReverse(args); // 发送请求
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
            Map rs = oracleRule.listReverseStatus(args); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.stopReverse(args); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.restartReverse(args); // 发送请求
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
            Map rs = oracleRule.describeSingleReverse(args); // 发送请求
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
            I2Rs.I2SmpRs rs = oracleRule.downloadLog(args); // 发送请求
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
            Map rs = oracleRule.listKafkaOffsetInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}