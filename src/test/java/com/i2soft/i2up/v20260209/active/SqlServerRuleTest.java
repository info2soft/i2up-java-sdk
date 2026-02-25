package com.i2soft.i2up.v20260209.active;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.active.v20260209.SqlServerRule;
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
public class SqlServerRuleTest {

    private static Auth auth;
    private static SqlServerRule sqlServerRule;

    @BeforeClass
    public static void setUp() {
        if (sqlServerRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        sqlServerRule = new SqlServerRule(auth);
    }

    @Test
    public void T8479_listBkTakeoveNetworkCard() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8479")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = sqlServerRule.listBkTakeoveNetworkCard(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8478_createBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8478")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = sqlServerRule.createBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8480_describeBkTakeover() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = sqlServerRule.describeBkTakeover(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8481_deleteBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8481")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = sqlServerRule.deleteBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8482_describeBkTakeoverResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8482")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = sqlServerRule.describeBkTakeoverResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8485_stopBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8485")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = sqlServerRule.stopBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8485_restartBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8485")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = sqlServerRule.restartBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8484_listBkTakeoverStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8484")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = sqlServerRule.listBkTakeoverStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8483_listBkTakeover() {
        try {
            Map rs = sqlServerRule.listBkTakeover(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}