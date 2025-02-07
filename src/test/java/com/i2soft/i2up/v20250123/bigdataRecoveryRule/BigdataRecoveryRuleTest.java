package com.i2soft.i2up.v20250123.bigdataRecoveryRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.bigdataRecoveryRule.v20250123.BigdataRecoveryRule;
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
public class BigdataRecoveryRuleTest {

    private static Auth auth;
    private static BigdataRecoveryRule bigdataRecoveryRule;

    @BeforeClass
    public static void setUp() {
        if (bigdataRecoveryRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        bigdataRecoveryRule = new BigdataRecoveryRule(auth);
    }

    @Test
    public void T7295_listBigdataRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataRecoveryRule.listBigdataRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7296_createBigdataRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7296")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataRecoveryRule.createBigdataRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7297_modifyBigdataRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7297")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataRecoveryRule.modifyBigdataRecoveryRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7298_describeBigdataRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = bigdataRecoveryRule.describeBigdataRecoveryRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7299_listBigdataRecoveryRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7299")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataRecoveryRule.listBigdataRecoveryRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}