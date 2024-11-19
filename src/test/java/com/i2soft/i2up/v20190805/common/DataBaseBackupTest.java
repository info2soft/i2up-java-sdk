package com.i2soft.i2up.v20190805.common;

import com.i2soft.common.Auth;
import com.i2soft.common.v20190805.DataBaseBackup;
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

import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBaseBackupTest {

    private static Auth auth;
    private static DataBaseBackup dataBaseBackup;

    @BeforeClass
    public static void setUp() {
        if (dataBaseBackup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dataBaseBackup = new DataBaseBackup(auth);
    }

    @Test
    public void T222_importConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "222")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dataBaseBackup.importConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T223_exportConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.exportConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T224_listBackupHistory() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.listBackupHistory(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T225_backupConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.backupConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T226_describeBackupConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.describeBackupConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}