package com.i2soft.i2up.v20240819.vpBackupRule;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vpBackupRule.v20240819.VpBackupRule;
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
public class VpBackupRuleTest {

    private static Auth auth;
    private static VpBackupRule vpBackupRule;

    @BeforeClass
    public static void setUp() {
        if (vpBackupRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        vpBackupRule = new VpBackupRule(auth);
    }

    @Test
    public void T6857_createVpBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6857")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = vpBackupRule.createVpBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6903_modifyVpBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6903")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = vpBackupRule.modifyVpBackupRule(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6904_listVpBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6904")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpBackupRule.listVpBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6905_describeVpBackupRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = vpBackupRule.describeVpBackupRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6907_deleteVpBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6907")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpBackupRule.deleteVpBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6908_operateVpBackupRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6908")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpBackupRule.operateVpBackupRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6909_listVpBackupRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6909")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpBackupRule.listVpBackupRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7071_taskAddVms() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7071")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vpBackupRule.taskAddVms(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}