package com.i2soft.i2up.v20260209.cdm;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.cdm.v20260209.RemoteCoopy;
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
public class RemoteCoopyTest {

    private static Auth auth;
    private static RemoteCoopy remoteCoopy;

    @BeforeClass
    public static void setUp() {
        if (remoteCoopy != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        remoteCoopy = new RemoteCoopy(auth);
    }

    @Test
    public void T3419_verifyDuplicateCdmCoopyRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3419")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.verifyDuplicateCdmCoopyRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3414_createCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = remoteCoopy.createCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3415_listCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3415")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteCoopy.listCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3416_startCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.startCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3416_stopCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.stopCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3416_migrateCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.migrateCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3416_startImmediatelyCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.startImmediatelyCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3417_listCdmRemoteCoopyStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3417")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteCoopy.listCdmRemoteCoopyStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3418_deleteCdmRemoteCoopy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3418")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.deleteCdmRemoteCoopy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3448_describeCdmRemoteCoopy() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = remoteCoopy.describeCdmRemoteCoopy(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3449_verifyCdmCapacity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3449")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.verifyCdmCapacity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3452_listCdmRemoteCoopyLicense() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3452")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.listCdmRemoteCoopyLicense(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3679_verifyCdmDirExist() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3679")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteCoopy.verifyCdmDirExist(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}