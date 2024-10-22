package com.i2soft.i2up.v20240819.fspRecoveryRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.fspRecoveryRule.v20240819.FspRecoveryRule;
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
public class FspRecoveryRuleTest {

    private static Auth auth;
    private static FspRecoveryRule fspRecoveryRule;

    @BeforeClass
    public static void setUp() {
        if (fspRecoveryRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        fspRecoveryRule = new FspRecoveryRule(auth);
    }

    @Test
    public void T6946_listFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6946")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.listFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6947_createFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6947")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecoveryRule.createFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6948_listFspRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = fspRecoveryRule.listFspRecoveryRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6950_deleteFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6950")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.deleteFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6949_modifyFspRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6949")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecoveryRule.modifyFspRecoveryRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6951_startFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6951")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.startFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6951_stopFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6951")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.stopFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6951_rebootFspRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6951")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.rebootFspRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6952_listFspRecoveryRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6952")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.listFspRecoveryRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7176_getFspRecoveryRuleBiosType() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7176")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspRecoveryRule.getFspRecoveryRuleBiosType(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7177_listFspRecoveryRuleDriverListUrl() {
        try {
            Map rs = fspRecoveryRule.listFspRecoveryRuleDriverListUrl(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}