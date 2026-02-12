package com.i2soft.i2up.v20260209.backupSet;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.backupSet.v20260209.BackupSetV3;
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
public class BackupSetV3Test {

    private static Auth auth;
    private static BackupSetV3 backupSetV3;

    @BeforeClass
    public static void setUp() {
        if (backupSetV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backupSetV3 = new BackupSetV3(auth);
    }

    @Test
    public void T9565_listBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9565")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9583_listRuleBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9583")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listRuleBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9585_listBackupSetChain() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9585")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listBackupSetChain(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9570_listQueryArgsBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9570")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listQueryArgsBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_extendBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.extendBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_expireBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.expireBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_setPrimaryBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.setPrimaryBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_mountBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.mountBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_unmountBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.unmountBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9567_verifyBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.verifyBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9573_deleteDbBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9573")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.deleteDbBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9577_manualForceDeleteDbBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9577")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.manualForceDeleteDbBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9584_manualForceCleanDbBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9584")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.manualForceCleanDbBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9568_createBackupSetRepRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9568")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.createBackupSetRepRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9566_describeBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9566")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.describeBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9575_describeDeletedBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9575")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetV3.describeDeletedBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9569_describeBackupSetCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9569")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.describeBackupSetCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9564_listBackupSetRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9564")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listBackupSetRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9571_validateBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9571")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetV3.validateBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9574_resetPrimaryBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9574")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.resetPrimaryBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9580_listBackupChain() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9580")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetV3.listBackupChain(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9576_drillBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9576")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetV3.drillBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9579_listSrcClient() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9579")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.listSrcClient(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9578_validationBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9578")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetV3.validationBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9581_getValidationResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9581")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetV3.getValidationResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}