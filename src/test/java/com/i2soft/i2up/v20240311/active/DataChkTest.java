package com.i2soft.i2up.v20240311.active;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.active.v20240311.DataChk;
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
public class DataChkTest {

    private static Auth auth;
    private static DataChk dataChk;

    @BeforeClass
    public static void setUp() {
        if (dataChk != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dataChk = new DataChk(auth);
    }

    @Test
    public void T4025_listDatacheckObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4025")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listDatacheckObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4024_createDatacheckObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4024")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2CreateRs rs = dataChk.createDatacheckObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4026_deleteDatacheckObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4026")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.deleteDatacheckObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4027_describeDatacheckObjCmp() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = dataChk.describeDatacheckObjCmp(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4028_stopObjCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4028")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dataChk.stopObjCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4029_listDatacheckObjCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4029")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listDatacheckObjCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4030_describeDatacheckObjCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4030")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeDatacheckObjCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4031_listDatacheckObjCmpStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4031")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listDatacheckObjCmpStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4032_describeDatacheckObjCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4032")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dataChk.describeDatacheckObjCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4033_listDatacheckObjCmpCmpInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4033")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listDatacheckObjCmpCmpInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2638_createTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2638")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2CreateRs rs = dataChk.createTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2639_describeTbCmp() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2639")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeTbCmp(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2640_deleteTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2640")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.deleteTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2641_listTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2641")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2643_listTbCmpResultTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2643")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.listTbCmpResultTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2644_stopTbCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2644")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dataChk.stopTbCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2645_describeTbCmpResuluTimeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2645")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dataChk.describeTbCmpResuluTimeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2646_describeTbCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2646")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeTbCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2647_describeTbCmpErrorMsg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2647")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeTbCmpErrorMsg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2648_describeTbCmpCmpResult() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2648")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeTbCmpCmpResult(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3227_describeTbCmpCmpDesc() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3227")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dataChk.describeTbCmpCmpDesc(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3811_describeTbCmpStart() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            I2Rs.I2SmpRs rs = dataChk.describeTbCmpStart(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}