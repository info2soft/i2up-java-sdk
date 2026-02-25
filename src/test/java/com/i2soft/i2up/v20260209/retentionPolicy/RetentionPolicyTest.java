package com.i2soft.i2up.v20260209.retentionPolicy;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.retentionPolicy.v20260209.RetentionPolicy;
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
public class RetentionPolicyTest {

    private static Auth auth;
    private static RetentionPolicy retentionPolicy;

    @BeforeClass
    public static void setUp() {
        if (retentionPolicy != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        retentionPolicy = new RetentionPolicy(auth);
    }

    @Test
    public void T5522_listRetentionPolicy() {
        try {
            Map rs = retentionPolicy.listRetentionPolicy(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5524_modifyRetentionPoliciy() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5524")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = retentionPolicy.modifyRetentionPoliciy(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}