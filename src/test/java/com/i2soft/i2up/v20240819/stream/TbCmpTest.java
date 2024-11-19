package com.i2soft.i2up.v20240819.stream;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stream.v20240819.TbCmp;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TbCmpTest {

    private static Auth auth;
    private static TbCmp tbCmp;

    @BeforeClass
    public static void setUp() {
        if (tbCmp != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        tbCmp = new TbCmp(auth);
    }

    @Test
    public void T6451_createTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6451")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tbCmp.createTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7676_listSyncTbCmpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7676")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.listSyncTbCmpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6491_stopTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6491")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.stopTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6491_restartTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6491")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.restartTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6491_cmpStopTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6491")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.cmpStopTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6491_cmpResumeTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6491")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.cmpResumeTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6491_cmpImmediate() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6491")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.cmpImmediate(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7387_describeSyncTbCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7387")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.describeSyncTbCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7388_describeTbCmpErrorMsg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7388")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tbCmp.describeTbCmpErrorMsg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}