package com.i2soft.i2up.v20250123.cdm;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.cdm.v20250123.CdmRule;
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
public class CdmRuleTest {

    private static Auth auth;
    private static CdmRule cdmRule;

    @BeforeClass
    public static void setUp() {
        if (cdmRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        cdmRule = new CdmRule(auth);
    }

    @Test
    public void T1826_takeOverDrillList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1826")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.takeOverDrillList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1827_createTakeOverDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1827")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.createTakeOverDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1843_deleteTakeOverDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1843")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.deleteTakeOverDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1828_describeTakeOverDrill() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = cdmRule.describeTakeOverDrill(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1854_getVmStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1854")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.getVmStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1846_startTakeOverDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1846")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.startTakeOverDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1846_stopTakeOverDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1846")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.stopTakeOverDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1846_openConsoleTakeOverDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1846")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cdmRule.openConsoleTakeOverDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}