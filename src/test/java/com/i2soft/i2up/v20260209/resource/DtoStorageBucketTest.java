package com.i2soft.i2up.v20260209.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20260209.DtoStorageBucket;
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
public class DtoStorageBucketTest {

    private static Auth auth;
    private static DtoStorageBucket dtoStorageBucket;

    @BeforeClass
    public static void setUp() {
        if (dtoStorageBucket != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dtoStorageBucket = new DtoStorageBucket(auth);
    }

    @Test
    public void T7254_createDtoStorageBucket() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7254")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dtoStorageBucket.createDtoStorageBucket(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8218_modifyDtoStorageBucket() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8218")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dtoStorageBucket.modifyDtoStorageBucket(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7258_describeDtoStorageBucket() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = dtoStorageBucket.describeDtoStorageBucket(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7256_listDtoStorageBucket() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7256")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoStorageBucket.listDtoStorageBucket(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7257_deleteDtoStorageBucket() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7257")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoStorageBucket.deleteDtoStorageBucket(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7261_importDtoStorageBucket() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7261")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoStorageBucket.importDtoStorageBucket(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}