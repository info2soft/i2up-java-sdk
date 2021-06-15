package com.i2soft.i2up.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.v20190805.TimingBackup;
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
public class TimingBackupTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static TimingBackup timingBackup;

    @BeforeClass
    public static void setUp() {
        if (timingBackup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        timingBackup = new TimingBackup(auth);
    }

    @Test
    public void T01_describeTimingBackupMssqlSource() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "526")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupMssqlSource(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_verifyTimingBackupOracleInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "527")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.verifyTimingBackupOracleInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_describeTimingBackupOracleContent() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "528")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupOracleContent(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_descibeTimingBackupOracleSriptPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "529")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.descibeTimingBackupOracleSriptPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_listTimingBackupMssqlDbList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "530")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.listTimingBackupMssqlDbList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_createTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.createTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_describeTimingBackup() {
        try {
            Map rs = timingBackup.describeTimingBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_modifyTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.modifyTimingBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_listTimingBackup() {
        try {
            Map rs = timingBackup.listTimingBackup(new StringMap()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_listTimingBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "536")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.listTimingBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_startTimingBackup() {
        try {
            I2Rs.I2SmpRs rs = timingBackup.startTimingBackup(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_stopTimingBackup() {
        try {
            I2Rs.I2SmpRs rs = timingBackup.stopTimingBackup(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T13_deleteTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "534")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.deleteTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}