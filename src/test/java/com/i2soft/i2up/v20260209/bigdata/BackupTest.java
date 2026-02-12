package com.i2soft.i2up.v20260209.bigdata;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.bigdata.v20260209.Backup;
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
public class BackupTest {

    private static Auth auth;
    private static Backup backup;

    @BeforeClass
    public static void setUp() {
        if (backup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backup = new Backup(auth);
    }

    @Test
    public void T1787_createBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1787")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.createBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1769_listBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1769")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.listBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1791_listBigdataBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1791")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.listBigdataBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1788_describeBigdataBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backup.describeBigdataBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_startBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.startBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_stopBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.stopBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_startImmediatelyBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.startImmediatelyBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_enableBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.enableBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_disableBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.disableBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_pauseBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.pauseBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1789_resumeBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.resumeBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1790_deleteBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1790")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.deleteBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7060_listBigdataBackupTableDdl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7060")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.listBigdataBackupTableDdl(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1808_authBigdataPlatform() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1808")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.authBigdataPlatform(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3200_listBigdataHiveTable() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3200")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.listBigdataHiveTable(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3201_listAllBigdataHiveDatabase() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3201")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.listAllBigdataHiveDatabase(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6555_getBigdataBackupPartitions() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6555")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backup.getBigdataBackupPartitions(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6566_importBigdataBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6566")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backup.importBigdataBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}