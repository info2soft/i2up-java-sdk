package com.i2soft.i2up.v20260626.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20260626.Dashborad;
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
public class DashboradTest {

    private static Auth auth;
    private static Dashborad dashborad;

    @BeforeClass
    public static void setUp() {
        if (dashborad != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dashborad = new Dashborad(auth);
    }

    @Test
    public void T7269_upMonitorOverall() {
        try {
            Map rs = dashborad.upMonitorOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T747_overall() {
        try {
            Map rs = dashborad.overall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2175_sysadmin() {
        try {
            Map rs = dashborad.sysadmin(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2453_statusOverall() {
        try {
            Map rs = dashborad.statusOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6726_getDashboardStatOverall() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6726")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dashborad.getDashboardStatOverall(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2455_listOverallLogs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2455")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dashborad.listOverallLogs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2456_listOverallResourceSta() {
        try {
            Map rs = dashborad.listOverallResourceSta(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2459_listOverallRealTimeCopy() {
        try {
            Map rs = dashborad.listOverallRealTimeCopy(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2460_listOverallHa() {
        try {
            Map rs = dashborad.listOverallHa(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2627_listOverallCdm() {
        try {
            Map rs = dashborad.listOverallCdm(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2628_listOverallFspMv() {
        try {
            Map rs = dashborad.listOverallFspMv(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2701_nodeRepSummary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2701")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dashborad.nodeRepSummary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3121_listVpRuleStat() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3121")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dashborad.listVpRuleStat(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4013_listSchedule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4013")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dashborad.listSchedule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7076_getDashboardHotColdData() {
        try {
            Map rs = dashborad.getDashboardHotColdData(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6725_updateDashboardPlate() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6725")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dashborad.updateDashboardPlate(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6724_getDashboardPlate() {
        try {
            Map rs = dashborad.getDashboardPlate(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}