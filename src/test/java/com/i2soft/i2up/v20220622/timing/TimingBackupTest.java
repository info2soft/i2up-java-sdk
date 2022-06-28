package com.i2soft.i2up.v20220622.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.v20220622.TimingBackup;
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
public class TimingBackupTest {

    private static Auth auth;
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
        }
        timingBackup = new TimingBackup(auth);
    }

    @Test
    public void T526_describeTimingBackupMssqlSource() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "526")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupMssqlSource(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T527_verifyTimingBackupOracleInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "527")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.verifyTimingBackupOracleInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T528_describeTimingBackupOracleContent() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "528")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupOracleContent(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T529_descibeTimingBackupOracleSriptPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "529")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.descibeTimingBackupOracleSriptPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T530_listTimingBackupMssqlDbList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "530")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.listTimingBackupMssqlDbList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1955_verifyTimingBackupOracleLogin() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1955")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.verifyTimingBackupOracleLogin(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T533_createTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.createTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T532_describeTimingBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = timingBackup.describeTimingBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T531_modifyTimingBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "531")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.modifyTimingBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T537_listTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "537")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.listTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T536_listTimingBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "536")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.listTimingBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T534_deleteTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "534")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.deleteTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T535_startTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "535")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "start");
            Map rs = timingBackup.operateTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T535_stopTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "535")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "stop");
            Map rs = timingBackup.operateTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T535_start_immediatelyTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "535")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "start_immediately");
            Map rs = timingBackup.operateTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3298_showTimingBackupDetailInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3298")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.showTimingBackupDetailInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3226_descibeDmDbInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3226")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingBackup.descibeDmDbInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}