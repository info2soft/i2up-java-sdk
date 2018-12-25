package test.com.i2soft.fsp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.fsp.FspRecovery;
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
public class FspRecoveryTest {

    private static Auth auth;
    private static FspRecovery fspRecovery;

    @BeforeClass
    public static void setUp() {
        if (fspRecovery != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        fspRecovery = new FspRecovery(auth);
    }

    @Test
    public void T1_listFspRecoveryDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "505")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.listFspRecoveryDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_listFspRecoveryNic() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "493")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.listFspRecoveryNic(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_listFspRecoveryPoint() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "494")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.listFspRecoveryPoint(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_verifyFspRecoveryVolumeSpace() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "496")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.verifyFspRecoveryVolumeSpace(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_verifyFspRecoveryOldRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "495")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecovery.verifyFspRecoveryOldRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_verifyFspRecoveryLicense() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "506")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecovery.verifyFspRecoveryLicense(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_verifyFspRecoveryOsVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "497")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.verifyFspRecoveryOsVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_createFspRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "499")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecovery.createFspRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_modifyFspRecovery() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "498")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecovery.modifyFspRecovery(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T10_desribeFspRecovery() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = fspRecovery.desribeFspRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_deleteFspRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "501")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = fspRecovery.deleteFspRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T12_listFspRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "502")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.listFspRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_startFspRecovery() {
        try {
            I2Rs.I2SmpRs rs = fspRecovery.startFspRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_stopFspRecovery() {
        try {
            I2Rs.I2SmpRs rs = fspRecovery.stopFspRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_moveFspRecovery() {
        try {
            I2Rs.I2SmpRs rs = fspRecovery.moveFspRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_rebootFspRecovery() {
        try {
            I2Rs.I2SmpRs rs = fspRecovery.rebootFspRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T14_listFspRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "504")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = fspRecovery.listFspRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}