package com.i2soft.i2up.v20230227.distributor;

import com.i2soft.common.Auth;
import com.i2soft.distributor.DistributorSystem;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DistributorSystemTest {

    private static Auth auth;
    private static DistributorSystem distributorSystem;

    @BeforeClass
    public static void setUp() {
        if (distributorSystem != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        distributorSystem = new DistributorSystem(auth);
    }

    @Test
    public void T1699_listSysSetting() {
        try {
            Map rs = distributorSystem.listSysSetting(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1693_updateSetting() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1693")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = distributorSystem.updateSetting(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1680_queueList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1680")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.queueList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1727_queueDelete() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1727")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = distributorSystem.queueDelete(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1683_upgradeVersion() {
        try {
            Map rs = distributorSystem.upgradeVersion(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1684_update() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1684")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = distributorSystem.update(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1685_alarmStat() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1685")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.alarmStat(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1686_alarmLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1686")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.alarmLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1726_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1726")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = distributorSystem.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1688_createUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1688")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.createUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1689_modifyUser() {
        try {
            Integer id = 1;
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1689")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.modifyUser(id, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1757_listUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1757")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = distributorSystem.listUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1692_statUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1692")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.statUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1695_syncGateway() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1695")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.syncGateway(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1696_syncAccount() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1696")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.syncAccount(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1754_sendFiles() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1754")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = distributorSystem.sendFiles(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}