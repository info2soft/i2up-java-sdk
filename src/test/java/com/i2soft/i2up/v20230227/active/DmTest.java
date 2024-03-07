package com.i2soft.i2up.v20230227.active;

import com.i2soft.active.v20230227.Dm;
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DmTest {

    private static Auth auth;
    private static Dm dm;

    @BeforeClass
    public static void setUp() {
        if (dm != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dm = new Dm(auth);
    }

    @Test
    public void T2722_listDmRule() {
        try {
            Map rs = dm.listDmRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2723_createDmRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2723")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dm.createDmRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2724_modifyDmRule() {
        try {
            I2Rs.I2SmpRs rs = dm.modifyDmRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2725_describeDmRule() {
        try {
            Integer id = 1;
            Map rs = dm.describeDmRule(id); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2726_deleteDmRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2726")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dm.deleteDmRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2727_resumeDmRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2727")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dm.resumeDmRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2728_listDmRuleLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2728")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dm.listDmRuleLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}