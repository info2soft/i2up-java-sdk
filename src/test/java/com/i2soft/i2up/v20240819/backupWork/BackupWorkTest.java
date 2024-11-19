package com.i2soft.i2up.v20240819.backupWork;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.backupWork.v20240819.BackupWork;
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
public class BackupWorkTest {

    private static Auth auth;
    private static BackupWork backupWork;

    @BeforeClass
    public static void setUp() {
        if (backupWork != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backupWork = new BackupWork(auth);
    }

    @Test
    public void T5596_listBackupWork() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5596")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupWork.listBackupWork(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7182_describeBackupWork() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backupWork.describeBackupWork(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5601_rebootBackupWork() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5601")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupWork.rebootBackupWork(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5601_stopBackupWork() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5601")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupWork.stopBackupWork(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5602_deleteBackupWork() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupWork.deleteBackupWork(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7183_listBackupWorkLogs() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7183")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupWork.listBackupWorkLogs(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7186_listBackupWorkKeyEvents() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backupWork.listBackupWorkKeyEvents(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5992_describeBackupWorkResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5992")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupWork.describeBackupWorkResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6579_listBackupWorkFilter() {
        try {
            Map rs = backupWork.listBackupWorkFilter(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6583_createBackupWorkFilter() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6583")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupWork.createBackupWorkFilter(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6580_describeBackupWorkFilter() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backupWork.describeBackupWorkFilter(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6582_modifyBackupWorkFilter() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6582")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupWork.modifyBackupWorkFilter(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6581_deleteBackupWorkFilter() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6581")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupWork.deleteBackupWorkFilter(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}