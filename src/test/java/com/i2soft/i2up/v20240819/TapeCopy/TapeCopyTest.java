package com.i2soft.i2up.v20240819.TapeCopy;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.TapeCopy.v20240819.TapeCopy;
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
public class TapeCopyTest {

    private static Auth auth;
    private static TapeCopy tapeCopy;

    @BeforeClass
    public static void setUp() {
        if (tapeCopy != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        tapeCopy = new TapeCopy(auth);
    }

    @Test
    public void T3893_listTapeCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3893")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeCopy.listTapeCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3894_createTapeCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3894")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeCopy.createTapeCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3895_describeTapeCopy() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = tapeCopy.describeTapeCopy(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3896_listTapeCopyStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3896")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeCopy.listTapeCopyStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3897_deleteTapeCopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3897")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeCopy.deleteTapeCopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}