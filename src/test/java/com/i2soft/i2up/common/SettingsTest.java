package com.i2soft.i2up.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Settings;
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
public class SettingsTest {

    private static Auth auth;
    private static Settings settings;

    @BeforeClass
    public static void setUp() {
        if (settings != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        settings = new Settings(auth);
    }

    @Test
    public void T195_updateSetting() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "195")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.updateSetting(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T196_listSysSetting() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "196")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listSysSetting(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1603_listPublicSettings() {
        try {
            Map rs = settings.listPublicSettings(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T197_describeCCip() {
        try {
            Map rs = settings.describeCCip(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T188_createUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "188")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.createUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T186_listUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "186")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T788_describeUser() {
        try {
            Integer id = 1;
            Map rs = settings.describeUser(id); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T189_deleteUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "189")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.deleteUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T187_modifyUser() {
        try {
            Integer id = 1;
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "187")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyUser(id, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T191_modifyUserPwd() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "191")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyUserPwd(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T192_listProfile() {
        try {
            Map rs = settings.listProfile(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T193_modifyProfile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "193")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyProfile(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T194_logout() {
        try {
            I2Rs.I2SmpRs rs = settings.logout(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T914_listAk() {
        try {
            Map rs = settings.listAk(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T922_createAk() {
        try {
            I2Rs.I2SmpRs rs = settings.createAk(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T923_modifyAk() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "923")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyAk(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T924_deleteAk() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "924")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.deleteAk(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1140_listRole() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "1140")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listRole(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2444_listNpsvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2444")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listNpsvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2445_describeNpsvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2445")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.describeNpsvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2446_modifyNpsvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2446")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyNpsvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2447_deleteNpsvr() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2447")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.deleteNpsvr(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2451_listNpsvrStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2451")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listNpsvrStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2448_listNpsvrBakList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2448")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listNpsvrBakList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T2449_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2449")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = settings.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void T2553_listBakConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2553")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listBakConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2554_describeBakConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2554")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.describeBakConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2555_modifyBakConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2555")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.modifyBakConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2556_deleteBakConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2556")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = settings.deleteBakConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2557_listBakConfigStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2557")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listBakConfigStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2558_listBakHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2558")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = settings.listBakHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

//    @Test
//    public void T2559_tempFuncName() {
//        try {
//            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2559")); // 获取请求数据
//            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
//            I2Rs.I2SmpRs rs = settings.tempFuncName(args); // 发送请求
//            Assert.assertNotNull(rs); // 检查结果
//        } catch (I2softException e) {
//            e.printStackTrace();
//        }
//    }
}