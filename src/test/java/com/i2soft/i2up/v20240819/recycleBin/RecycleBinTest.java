package com.i2soft.i2up.v20240819.recycleBin;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.recycleBin.v20240819.RecycleBin;
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
public class RecycleBinTest {

    private static Auth auth;
    private static RecycleBin recycleBin;

    @BeforeClass
    public static void setUp() {
        if (recycleBin != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        recycleBin = new RecycleBin(auth);
    }

    @Test
    public void T6728_listRecycleBin() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6728")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = recycleBin.listRecycleBin(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6729_describeRecycleBin() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = recycleBin.describeRecycleBin(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}