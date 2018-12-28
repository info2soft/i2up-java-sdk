package test.com.i2soft.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20181217.BizGroup;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BizGroupTest {

    private static Auth auth;
    private static BizGroup bizGroup;
    private static String grpUuid = UUID.randomUUID().toString();
    private static String resUuid = UUID.randomUUID().toString();
    private static Map bizGrpObj;

    @BeforeClass
    public static void setUp() {
        if (bizGroup != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        bizGroup = new BizGroup(auth);
    }

    @Test
    public void T01_createBizGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "578")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = bizGroup.createBizGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_listBizGroup() {
        try {
            StringMap args = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = bizGroup.listBizGroup(args); // 发送请求
            grpUuid = ((ArrayList<Map>) rs.get("info_list")).get(0).get("grp_uuid").toString();
            System.out.println("\ngrp_uuid: " + grpUuid);
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_describeBizGroup() {
        try {
            Map rs = bizGroup.describeBizGroup(grpUuid); // 发送请求
            bizGrpObj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_modifyBizGroup() {
        try {
            I2Rs.I2SmpRs rs = bizGroup.modifyBizGroup(grpUuid, new StringMap(bizGrpObj)); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_listBizGroupResource() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "586")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = bizGroup.listBizGroupResource(args); // 发送请求
            resUuid = ((ArrayList<Map>) rs.get("info_list")).get(0).get("uuid").toString();
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_listBizGroupBind() {
        try {
            Map rs = bizGroup.listBizGroupBind(grpUuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_updateBizGroupBind() {
        try {
            StringMap args = new StringMap().put("uuids", new String[]{resUuid}); // 填充请求数据
            I2Rs.I2SmpRs rs = bizGroup.updateBizGroupBind(grpUuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_deleteBizGroup() {
        try {
            I2Rs.I2SmpRs rs = bizGroup.deleteBizGroup(new StringMap().put("grp_uuids", new String[]{grpUuid})); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}