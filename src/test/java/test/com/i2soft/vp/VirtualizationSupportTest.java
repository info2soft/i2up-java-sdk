package test.com.i2soft.vp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vp.v20190805.VirtualizationSupport;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VirtualizationSupportTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static Map obj;
    private static VirtualizationSupport virtualizationSupport;

    @BeforeClass
    public static void setUp() {
        if (virtualizationSupport != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        virtualizationSupport = new VirtualizationSupport(auth);
    }

    // ------------------ Platform ------------------

    @Test
    public void T01_createVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "588")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_describeVp() {
        try {
            Map rs = virtualizationSupport.describeVp(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_modifyVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "699")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVp(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_listVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "589")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_listVpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "591")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_updateDataAgentVp() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.updateDataAgentVp(new String[]{"B4B60E42-6B6E-82EA-14A3-A40C9B64EDE9"}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_listVM() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "597")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVM(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_describeVpAttribute() {
        try {
            Map rs = virtualizationSupport.describeVpAttribute(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_listBakVer() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "614")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listBakVer(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_listBakVerInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "615")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listBakVerInfo(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_listDatastoreFile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "625")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listDatastoreFile(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_listDatacenter() {
        try {
            Map rs = virtualizationSupport.listDatacenter(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_listDatacenterHost() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listDatacenterHost(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T13_listDatastore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "610")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listDatastore(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T14_listDatastoreInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "611")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listDatastoreInfo(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T15_deleteVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "587")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // ------------------ Backup ------------------

    @Test
    public void T16_createVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "596")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T18_describeVpBackup() {
        try {
            Map rs = virtualizationSupport.describeVpBackup(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T17_modifyVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "596")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.modifyVpBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T19_describeVpBackupGroup() {
        try {
            Map rs = virtualizationSupport.describeVpBackupGroup(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T20_listVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "598")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T21_listVpBackupGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "711")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T22_listVpBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "599")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T22_stopVpBackup() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.stopVpBackup(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T23_startVpBackup() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.startVpBackup(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T24_deleteVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "595")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // ------------------ Recovery ------------------

    @Test
    public void T25_createVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "612")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T26_describeVpRecoveryGroup() {
        try {
            Map rs = virtualizationSupport.describeVpRecoveryGroup(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T27_listVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "622")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T28_listVpRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "623")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T28_stopVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.stopVpRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T29_startVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.startVpRecovery(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T29_clearFinishVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.clearFinishVpRecovery(1); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T30_deleteVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "621")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // ------------------ Move ------------------

    @Test
    public void T31_createVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T33_describeVpMove() {
        try {
            Map rs = virtualizationSupport.describeVpMove(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T35_modifyVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpMove(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T37_listVpMove() {
        try {
            Map rs = virtualizationSupport.listVpMove(new StringMap()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T39_listVpMoveStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "607")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpMoveStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T41_stopVpMove() {
        try {
            Map rs = virtualizationSupport.stopVpMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T41_startVpMove() {
        try {
            Map rs = virtualizationSupport.startVpMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T41_moveVpMove() {
        try {
            Map rs = virtualizationSupport.moveVpMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T42_deleteVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // ------------------ Rep ------------------

    @Test
    public void T52_createVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T54_describeVpRep() {
        try {
            Map rs = virtualizationSupport.describeVpRep(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T56_modifyVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpRep(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T58_listVpRep() {
        try {
            Map rs = virtualizationSupport.listVpRep(new StringMap()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T59_listVpRepStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "607")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpRepStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T60_stopVpRep() {
        try {
            Map rs = virtualizationSupport.stopVpRep(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T61_startVpRep() {
        try {
            Map rs = virtualizationSupport.startVpRep(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T61_failoverVpRep() {
        try {
            Map rs = virtualizationSupport.failoverVpRep(new String[]{uuid}, "", 0); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T61_failbackVpRep() {
        try {
            Map rs = virtualizationSupport.failbackVpRep(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T62_listVpRepPointList() {
        try {
            Map rs = virtualizationSupport.listVpRepPointList(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T63_deleteVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    // ------------------ File recovery ------------------

    @Test
    public void T64_describeVpFileRecoveryVmIp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "816")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.describeVpFileRecoveryVmIp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T65_vpFileRecoveryLivecdPartition() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "807")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.vpFileRecoveryLivecdPartition(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T66_createVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "808")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.createVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T67_describeVpFileRecovery() {
        try {
            Map rs = virtualizationSupport.describeVpFileRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T68_listVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "811")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T69_listVpFileRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "812")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.listVpFileRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T70_deleteVpFileRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "815")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = virtualizationSupport.deleteVpFileRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}