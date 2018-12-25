package test.com.i2soft.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.TimingRecovery;
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
public class TimingRecoveryTest {

    private static Auth auth;
    private static TimingRecovery timingRecovery;

    @BeforeClass
    public static void setUp() {
        if (timingRecovery != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        timingRecovery = new TimingRecovery(auth);
    }

    @Test
    public void T1_listTimingRecoveryMssqlTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "541")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryMssqlTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_describeTimingRecoveryMssqlInitInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "542")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingRecovery.describeTimingRecoveryMssqlInitInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_listTimingRecoveryPathList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "543")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryPathList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_verifyTimingRecoveryMssqlInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "544")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.verifyTimingRecoveryMssqlInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_createTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "538")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.createTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_modifyTimingRecovery() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "540")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.modifyTimingRecovery(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_describeTimingRecovery() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = timingRecovery.describeTimingRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_listTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "545")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingRecovery.listTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_listTimingRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "546")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T10_deleteTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "547")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.deleteTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_startTimingRecovery() {
        try {
            I2Rs.I2SmpRs rs = timingRecovery.startTimingRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_stopTimingRecovery() {
        try {
            I2Rs.I2SmpRs rs = timingRecovery.stopTimingRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}