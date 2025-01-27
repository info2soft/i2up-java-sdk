package com.i2soft.i2up.v20250123.fingerprintDomain;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.fingerprintDomain.v20250123.FingerprintDomain;
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
public class FingerprintDomainTest {

    private static Auth auth;
    private static FingerprintDomain fingerprintDomain;

    @BeforeClass
    public static void setUp() {
        if (fingerprintDomain != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        fingerprintDomain = new FingerprintDomain(auth);
    }

    @Test
    public void T7204_createFingerprintDomain() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7204")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fingerprintDomain.createFingerprintDomain(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7205_modifyFingerprintDomain() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7205")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fingerprintDomain.modifyFingerprintDomain(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7206_deleteFingerprintDomain() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7206")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fingerprintDomain.deleteFingerprintDomain(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7207_listFingerprintDomain() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7207")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fingerprintDomain.listFingerprintDomain(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7208_describeFingerprintDomain() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = fingerprintDomain.describeFingerprintDomain(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7209_listFingerprintDomainStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7209")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fingerprintDomain.listFingerprintDomainStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}