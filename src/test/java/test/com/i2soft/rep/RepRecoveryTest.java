package test.com.i2soft.rep;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.rep.v20190805.RepRecovery;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepRecoveryTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static Map obj;
    private static RepRecovery repRecovery;

    @BeforeClass
    public static void setUp() {
        if (repRecovery != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        repRecovery = new RepRecovery(auth);
    }

    @Test
    public void T01_createRepRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "508")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = repRecovery.createRepRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_listRepRecovery() {
        try {
            StringMap args = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = repRecovery.listRepRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_listRepRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "513")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = repRecovery.listRepRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_describeRepRecovery() {
        try {
            Map rs = repRecovery.describeRepRecovery(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_modifyRepRecovery() {
        try {
            I2Rs.I2SmpRs rs = repRecovery.modifyRepRecovery(uuid, new StringMap(obj)); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_stopRepRecovery() {
        try {
            I2Rs.I2SmpRs rs = repRecovery.stopRepRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_startRepRecovery() {
        try {
            I2Rs.I2SmpRs rs = repRecovery.startRepRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_listRepRecoveryCdpRange() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "514")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = repRecovery.listRepRecoveryCdpRange(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_listRepRecoveryCdpLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "515")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = repRecovery.listRepRecoveryCdpLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_deleteRepRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "510")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = repRecovery.deleteRepRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_clearFinishRepRecovery() {
        try {
            I2Rs.I2SmpRs rs = repRecovery.clearFinishRepRecovery(1); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}