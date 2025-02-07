package com.i2soft.i2up.v20250123.appContinuity;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.appContinuity.v20250123.AppContinuity;
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
public class AppContinuityTest {

    private static Auth auth;
    private static AppContinuity appContinuity;

    @BeforeClass
    public static void setUp() {
        if (appContinuity != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        appContinuity = new AppContinuity(auth);
    }

    @Test
    public void T5910_createAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5910")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appContinuity.createAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5914_modifyAppContinuity() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5914")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appContinuity.modifyAppContinuity(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5915_deleteAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5915")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.deleteAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5919_describeAppContinuity() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = appContinuity.describeAppContinuity(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5916_listAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5916")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.listAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_startAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.startAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_stopAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.stopAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_mmediatelyAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.mmediatelyAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_eleteAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.eleteAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_failoverAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.failoverAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_failbackAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.failbackAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5917_criptAppContinuity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5917")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.criptAppContinuity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5918_listAppContinuityStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5918")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appContinuity.listAppContinuityStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}