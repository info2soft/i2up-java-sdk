package com.i2soft.i2up.v20240819.vmClone;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vmClone.v20240819.VmCloneVm;
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
public class VmCloneVmTest {

    private static Auth auth;
    private static VmCloneVm vmCloneVm;

    @BeforeClass
    public static void setUp() {
        if (vmCloneVm != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        vmCloneVm = new VmCloneVm(auth);
    }

    @Test
    public void T6696_listVmCloneVm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6696")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.listVmCloneVm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6697_modifyVmConfig() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6697")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.modifyVmConfig(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6698_deleteVmCloneVm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6698")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.deleteVmCloneVm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6699_startVmVmCloneVm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6699")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.startVmVmCloneVm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6699_stopVmVmCloneVm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6699")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.stopVmVmCloneVm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6700_listVmCloneVmStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6700")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = vmCloneVm.listVmCloneVmStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6708_describeVmCloneVm() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = vmCloneVm.describeVmCloneVm(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}