package com.i2soft.i2up.v20250123.stream;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.stream.v20250123.OracleBkTakeover;
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
public class OracleBkTakeoverTest {

    private static Auth auth;
    private static OracleBkTakeover oracleBkTakeover;

    @BeforeClass
    public static void setUp() {
        if (oracleBkTakeover != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        oracleBkTakeover = new OracleBkTakeover(auth);
    }

    @Test
    public void T6387_listBkTakeoveNetworkCard() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6387")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleBkTakeover.listBkTakeoveNetworkCard(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6386_createBkTakeover() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6386")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleBkTakeover.createBkTakeover(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6390_describeBkTakeoverResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6390")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = oracleBkTakeover.describeBkTakeoverResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}