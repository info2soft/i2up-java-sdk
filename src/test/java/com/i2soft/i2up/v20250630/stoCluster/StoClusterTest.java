package com.i2soft.i2up.v20250630.stoCluster;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stoCluster.v20250630.StoCluster;
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
public class StoClusterTest {

    private static Auth auth;
    private static StoCluster stoCluster;

    @BeforeClass
    public static void setUp() {
        if (stoCluster != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        stoCluster = new StoCluster(auth);
    }

    @Test
    public void T9085_createDedupeStorageCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9085")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = stoCluster.createDedupeStorageCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9109_modifyDedupeStorageCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9109")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = stoCluster.modifyDedupeStorageCluster(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9110_describeDedupeStorageCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = stoCluster.describeDedupeStorageCluster(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9111_listDedupeStorageCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9111")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = stoCluster.listDedupeStorageCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9112_deleteDedupeStorageCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9112")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = stoCluster.deleteDedupeStorageCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9113_listDedupeStorageClusterStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9113")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = stoCluster.listDedupeStorageClusterStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}