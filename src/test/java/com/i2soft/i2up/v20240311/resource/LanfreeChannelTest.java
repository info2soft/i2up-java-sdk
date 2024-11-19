package com.i2soft.i2up.v20240311.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20240311.LanfreeChannel;
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
public class LanfreeChannelTest {

    private static Auth auth;
    private static LanfreeChannel lanfreeChannel;

    @BeforeClass
    public static void setUp() {
        if (lanfreeChannel != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        lanfreeChannel = new LanfreeChannel(auth);
    }

    @Test
    public void T5689_createLanfreeChannel() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5689")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = lanfreeChannel.createLanfreeChannel(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5690_listLanfreeChannel() {
        try {
            Map rs = lanfreeChannel.listLanfreeChannel(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5691_describeLanfreeChannel() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = lanfreeChannel.describeLanfreeChannel(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5692_modifyLanfreeChannel() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5692")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = lanfreeChannel.modifyLanfreeChannel(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5693_deleteLanfreeChannel() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5693")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = lanfreeChannel.deleteLanfreeChannel(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5694_listLanfreeChannelStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5694")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = lanfreeChannel.listLanfreeChannelStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6229_listLanfreeChannelByWkBk() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6229")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = lanfreeChannel.listLanfreeChannelByWkBk(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}