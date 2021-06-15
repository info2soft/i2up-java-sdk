package com.i2soft.i2up.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.v20190805.TimingRecovery;
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
public class TimingRecoveryTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static TimingRecovery timingRecovery;

    @BeforeClass
    public static void setUp() {
        if (timingRecovery != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        timingRecovery = new TimingRecovery(auth);
    }

    @Test
    public void T01_listTimingRecoveryMssqlTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "541")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryMssqlTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_describeTimingRecoveryMssqlInitInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "542")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.describeTimingRecoveryMssqlInitInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_listTimingRecoveryPathList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "543")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryPathList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_verifyTimingRecoveryMssqlInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "544")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.verifyTimingRecoveryMssqlInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_createTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "538")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.createTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_modifyTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "538")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.modifyTimingRecovery(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_describeTimingRecovery() {
        try {
            Map rs = timingRecovery.describeTimingRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_listTimingRecovery() {
        try {
            Map rs = timingRecovery.listTimingRecovery(new StringMap()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_listTimingRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "546")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_startTimingRecovery() {
        try {
            I2Rs.I2SmpRs rs = timingRecovery.startTimingRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_stopTimingRecovery() {
        try {
            I2Rs.I2SmpRs rs = timingRecovery.stopTimingRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_deleteTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "547")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.deleteTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T13_listTimingRecoveryDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1068")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}