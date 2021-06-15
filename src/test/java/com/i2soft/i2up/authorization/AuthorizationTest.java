package com.i2soft.i2up.authorization;

import com.i2soft.authorization.v20190805.Authorization;
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.Configuration;
import com.i2soft.util.Json;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest {

    private static Auth auth;
    private static Authorization authorization;

    @BeforeClass
    public static void setUp() {
        if (authorization != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        authorization = new Authorization(auth);
    }

    @Test
    public void T1_ListAuthorizationUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1563")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = authorization.ListAuthorizationUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_getAuthorizationUserBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1564")); // 获取请求数据
            Map aa = r.jsonToMap();
            aa.put("user_uuid", "7AE5647A-5413-A7C3-449E-0CB18065E72B");
            aa.put("type", 1);
            aa.put("subtype", 0);
            StringMap args = new StringMap().putAll(Objects.requireNonNull(aa)); // 填充请求数据
            Map rs = authorization.getAuthorizationUserBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_updateAuthorizationUserBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1565")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = authorization.updateAuthorizationUserBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_getAuthorizationResBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1666")); // 获取请求数据
            Map aa = r.jsonToMap();
            aa.put("res_uuid", "11111111-1111-1111-1111-111111111111");
            aa.put("limit", 20);
            StringMap args = new StringMap().putAll(Objects.requireNonNull(aa)); // 填充请求数据
            Map rs = authorization.getAuthorizationResBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_updateAuthorizationResBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1667")); // 获取请求数据
            String rJson = "{\n" +
                    "  \"res_uuid\": \"11111111-1111-1111-1111-111111111111\",\n" +
                    "  \"user_list\": [\n" +
                    "    {\n" +
                    "      \"user_uuid\": \"719138DB-F25E-8D47-2D8D-86C2F99E71CB\",\n" +
                    "      \"can_up\": 1,\n" +
                    "      \"can_op\": 1\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";
            StringMap args = new StringMap().putAll(Objects.requireNonNull(Json.decode(rJson).map())); // 填充请求数据
            I2Rs.I2SmpRs rs = authorization.updateAuthorizationResBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_getAuthorizationBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2323")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = authorization.getAuthorizationBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_updateAuthorizationBind() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2324")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = authorization.updateAuthorizationBind(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}