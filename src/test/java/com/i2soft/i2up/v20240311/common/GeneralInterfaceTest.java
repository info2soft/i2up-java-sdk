package com.i2soft.i2up.v20240311.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20240311.GeneralInterface;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GeneralInterfaceTest {

    private static Auth auth;
    private static GeneralInterface generalInterface;

    @BeforeClass
    public static void setUp() {
        if (generalInterface != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        generalInterface = new GeneralInterface(auth);
    }

    @Test
    public void T746_describeVersion() {
        try {
            Map rs = generalInterface.describeVersion(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2454_latestVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2454")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.latestVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1811_listVersionHistory() {
        try {
            Map rs = generalInterface.listVersionHistory(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2466_nodeConnectTest() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2466")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalInterface.nodeConnectTest(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T747_overall() {
        try {
            Map rs = generalInterface.overall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T942_upMonitorOverall() {
        try {
            Map rs = generalInterface.upMonitorOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2175_sysadmin() {
        try {
            Map rs = generalInterface.sysadmin(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2453_statusOverall() {
        try {
            Map rs = generalInterface.statusOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6925_statusStreamOverall() {
        try {
            Map rs = generalInterface.statusStreamOverall(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2455_listOverallLogs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2455")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.listOverallLogs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2456_listOverallResourceSta() {
        try {
            Map rs = generalInterface.listOverallResourceSta(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2459_listOverallRealTimeCopy() {
        try {
            Map rs = generalInterface.listOverallRealTimeCopy(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2460_listOverallHa() {
        try {
            Map rs = generalInterface.listOverallHa(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2627_listOverallCdm() {
        try {
            Map rs = generalInterface.listOverallCdm(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2628_listOverallFspMv() {
        try {
            Map rs = generalInterface.listOverallFspMv(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2701_nodeRepSummary() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2701")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.nodeRepSummary(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3121_listVpRuleStat() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3121")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.listVpRuleStat(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4013_listSchedule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4013")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.listSchedule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2785_createColumnExt() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2785")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalInterface.createColumnExt(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2788_describeColumnext() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2788")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.describeColumnext(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2713_exportRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2713")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("where_args", new StringMap().put("rep_uuid",  "FD1DB062-5554-4CBB-95F3-248EBBD1ED20").put("rep_name", "test"));
            // 下载二进制文件
            byte[] rs = generalInterface.exportRules(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3476_importRules() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3476")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalInterface.importRules(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5390_csrSign() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5390")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.csrSign(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5539_listCerts() {
        try {
            Map rs = generalInterface.listCerts(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5540_downloadCa() {
        try {
            Map rs = generalInterface.downloadCa(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6724_getDashboardPlate() {
        try {
            Map rs = generalInterface.getDashboardPlate(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6725_updateDashboardPlate() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6725")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = generalInterface.updateDashboardPlate(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6726_getDashboardStatOverall() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6726")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = generalInterface.getDashboardStatOverall(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T1756_listRpcTask() {
        try {
            Map rs = generalInterface.listRpcTask(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7076_getDashboardHotColdData() {
        try {
            Map rs = generalInterface.getDashboardHotColdData(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}