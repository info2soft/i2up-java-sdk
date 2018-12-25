package test.com.i2soft.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.TimingBackup;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

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
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        timingBackup = new TimingBackup(auth);
    }

    @Test
    public void T1_describeTimingBackupMssqlSource() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "526")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupMssqlSource(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_verifyTimingBackupOracleInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "527")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.verifyTimingBackupOracleInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_describeTimingBackupOracleContent() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "528")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.describeTimingBackupOracleContent(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_descibeTimingBackupOracleSriptPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "529")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.descibeTimingBackupOracleSriptPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_listTimingBackupMssqlDbList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "530")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.listTimingBackupMssqlDbList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_createTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "533")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.createTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_describeTimingBackup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = timingBackup.describeTimingBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_modifyTimingBackup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "531")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.modifyTimingBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_listTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "537")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.listTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T10_listTimingBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "536")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingBackup.listTimingBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_deleteTimingBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "534")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingBackup.deleteTimingBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T12_startTimingBackup() {
        try {
            I2Rs.I2SmpRs rs = timingBackup.startTimingBackup(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T12_stopTimingBackup() {
        try {
            I2Rs.I2SmpRs rs = timingBackup.stopTimingBackup(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}