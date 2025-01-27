package com.i2soft.i2up.v20250123.fullMachineCopy;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.fullMachineCopy.v20250123.FullMachineCopy;
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
public class FullMachineCopyTest {

    private static Auth auth;
    private static FullMachineCopy fullMachineCopy;

    @BeforeClass
    public static void setUp() {
        if (fullMachineCopy != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        fullMachineCopy = new FullMachineCopy(auth);
    }

    @Test
    public void T5905_createFullMachineCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5905")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fullMachineCopy.createFullMachineCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5906_modifyFullMachineCopy() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5906")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fullMachineCopy.modifyFullMachineCopy(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5907_deleteFullMachineCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5907")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fullMachineCopy.deleteFullMachineCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5908_describeFullMachineCopy() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = fullMachineCopy.describeFullMachineCopy(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5909_listFullMachineCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5909")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fullMachineCopy.listFullMachineCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5913_listFullMachineCopyStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5913")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fullMachineCopy.listFullMachineCopyStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5912_startFullMachineCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5912")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fullMachineCopy.startFullMachineCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5912_stopFullMachineCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5912")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fullMachineCopy.stopFullMachineCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}