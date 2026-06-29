package com.i2soft.i2up.v20260626.recoveryDrill;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.recoveryDrill.v20260626.RecoveryDrill;
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
public class RecoveryDrillTest {

    private static Auth auth;
    private static RecoveryDrill recoveryDrill;

    @BeforeClass
    public static void setUp() {
        if (recoveryDrill != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        recoveryDrill = new RecoveryDrill(auth);
    }

    @Test
    public void T9431_listRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9431")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.listRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9661_createRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9661")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.createRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9523_describeRecoveryDrill() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = recoveryDrill.describeRecoveryDrill(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9550_modifyRecoveryDrill() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9550")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.modifyRecoveryDrill(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9438_listRecoveryDrillStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9438")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.listRecoveryDrillStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9439_deleteRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9439")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.deleteRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9440_enableRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9440")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.enableRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9440_disableRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9440")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.disableRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9440_manualDrillRecoveryDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9440")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.manualDrillRecoveryDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9443_listDrillInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9443")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.listDrillInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9444_operateDrillInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9444")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.operateDrillInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9445_listDrillInfoStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9445")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.listDrillInfoStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9446_deleteDrillInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9446")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recoveryDrill.deleteDrillInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}