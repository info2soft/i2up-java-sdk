package com.i2soft.i2up.v20260626.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20260626.StatisticsV3;
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
public class StatisticsV3Test {

    private static Auth auth;
    private static StatisticsV3 statisticsV3;

    @BeforeClass
    public static void setUp() {
        if (statisticsV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        statisticsV3 = new StatisticsV3(auth);
    }

    @Test
    public void T9357_listStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9357")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = statisticsV3.listStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9358_describeStatistics() {
        try {
            Integer id = 1;
            Map rs = statisticsV3.describeStatistics(id); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9359_readStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9359")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = statisticsV3.readStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9360_listStatisticsChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9360")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = statisticsV3.listStatisticsChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9361_updateStatisticsConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9361")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = statisticsV3.updateStatisticsConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9362_listStatisticsConfig() {
        try {
            Map rs = statisticsV3.listStatisticsConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9364_downloadStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9364")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = statisticsV3.downloadStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9365_downloadStatisticsChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9365")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = statisticsV3.downloadStatisticsChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9366_listStatisticsRuleChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9366")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("download", 0);
            Map rs = statisticsV3.listStatisticsRuleChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9366_downloadStatisticsRuleChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9366")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("download", 1);
            byte[] rs = statisticsV3.downloadStatisticsRuleChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9367_listStatisticsTrendChart() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9367")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = statisticsV3.listStatisticsTrendChart(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9368_listStatisticsDisplayItems() {
        try {
            Map rs = statisticsV3.listStatisticsDisplayItems(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9369_setStatisticsDisplayItems() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9369")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = statisticsV3.setStatisticsDisplayItems(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9876_listStatisticsBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9876")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = statisticsV3.listStatisticsBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}