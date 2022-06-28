package com.i2soft.i2up.v20220622.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20220622.Storage;
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
public class StorageTest {

    private static Auth auth;
    private static Storage storage;

    @BeforeClass
    public static void setUp() {
        if (storage != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        storage = new Storage(auth);
    }

    @Test
    public void T1354_createStorageConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1354")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createStorageConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1355_modifyStorageConfig() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1355")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.modifyStorageConfig(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1356_describeStorageConfig() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = storage.describeStorageConfig(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1357_listStorageConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1357")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listStorageConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1358_deleteStorageConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1358")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.deleteStorageConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1413_listStorageStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1413")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listStorageStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1412_uploadDeviceInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1412")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.uploadDeviceInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T210_describeStorageDeviceInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "210")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeStorageDeviceInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1414_describeStorageHistoryData() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1414")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeStorageHistoryData(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1434_listStorageInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1434")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listStorageInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1361_listAvailableNode() {
        try {
            Map rs = storage.listAvailableNode(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1571_switchStorageQuota() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1571")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.switchStorageQuota(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1566_createStorageQuota() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1566")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.createStorageQuota(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1567_modifyStorageQuota() {
        try {
            String uuid1 = UUID.randomUUID().toString().toUpperCase();
            String uuid2 = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1567")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.modifyStorageQuota(uuid1, uuid2, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1568_listStorageQuota() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = storage.listStorageQuota(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1569_deleteStorageQuota() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1569")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.deleteStorageQuota(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1051_listDevice() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1051")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listDevice(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1055_listAvailableDevice() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1055")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listAvailableDevice(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T984_createPool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "984")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createPool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T985_expandPool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "985")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.expandPool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T986_deletePool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "986")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deletePool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T987_listPool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "987")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listPool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T989_listPoolInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "989")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listPoolInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2416_listPoolFromNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2416")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listPoolFromNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T991_createFs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "991")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createFs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T992_deleteFs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "992")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteFs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T993_listFs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "993")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listFs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T995_createFsSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "995")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createFsSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T996_deleteFsSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "996")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteFsSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T997_listFsSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "997")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listFsSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T999_createFsCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "999")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createFsCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1000_deleteFsCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1000")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteFsCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1001_listFsCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1001")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listFsCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1003_createVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1003")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.createVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1004_deleteVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1004")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1005_listVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1005")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1007_createVolumeSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1007")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createVolumeSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1008_deleteVolumeSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1008")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteVolumeSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1009_listVolumeSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1009")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listVolumeSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1011_createVolumeCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1011")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createVolumeCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1012_deleteVolumeCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1012")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteVolumeCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1013_listVolumeCloneSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1013")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listVolumeCloneSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1020_createVMDK() {
        try {
            I2Rs.I2SmpRs rs = storage.createVMDK(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1021_deleteVMDK() {
        try {
            I2Rs.I2SmpRs rs = storage.deleteVMDK(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1177_createBackStore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1177")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createBackStore(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1178_deleteBackStore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1178")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteBackStore(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1179_listBackStore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1179")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBackStore(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1180_createAssignBackStore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1180")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createAssignBackStore(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1212_listAssignBackStore() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1212")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listAssignBackStore(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1213_listBackStoreAvailablePath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1213")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBackStoreAvailablePath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1181_describeIscsiVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1181")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeIscsiVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1275_describeIscsiAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1275")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeIscsiAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1191_createIscsiDiscoverAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1191")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiDiscoverAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1192_deleteIscsiDiscoverAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1192")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiDiscoverAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1236_createAutoAddPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1236")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createAutoAddPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1238_createAutoAddLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1238")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createAutoAddLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1273_describeAutoAddPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1273")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeAutoAddPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1274_describeAutoAddLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1274")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeAutoAddLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1193_describeIscsiTargetStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1193")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeIscsiTargetStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1194_listIscsiTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1194")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listIscsiTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1195_createIscsiTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1195")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1196_deleteIscsiTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1196")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1910_listIscsiTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1910")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listIscsiTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1201_createIscsiInitiator() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1201")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiInitiator(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1202_deleteIscsiInitiator() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1202")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiInitiator(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1203_createIscsiInitiatorConnectAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1203")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiInitiatorConnectAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1204_createIscsiInitiatorLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1204")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiInitiatorLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1205_deleteIscsiInitiatorLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1205")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiInitiatorLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1362_createIscsiInitiatorDiscoverTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1362")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiInitiatorDiscoverTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1363_createIscsiInitiatorConnectTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1363")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createIscsiInitiatorConnectTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1364_deleteIscsiInitiatorConnectTarget() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1364")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiInitiatorConnectTarget(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1365_listIscsiInitiatorPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1365")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listIscsiInitiatorPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1366_deleteIscsiInitiatorPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1366")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteIscsiInitiatorPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1698_iscsiInitiatorRefreshSession() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1698")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.iscsiInitiatorRefreshSession(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1220_listTpg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1220")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listTpg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1197_createTpg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1197")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.createTpg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1198_deleteTpg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1198")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteTpg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1199_createTpgConnectAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1199")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createTpgConnectAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1200_deleteTpgConnectAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1200")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteTpgConnectAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1371_createTpgLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1371")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createTpgLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1374_describeTpgConnectAuth() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1374")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.describeTpgConnectAuth(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1206_deleteTpgLun() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1206")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteTpgLun(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1207_createTpgPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1207")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createTpgPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1208_deleteTpgPortal() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1208")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.deleteTpgPortal(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1872_registerServer() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1872")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.registerServer(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2603_listTape() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2603")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listTape(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2586_scanTapes() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2586")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.scanTapes(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2587_createTape() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2587")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.createTape(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2625_describeTape() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = storage.describeTape(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2588_modifyTape() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2588")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = storage.modifyTape(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2592_deleteTape() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2592")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.deleteTape(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2589_listSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2589")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2590_eraseSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "erase");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_formatSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "format");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_browseSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "browse");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_rebuild_catalogSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "rebuild_catalog");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_unloadSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "unload");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_importSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "import");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2590_exportSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2590")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "export");
            I2Rs.I2SmpRs rs = storage.operateSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2591_listBkData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2591")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBkData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2593_listBkFile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2593")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBkFile(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2598_listBusyDrive() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2598")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBusyDrive(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2599_listFreeSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2599")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listFreeSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2600_listBusyIEslot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2600")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBusyIEslot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2601_listFreeIEslot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2601")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listFreeIEslot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2602_listBusySlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2602")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listBusySlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}