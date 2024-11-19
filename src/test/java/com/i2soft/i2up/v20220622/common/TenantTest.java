package com.i2soft.i2up.v20220622.common;

import com.i2soft.common.Auth;
import com.i2soft.common.v20220622.Tenant;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TenantTest {

    private static Auth auth;
    private static Tenant tenant;

    @BeforeClass
    public static void setUp() {
        if (tenant != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        tenant = new Tenant(auth);
    }

    @Test
    public void T2632_listTenant() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2632")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tenant.listTenant(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2629_createTenant() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2629")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tenant.createTenant(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2630_modifyTenant() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2630")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            String num = String.valueOf(new Random().nextInt(10));
            I2Rs.I2SmpRs rs = tenant.modifyTenant(args, num); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2631_deleteTenant() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2631")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tenant.deleteTenant(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}