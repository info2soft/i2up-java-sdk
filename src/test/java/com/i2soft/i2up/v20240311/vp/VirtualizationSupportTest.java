package com.i2soft.i2up.v20240311.vp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vp.v20240311.VirtualizationSupport;
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
public class VirtualizationSupportTest {

    private static Auth auth;
    private static VirtualizationSupport virtualizationSupport;

    @BeforeClass
    public static void setUp() {
        if (virtualizationSupport != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        virtualizationSupport = new VirtualizationSupport(auth);
    }

    @Test
    public void T782_describeVpRuleRate() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "782")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.describeVpRuleRate(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T784_describeVmProtectRate() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "784")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.describeVmProtectRate(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T596_createVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "596")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T713_modifyVpBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "713")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T709_describeVpBackup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T601_describeVpBackupGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpBackupGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T598_listVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "598")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T711_listVpBackupGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "711")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T599_listVpBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "599")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T594_startVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "594")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.startVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T595_deleteVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "595")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.deleteVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3381_deleteVpBackupPoint() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3381")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpBackupPoint(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T612_createVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "612")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T619_describeVpRecoveryGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpRecoveryGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T622_listVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "622")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T623_listVpRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "623")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T620_startVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "620")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.startVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T621_deleteVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "621")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T602_createVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1966_batchCreateVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1966")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.batchCreateVpRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1633_modifyVpRepGroup() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1633")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpRepGroup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T606_describeVpMove() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpMove(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T732_modifyVpMove() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "732")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpMove(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T603_listVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "603")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T607_listVpMoveStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "607")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpMoveStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T605_stopVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "605")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.stopVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T604_deleteVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T752_listVpRepPointList() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "752")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRepPointList(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6260_describeSnapshotInfo() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6260")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.describeSnapshotInfo(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1526_listVpDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1526")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1520_createVpDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1520")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVpDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1522_describeVpDrill() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpDrill(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1525_deleteVpDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1525")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.deleteVpDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1523_listVpDrillStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1523")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpDrillStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2923_getConsoleUrl() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2923")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.getConsoleUrl(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1524_stopVpDrill() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1524")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.stopVpDrill(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2400_createVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2400")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2401_modifyVpFileRecovery() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2401")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.modifyVpFileRecovery(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2402_listVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2402")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2406_describeVpFileRecovery() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = virtualizationSupport.describeVpFileRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2405_attachVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2405")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.attachVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2403_listVpFileRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2403")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpFileRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2404_deleteVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2404")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.deleteVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}