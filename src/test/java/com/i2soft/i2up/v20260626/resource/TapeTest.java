package com.i2soft.i2up.v20260626.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20260626.Tape;
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
public class TapeTest {

    private static Auth auth;
    private static Tape tape;

    @BeforeClass
    public static void setUp() {
        if (tape != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        tape = new Tape(auth);
    }

    @Test
    public void T5713_scanTapeLibraries() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5713")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.scanTapeLibraries(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5715_listTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5715")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5716_createTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5716")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.createTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5717_listTapeLibrary() {
        try {
            Map rs = tape.listTapeLibrary(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5719_modifyTapeLibrary() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5719")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.modifyTapeLibrary(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5718_describeTapeLibrary() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = tape.describeTapeLibrary(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5720_deleteTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5720")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.deleteTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5734_refreshTapeLibrarySlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5734")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.refreshTapeLibrarySlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6157_listBusySlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6157")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listBusySlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5725_listBusyIeSlot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5725")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listBusyIeSlot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5723_importTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5723")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.importTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5724_enableTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5724")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.enableTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5724_moveTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5724")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.moveTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5733_listTapePools() {
        try {
            Map rs = tape.listTapePools(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7635_listTapeLibraryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7635")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeLibraryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5735_createTapePool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5735")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.createTapePool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5740_updateTapePool() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5740")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.updateTapePool(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6307_deleteTapePool() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6307")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.deleteTapePool(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_freezeTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.freezeTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_browseTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.browseTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_rebuildTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.rebuildTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_exportTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.exportTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_moveTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.moveTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_refreshTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.refreshTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_formatTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.formatTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_eraseTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.eraseTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5736_deleteTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.deleteTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5742_listTapeMedia() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5742")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeMedia(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6504_listTapeMediaBkData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6504")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeMediaBkData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6502_listTapeMediaBkFiles() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6502")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeMediaBkFiles(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6844_modifyTapeLibraryRoboticArm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6844")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.modifyTapeLibraryRoboticArm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6503_listTapeMediaDetails() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6503")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeMediaDetails(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6588_refreshTapeLibrary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6588")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.refreshTapeLibrary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6591_listTapeLibraryRoboticArm() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6591")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeLibraryRoboticArm(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6752_setTapeLibraryFreezeNumber() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6752")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.setTapeLibraryFreezeNumber(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9214_registerTapeLibraryBackupSvrDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9214")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.registerTapeLibraryBackupSvrDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7315_listTapeLibraryBackupSvrDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7315")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = tape.listTapeLibraryBackupSvrDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6845_modifyTapeLibraryBackupSvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6845")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.modifyTapeLibraryBackupSvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6846_modifyTapeLibraryDrivers() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6846")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = tape.modifyTapeLibraryDrivers(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}