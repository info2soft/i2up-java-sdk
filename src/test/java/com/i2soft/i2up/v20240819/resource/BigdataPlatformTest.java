package com.i2soft.i2up.v20240819.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20240819.BigdataPlatform;
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
public class BigdataPlatformTest {

    private static Auth auth;
    private static BigdataPlatform bigdataPlatform;

    @BeforeClass
    public static void setUp() {
        if (bigdataPlatform != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        bigdataPlatform = new BigdataPlatform(auth);
    }

    @Test
    public void T6341_authBigdataBackupHost() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6341")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.authBigdataBackupHost(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6383_bigdataBackupHostDbAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6383")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.bigdataBackupHostDbAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6337_createBigdataBackupHost() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6337")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.createBigdataBackupHost(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6338_listBigdataBackupHost() {
        try {
            Map rs = bigdataPlatform.listBigdataBackupHost(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6347_describeBigdataBackupHost() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = bigdataPlatform.describeBigdataBackupHost(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6339_modifyBigdataBackupHost() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6339")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.modifyBigdataBackupHost(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6340_deleteBigdataBackupHost() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6340")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataPlatform.deleteBigdataBackupHost(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6342_listBigdataBackupHoststatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6342")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataPlatform.listBigdataBackupHoststatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6343_createBigdataPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6343")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.createBigdataPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6348_describeBigdataPlatform() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = bigdataPlatform.describeBigdataPlatform(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6344_modifyBigdataPlatform() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6344")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bigdataPlatform.modifyBigdataPlatform(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6345_listBigdataPlatform() {
        try {
            Map rs = bigdataPlatform.listBigdataPlatform(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6346_deleteBigdataPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6346")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataPlatform.deleteBigdataPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6354_listBigdataPlatformStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6354")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bigdataPlatform.listBigdataPlatformStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}