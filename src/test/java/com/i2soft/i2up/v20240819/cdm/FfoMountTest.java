package com.i2soft.i2up.v20240819.cdm;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.cdm.v20240819.FfoMount;
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
public class FfoMountTest {

    private static Auth auth;
    private static FfoMount ffoMount;

    @BeforeClass
    public static void setUp() {
        if (ffoMount != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        ffoMount = new FfoMount(auth);
    }

    @Test
    public void T2231_createFfoMount() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2231")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ffoMount.createFfoMount(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2233_modifyFfoMount() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2233")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ffoMount.modifyFfoMount(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2232_describeFfomount() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = ffoMount.describeFfomount(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2234_ffoMountList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2234")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ffoMount.ffoMountList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2236_listFfoMountStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2236")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ffoMount.listFfoMountStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2235_deleteFfoMount() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2235")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ffoMount.deleteFfoMount(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}