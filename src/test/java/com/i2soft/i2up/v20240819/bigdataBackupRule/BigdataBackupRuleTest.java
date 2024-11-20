package com.i2soft.i2up.v20240819.bigdataBackupRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.bigdataBackupRule.v20240819.BigdataBackupRule;
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
public class BigdataBackupRuleTest {

    private static Auth auth;
    private static BigdataBackupRule bigdataBackupRule;

    @BeforeClass
    public static void setUp() {
        if (bigdataBackupRule != null) {
            return;
        }
        try {
            auth = Auth.ak(TestConfig.addr, TestConfig.ak, TestConfig.sk, TestConfig.cachePath);
        } catch (I2softException e) {
            e.printStackTrace();
        }
        bigdataBackupRule = new BigdataBackupRule(auth);
    }

    @Test
    public void T7289_listBigdataBackupRule() {
        try {
            Map rs = bigdataBackupRule.listBigdataBackupRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7290_createBigdataBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7290")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataBackupRule.createBigdataBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7291_modifyBigdataBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            byte[] rs = bigdataBackupRule.modifyBigdataBackupRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7292_describeBigdataBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            byte[] rs = bigdataBackupRule.describeBigdataBackupRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7293_listBigdataBackupRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7293")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataBackupRule.listBigdataBackupRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7294_manualStartBigdataBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7294")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataBackupRule.manualStartBigdataBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7294_disableBigdataBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7294")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataBackupRule.disableBigdataBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7294_enableBigdataBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7294")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataBackupRule.enableBigdataBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7458_listBigdataBackupRuleBakHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7458")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataBackupRule.listBigdataBackupRuleBakHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7459_listBigdataBackupRuleHiveTableInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7459")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataBackupRule.listBigdataBackupRuleHiveTableInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7460_listBigdataBackupRuleHivePartitionInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7460")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataBackupRule.listBigdataBackupRuleHivePartitionInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}