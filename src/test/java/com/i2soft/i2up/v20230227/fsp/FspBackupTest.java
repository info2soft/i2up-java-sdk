package com.i2soft.i2up.v20230227.fsp;

import com.i2soft.common.Auth;
import com.i2soft.fsp.v20230227.FspBackup;
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

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FspBackupTest {

    private static Auth auth;
    private static FspBackup fspBackup;

    @BeforeClass
    public static void setUp() {
        if (fspBackup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        fspBackup = new FspBackup(auth);
    }

    @Test
    public void T474_listFspMoveNic() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "474")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspMoveNic(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T475_listFspMoveDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "475")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspMoveDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T478_verifyFspMoveVolumeSpace() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "478")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.verifyFspMoveVolumeSpace(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T476_verifyFspMoveLicense() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "476")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.verifyFspMoveLicense(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T477_verifyFspMoveOldRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "477")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.verifyFspMoveOldRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T479_verifyFspMoveOsVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "479")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.verifyFspMoveOsVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2691_verifyFspMoveEnvironment() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2691")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.verifyFspMoveEnvironment(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1829_listFspMoveDriverInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1829")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspMoveDriverInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T467_createFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "467")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.createFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T469_describeFspMove() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = fspBackup.describeFspMove(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T468_modifyFspMove() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "468")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.modifyFspMove(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T470_deleteFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "470")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.deleteFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T471_listFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "471")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T472_startFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "472")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.startFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T473_listFspMoveStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "473")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspMoveStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2853_batchCreateFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2853")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.batchCreateFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T480_listFspBackupNic() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "480")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspBackupNic(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T481_listFspBackupDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "481")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspBackupDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T492_verifyFspBackupCoopySpace() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "492")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.verifyFspBackupCoopySpace(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T482_verifyFspBackupLicense() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "482")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.verifyFspBackupLicense(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T483_verifyFspBackupOldRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "483")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.verifyFspBackupOldRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T484_verifyFspBackupOsVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "484")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.verifyFspBackupOsVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1853_listFspBackupDriverInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1853")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspBackupDriverInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T490_createFspBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "490")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.createFspBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T489_modifyFspBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "489")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.modifyFspBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T491_describeFspBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = fspBackup.describeFspBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T485_deleteFspBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "485")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.deleteFspBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T486_listFspBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "486")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T487_startFspBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "487")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.startFspBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T488_listFspBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "488")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1991_batchCreateFspBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1991")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspBackup.batchCreateFspBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T493_listFspRecoveryNic() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "493")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspBackup.listFspRecoveryNic(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}