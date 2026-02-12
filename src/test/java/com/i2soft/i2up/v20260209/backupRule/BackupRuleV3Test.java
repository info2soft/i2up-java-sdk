package com.i2soft.i2up.v20260209.backupRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.backupRule.v20260209.BackupRuleV3;
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
public class BackupRuleV3Test {

    private static Auth auth;
    private static BackupRuleV3 backupRuleV3;

    @BeforeClass
    public static void setUp() {
        if (backupRuleV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backupRuleV3 = new BackupRuleV3(auth);
    }

    @Test
    public void T5512_createBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5512")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.createBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5530_modifyBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5530")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupRuleV3.modifyBackupRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9825_batchModifyBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9825")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.batchModifyBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5600_describeBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backupRuleV3.describeBackupRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5531_listBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5531")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5532_deleteBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5532")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.deleteBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_enableBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.enableBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_disableBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.disableBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_manualStartBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.manualStartBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_cloneBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.cloneBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_stopBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.stopBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5533_rebootBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.rebootBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5534_listBackupRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5534")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listBackupRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7671_cleanNbuCache() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7671")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupRuleV3.cleanNbuCache(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7686_describeScriptPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7686")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.describeScriptPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8749_describeBackupScript() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8749")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.describeBackupScript(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8750_modifyBackupScript() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8750")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupRuleV3.modifyBackupScript(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9385_listOracleDatabases() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9385")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listOracleDatabases(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9384_listOracleObjects() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9384")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listOracleObjects(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8757_listDorisDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8757")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listDorisDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9403_checkPolardbXEncrypt() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9403")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.checkPolardbXEncrypt(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9517_describeExchangeInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9517")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.describeExchangeInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9535_listElasticsearchIndics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9535")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listElasticsearchIndics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9761_listMongoDBDatabases() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9761")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listMongoDBDatabases(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9762_listMongoDBTables() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9762")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupRuleV3.listMongoDBTables(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}