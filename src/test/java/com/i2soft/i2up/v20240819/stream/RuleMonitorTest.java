package com.i2soft.i2up.v20240819.stream;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stream.v20240819.RuleMonitor;
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
public class RuleMonitorTest {

    private static Auth auth;
    private static RuleMonitor ruleMonitor;

    @BeforeClass
    public static void setUp() {
        if (ruleMonitor != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        ruleMonitor = new RuleMonitor(auth);
    }

    @Test
    public void T6838_listActiveNodeChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6838")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.listActiveNodeChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6843_listActiveNodeResources() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6843")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.listActiveNodeResources(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6860_updateNodeDefaultMonitorPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6860")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = ruleMonitor.updateNodeDefaultMonitorPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6681_getSyncRuleMonitorConf() {
        try {
            Map rs = ruleMonitor.getSyncRuleMonitorConf(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6682_modifySyncRuleMonitorConf() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6682")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = ruleMonitor.modifySyncRuleMonitorConf(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6685_exportSyncRuleMonitorStat() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6685")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = ruleMonitor.exportSyncRuleMonitorStat(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6626_syncRuleExtractStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6626")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.syncRuleExtractStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6674_syncRuleLoadStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6674")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.syncRuleLoadStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6664_syncRuleTableExtractStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6664")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.syncRuleTableExtractStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6675_syncRuleTableLoadStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6675")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleMonitor.syncRuleTableLoadStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}