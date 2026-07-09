package com.i2soft.i2up.v20260626.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20260626.DiagnoseV3;
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
public class DiagnoseV3Test {

    private static Auth auth;
    private static DiagnoseV3 diagnoseV3;

    @BeforeClass
    public static void setUp() {
        if (diagnoseV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        diagnoseV3 = new DiagnoseV3(auth);
    }

    @Test
    public void T9167_createDiagnose() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9167")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = diagnoseV3.createDiagnose(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9168_listDiagnose() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9168")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = diagnoseV3.listDiagnose(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9169_deleteDiagnose() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9169")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = diagnoseV3.deleteDiagnose(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9170_listVpRules() {
        try {
            Map rs = diagnoseV3.listVpRules(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}