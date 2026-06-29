package com.i2soft.i2up.v20260626.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20260626.TapeV3;
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
public class TapeV3Test {

    private static Auth auth;
    private static TapeV3 tapeV3;

    @BeforeClass
    public static void setUp() {
        if (tapeV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        tapeV3 = new TapeV3(auth);
    }

    @Test
    public void T9783_scanTapeLibraries() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9783")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.scanTapeLibraries(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9784_listTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9784")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9785_createTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9785")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.createTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9786_listTapeLibrary() {
        try {
            Map rs = tapeV3.listTapeLibrary(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9789_modifyTapeLibrary() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9789")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.modifyTapeLibrary(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9787_describeTapeLibrary() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = tapeV3.describeTapeLibrary(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9788_deleteTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9788")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.deleteTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9794_refreshTapeLibrarySlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9794")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.refreshTapeLibrarySlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9800_listBusySlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9800")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listBusySlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9791_listBusyIeSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9791")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listBusyIeSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9790_importTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9790")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.importTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9792_enableTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9792")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.enableTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9792_moveTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9792")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.moveTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9792_resetTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9792")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.resetTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9793_listTapePools() {
        try {
            Map rs = tapeV3.listTapePools(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9814_listTapeLibraryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9814")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeLibraryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9796_createTapePool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9796")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.createTapePool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9798_updateTapePool() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9798")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.updateTapePool(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9799_deleteTapePool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9799")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.deleteTapePool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_freezeTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.freezeTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_browseTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.browseTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_rebuildTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.rebuildTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_exportTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.exportTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_moveTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.moveTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_refreshTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.refreshTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_formatTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.formatTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_eraseTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.eraseTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9795_deleteTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9795")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.deleteTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9801_listTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9801")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9803_listTapeMediaBkData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9803")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeMediaBkData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9797_listTapeMediaBkFiles() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9797")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeMediaBkFiles(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9802_listTapeMediaDetails() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9802")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeMediaDetails(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9805_refreshTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9805")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.refreshTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9806_listTapeLibraryRoboticArm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9806")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeLibraryRoboticArm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9808_setTapeLibraryFreezeNumber() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9808")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.setTapeLibraryFreezeNumber(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9809_modifyTapeLibraryRoboticArm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9809")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.modifyTapeLibraryRoboticArm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9811_registerTapeLibraryBackupSvrDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9811")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.registerTapeLibraryBackupSvrDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9810_listTapeLibraryBackupSvrDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9810")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tapeV3.listTapeLibraryBackupSvrDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9804_modifyTapeLibraryBackupSvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9804")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.modifyTapeLibraryBackupSvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9807_modifyTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9807")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tapeV3.modifyTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}