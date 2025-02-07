package com.i2soft.i2up.v20250123.hdfs;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.hdfs.v20250123.Hdfs;
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
public class HdfsTest {

    private static Auth auth;
    private static Hdfs hdfs;

    @BeforeClass
    public static void setUp() {
        if (hdfs != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        hdfs = new Hdfs(auth);
    }

    @Test
    public void T7108_hdfsSummary() {
        try {
            Map rs = hdfs.hdfsSummary(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3324_createHdfs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3324")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfs.createHdfs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3964_modifyHdfs() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3964")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfs.modifyHdfs(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3325_listHdfs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3325")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3326_describeHdfs() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = hdfs.describeHdfs(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3327_deleteHdfs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3327")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.deleteHdfs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3328_startHdfs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3328")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.startHdfs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3328_stopHdfs() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3328")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.stopHdfs(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3329_listHdfsStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3329")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6538_createHdfsCompare() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6538")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfs.createHdfsCompare(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6539_modifyHdfsCompare() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6539")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = hdfs.modifyHdfsCompare(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6540_listHdfsCompare() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6540")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsCompare(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6541_describeHdfsCompare() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = hdfs.describeHdfsCompare(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6542_deleteHdfsCompare() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6542")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.deleteHdfsCompare(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6543_startHdfsCompare() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6543")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.startHdfsCompare(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6543_stopHdfsCompare() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6543")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.stopHdfsCompare(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6544_listHdfsCompareStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6544")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsCompareStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6531_listHdfsCompareHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6531")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsCompareHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6532_describeHdfsCompareHistory() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = hdfs.describeHdfsCompareHistory(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6548_deleteHdfsCompareHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6548")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.deleteHdfsCompareHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6534_listHdfsCompareResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6534")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsCompareResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6535_listHdfsCompareResultDetail() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6535")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = hdfs.listHdfsCompareResultDetail(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}