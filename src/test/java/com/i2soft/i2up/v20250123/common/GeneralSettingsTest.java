package com.i2soft.i2up.v20250123.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20250123.GeneralSettings;
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
public class GeneralSettingsTest {

    private static Auth auth;
    private static GeneralSettings generalSettings;

    @BeforeClass
    public static void setUp() {
        if (generalSettings != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        generalSettings = new GeneralSettings(auth);
    }

    @Test
    public void T3632_chkEtcdUrl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3632")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalSettings.chkEtcdUrl(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5654_createUpdateEtcd() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5654")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalSettings.createUpdateEtcd(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5655_listEtcd() {
        try {
            Map rs = generalSettings.listEtcd(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5653_scanEtcdConf() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5653")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalSettings.scanEtcdConf(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5541_createUpdateScheduleSvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5541")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalSettings.createUpdateScheduleSvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5542_listScheduleSvr() {
        try {
            Map rs = generalSettings.listScheduleSvr(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}