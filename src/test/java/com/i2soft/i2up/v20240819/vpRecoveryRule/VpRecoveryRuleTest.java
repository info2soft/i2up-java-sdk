package com.i2soft.i2up.v20240819.vpRecoveryRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vpRecoveryRule.v20240819.VpRecoveryRule;
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
public class VpRecoveryRuleTest {

    private static Auth auth;
    private static VpRecoveryRule vpRecoveryRule;

    @BeforeClass
    public static void setUp() {
        if (vpRecoveryRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        vpRecoveryRule = new VpRecoveryRule(auth);
    }

    @Test
    public void T6858_createVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6858")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpRecoveryRule.createVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6913_modifyVpRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6913")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = vpRecoveryRule.modifyVpRecoveryRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6915_listVpRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6915")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpRecoveryRule.listVpRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6916_describeVpRecoveryRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = vpRecoveryRule.describeVpRecoveryRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6914_deleteVpRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6914")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpRecoveryRule.deleteVpRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6917_operateVpRecoveryRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpRecoveryRule.operateVpRecoveryRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6918_listVpRecoveryRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6918")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpRecoveryRule.listVpRecoveryRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}