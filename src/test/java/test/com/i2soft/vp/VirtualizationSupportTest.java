package test.com.i2soft.vp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.vp.VirtualizationSupport;
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
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        virtualizationSupport = new VirtualizationSupport(auth);
    }

    @Test
    public void T1_createVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "588")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.createVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_describeVp() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVp(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_modifyVp() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "699")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.modifyVp(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_listVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "589")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_listVpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "591")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_deleteVp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "587")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_listVM() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "597")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVM(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_describeVpAttribute() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpAttribute(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_listBakVer() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "614")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listBakVer(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T10_listBakVerInfo() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "615")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listBakVerInfo(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_listDatastoreFile() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "625")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listDatastoreFile(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T12_listDatacenter() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.listDatacenter(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_listDatacenterHost() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "609")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listDatacenterHost(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T14_listDatastore() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "610")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listDatastore(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T15_listDatastoreInfo() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "611")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listDatastoreInfo(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T16_createVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "596")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.createVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T17_modifyVpBackup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "713")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.modifyVpBackup(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T18_describeVpBackup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpBackup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T19_describeVpBackupGroup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpBackupGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T20_listVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "598")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T21_listVpBackupGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "711")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T22_listVpBackupStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "599")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpBackupStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T23_startVpBackup() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.startVpBackup(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T23_stopVpBackup() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.stopVpBackup(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T24_deleteVpBackup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "595")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpBackup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T25_createVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "612")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T26_describeVpRecoveryGroup() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpRecoveryGroup(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T27_listVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "622")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T28_listVpRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "623")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T29_startVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.startVpRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T29_stopVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.stopVpRecovery(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T29_clearFinishVpRecovery() {
        try {
            I2Rs.I2SmpRs rs = virtualizationSupport.clearFinishVpRecovery(1); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T30_deleteVpRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "621")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T31_createVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T32_createVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.createVpRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T33_describeVpMove() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpMove(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T34_describeVpRep() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.describeVpRep(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T35_modifyVpMove() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "732")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpMove(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T36_modifyVpRep() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "732")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.modifyVpRep(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T37_listVpMove() {
        try {
            Map rs = virtualizationSupport.listVpMove(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T38_listVpRep() {
        try {
            Map rs = virtualizationSupport.listVpRep(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T39_listVpMoveStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "607")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpMoveStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T40_listVpRepStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "607")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = virtualizationSupport.listVpRepStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_startVpMove() {
        try {
            Map rs = virtualizationSupport.startVpMove(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_startVpRep() {
        try {
            Map rs = virtualizationSupport.startVpRep(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_stopVpMove() {
        try {
            Map rs = virtualizationSupport.stopVpMove(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_stopVpRep() {
        try {
            Map rs = virtualizationSupport.stopVpRep(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_moveVpMove() {
        try {
            Map rs = virtualizationSupport.moveVpMove(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_failoverVpRep() {
        try {
            Map rs = virtualizationSupport.failoverVpRep(new String[]{}, "", 1); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T41_failbackVpRep() {
        try {
            Map rs = virtualizationSupport.failbackVpRep(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T42_deleteVpMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T43_deleteVpRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = virtualizationSupport.deleteVpRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T44_listVpRepPointList() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = virtualizationSupport.listVpRepPointList(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}