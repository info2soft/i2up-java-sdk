package com.i2soft.i2up.v20260209.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20260209.HdfsPlatform;
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
public class HdfsPlatformTest {

    private static Auth auth;
    private static HdfsPlatform hdfsPlatform;

    @BeforeClass
    public static void setUp() {
        if (hdfsPlatform != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        hdfsPlatform = new HdfsPlatform(auth);
    }

    @Test
    public void T3313_createHdfsPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3313")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfsPlatform.createHdfsPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3314_modifyHdfsPlatform() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3314")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfsPlatform.modifyHdfsPlatform(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3315_listHdfsPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3315")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.listHdfsPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3316_describeHdfsPlatform() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = hdfsPlatform.describeHdfsPlatform(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3317_deleteHdfsPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3317")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.deleteHdfsPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3330_listHdfsPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3330")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.listHdfsPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3331_listHdfsHiveEntity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3331")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.listHdfsHiveEntity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7237_refreshHdfsHiveEntity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7237")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfsPlatform.refreshHdfsHiveEntity(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7048_maintainHdfsPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7048")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.maintainHdfsPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7047_listHdfsPlatformStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7047")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfsPlatform.listHdfsPlatformStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}