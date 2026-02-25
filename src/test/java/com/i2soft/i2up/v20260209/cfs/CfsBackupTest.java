package com.i2soft.i2up.v20260209.cfs;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.cfs.v20260209.CfsBackup;
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
public class CfsBackupTest {

    private static Auth auth;
    private static CfsBackup cfsBackup;

    @BeforeClass
    public static void setUp() {
        if (cfsBackup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        cfsBackup = new CfsBackup(auth);
    }

    @Test
    public void T6601_createCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6601")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = cfsBackup.createCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6604_modifyCfsBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.modifyCfsBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6605_describeCfsBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = cfsBackup.describeCfsBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6606_listCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6606")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.listCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6608_deleteCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6608")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.deleteCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_startCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.startCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_stopCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.stopCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_startSyncCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.startSyncCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_stopSyncCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.stopSyncCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_moveCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.moveCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6609_failoverCfsBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.failoverCfsBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6610_listCfsBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6610")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.listCfsBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6611_listCfsBackupSyncStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6611")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.listCfsBackupSyncStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6617_getWatingMoveNumber() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6617")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.getWatingMoveNumber(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6623_listCfsBackupHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6623")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.listCfsBackupHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8622_describeCfsBackupLetency() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8622")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = cfsBackup.describeCfsBackupLetency(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8649_checkCfsBackupCachedData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8649")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = cfsBackup.checkCfsBackupCachedData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}