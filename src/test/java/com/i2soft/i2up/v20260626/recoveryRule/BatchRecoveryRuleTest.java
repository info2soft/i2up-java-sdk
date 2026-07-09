package com.i2soft.i2up.v20260626.recoveryRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.recoveryRule.v20260626.BatchRecoveryRule;
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
public class BatchRecoveryRuleTest {

    private static Auth auth;
    private static BatchRecoveryRule batchRecoveryRule;

    @BeforeClass
    public static void setUp() {
        if (batchRecoveryRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        batchRecoveryRule = new BatchRecoveryRule(auth);
    }

    @Test
    public void T8419_listRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8419")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.listRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8422_listRestoreWizardRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8422")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.listRestoreWizardRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8413_createRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8413")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = batchRecoveryRule.createRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8418_modifyRestoreWizardRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8418")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = batchRecoveryRule.modifyRestoreWizardRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8414_regenerateRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.regenerateRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8414_restoreRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.restoreRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8414_startRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.startRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8414_stopRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.stopRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8420_deleteRestoreWizardRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8420")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = batchRecoveryRule.deleteRestoreWizardRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8415_downloadRestoreWizardList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8415")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = batchRecoveryRule.downloadRestoreWizardList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8416_describeRestoreWizardRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = batchRecoveryRule.describeRestoreWizardRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}