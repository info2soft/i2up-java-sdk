package com.i2soft.i2up.v20240819.active;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.active.v20240819.OfflineRule;
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
public class OfflineRuleTest {

    private static Auth auth;
    private static OfflineRule offlineRule;

    @BeforeClass
    public static void setUp() {
        if (offlineRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        offlineRule = new OfflineRule(auth);
    }

    @Test
    public void T4290_listOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4290")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.listOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4291_createActiveOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4291")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.createActiveOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5423_updateActiveOfflineRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5423")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.updateActiveOfflineRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4293_listOfflineRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4293")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.listOfflineRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4294_deleteOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4294")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.deleteOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4295_resumeOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.resumeOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4295_stopOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.stopOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4295_restartOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.restartOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4295_stopScheduleOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.stopScheduleOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4295_resumeScheduleOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4295")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.resumeScheduleOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4296_getOfflineRuleCharset() {
        try {
            Map rs = offlineRule.getOfflineRuleCharset(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7185_describeOfflineRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.describeOfflineRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5424_getOfflineRuleGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.getOfflineRuleGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7187_updateOfflineRuleGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.updateOfflineRuleGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7188_switchOfflineRuleMaintenance() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7188")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.switchOfflineRuleMaintenance(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}