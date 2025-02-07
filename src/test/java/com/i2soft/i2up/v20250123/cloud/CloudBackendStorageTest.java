package com.i2soft.i2up.v20250123.cloud;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.cloud.v20250123.CloudBackendStorage;
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
public class CloudBackendStorageTest {

    private static Auth auth;
    private static CloudBackendStorage cloudBackendStorage;

    @BeforeClass
    public static void setUp() {
        if (cloudBackendStorage != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        cloudBackendStorage = new CloudBackendStorage(auth);
    }

    @Test
    public void T6849_listBackendStorages() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6849")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cloudBackendStorage.listBackendStorages(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6855_describeBackendStorage() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = cloudBackendStorage.describeBackendStorage(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6851_createBackendStorage() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6851")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = cloudBackendStorage.createBackendStorage(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6852_modifyBackendStorage() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6852")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = cloudBackendStorage.modifyBackendStorage(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6853_deleteBackendStorage() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6853")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = cloudBackendStorage.deleteBackendStorage(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}