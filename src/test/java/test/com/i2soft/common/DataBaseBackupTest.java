package test.com.i2soft.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.common.v20190805.DataBaseBackup;
import com.i2soft.util.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;

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
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        dataBaseBackup = new DataBaseBackup(auth);
    }

    @Test
    public void T01_importConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.importConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_exportConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.exportConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_listBackupHistory() {
        try {
            Map rs = dataBaseBackup.listBackupHistory(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_backupConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.backupConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_describeBackupConfig() {
        try {
            I2Rs.I2SmpRs rs = dataBaseBackup.describeBackupConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}