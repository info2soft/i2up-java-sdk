package com.i2soft.i2up.v20260209.timing;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.timing.v20260209.TimingRecovery;
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
public class TimingRecoveryTest {

    private static Auth auth;
    private static TimingRecovery timingRecovery;

    @BeforeClass
    public static void setUp() {
        if (timingRecovery != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        timingRecovery = new TimingRecovery(auth);
    }

    @Test
    public void T541_listTimingRecoveryMssqlTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "541")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryMssqlTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T542_describeTimingRecoveryMssqlInitInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "542")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.describeTimingRecoveryMssqlInitInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T543_listTimingRecoveryPathList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "543")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryPathList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T544_verifyTimingRecoveryMssqlInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "544")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.verifyTimingRecoveryMssqlInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1958_listTimingRecoveryOracleRcPointInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1958")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryOracleRcPointInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2571_describeRcMysqlInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2571")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.describeRcMysqlInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2844_listSbtContrlFile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2844")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listSbtContrlFile(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2845_describeSbtDbid() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2845")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.describeSbtDbid(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T538_createTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "538")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.createTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T540_modifyTimingRecovery() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "540")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.modifyTimingRecovery(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T539_describeTimingRecovery() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = timingRecovery.describeTimingRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T545_listTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "545")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T547_deleteTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "547")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.deleteTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T546_listTimingRecoveryStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "546")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T548_startTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "548")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.startTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T548_stopTimingRecovery() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "548")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.stopTimingRecovery(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2838_describeGroupTimingRecovery() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = timingRecovery.describeGroupTimingRecovery(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3272_timingRecoveryCheckDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3272")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.timingRecoveryCheckDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2839_listTimingRecoveryDbInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2839")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryDbInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1068_listTimingRecoveryDb2Time() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1068")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryDb2Time(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2671_listTimingRecoveryGaussTime() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2671")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listTimingRecoveryGaussTime(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3233_describeTimingRecoveryDmBackupInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3233")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.describeTimingRecoveryDmBackupInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3252_mountVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3252")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.mountVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3252_statusVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3252")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.statusVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3451_taskMountDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3451")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = timingRecovery.taskMountDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3603_listFileSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3603")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listFileSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3604_listDbNames() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3604")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listDbNames(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3886_listMysqlDbTableInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3886")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = timingRecovery.listMysqlDbTableInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}