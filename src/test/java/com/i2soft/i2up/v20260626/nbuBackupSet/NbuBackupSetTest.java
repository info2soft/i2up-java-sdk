package com.i2soft.i2up.v20260626.nbuBackupSet;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.nbuBackupSet.v20260626.NbuBackupSet;
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
public class NbuBackupSetTest {

    private static Auth auth;
    private static NbuBackupSet nbuBackupSet;

    @BeforeClass
    public static void setUp() {
        if (nbuBackupSet != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        nbuBackupSet = new NbuBackupSet(auth);
    }

    @Test
    public void T8639_listBackupWork() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8639")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = nbuBackupSet.listBackupWork(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8640_listQueryArgsNbuBackupSet() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8640")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = nbuBackupSet.listQueryArgsNbuBackupSet(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}