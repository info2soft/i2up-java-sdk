package com.i2soft.i2up.v20260209.vmClone;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vmClone.v20260209.VmCloneRule;
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
public class VmCloneRuleTest {

    private static Auth auth;
    private static VmCloneRule vmCloneRule;

    @BeforeClass
    public static void setUp() {
        if (vmCloneRule != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        vmCloneRule = new VmCloneRule(auth);
    }

    @Test
    public void T6690_createVmCloneRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6690")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = vmCloneRule.createVmCloneRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6691_listVmCloneRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6691")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneRule.listVmCloneRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6692_describeVmCloneRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = vmCloneRule.describeVmCloneRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6693_deleteVmCloneRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6693")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneRule.deleteVmCloneRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6694_startVmCloneRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6694")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneRule.startVmCloneRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6694_stopVmCloneRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6694")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneRule.stopVmCloneRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6695_listVmCloneRuleStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6695")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneRule.listVmCloneRuleStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}