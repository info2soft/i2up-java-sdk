package com.i2soft.i2up.v20260626.stream;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stream.v20260626.OfflineRule;
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
    public void T7482_listOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7482")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.listOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7483_createActiveOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7483")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.createActiveOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7487_updateActiveOfflineRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7487")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.updateActiveOfflineRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7484_listOfflineRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7484")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.listOfflineRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7524_listOfflineRuleGroupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7524")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.listOfflineRuleGroupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7485_deleteOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7485")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = offlineRule.deleteOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7486_resumeOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.resumeOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7486_stopOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.stopOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7486_restartOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.restartOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7486_stopScheduleOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.stopScheduleOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7486_resumeScheduleOfflineRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.resumeScheduleOfflineRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7488_getOfflineRuleCharset() {
        try {
            Map rs = offlineRule.getOfflineRuleCharset(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7494_describeOfflineRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.describeOfflineRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7490_describeOfflineRuleGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.describeOfflineRuleGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7495_modifyOfflineRuleGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = offlineRule.modifyOfflineRuleGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7496_switchOfflineRuleMaintenance() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7496")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = offlineRule.switchOfflineRuleMaintenance(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}