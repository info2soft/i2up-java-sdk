package test.com.i2soft.upmonitor;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.upmonitor.v20190805.UpMonitor;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UpMonitorTest {

    private static Auth auth;
    private static UpMonitor upMonitor;

    @BeforeClass
    public static void setUp() {
        if (upMonitor != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        upMonitor = new UpMonitor(auth);
    }

    @Test
    public void T01_authUpMonitor() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "900")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.authUpMonitor(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T02_describeUpMonitorToken() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "943")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.describeUpMonitorToken(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T03_createUpMonitor() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "893")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.createUpMonitor(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T04_modifyUpMonitor() {
        try {
            String uuid = "CE753C48-96F9-6C38-C3DE-A25E7405D03F";
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "894")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.modifyUpMonitor(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T05_describeUpMonitor() {
        try {
            String uuid = "CE753C48-96F9-6C38-C3DE-A25E7405D03F";
            Map rs = upMonitor.describeUpMonitor(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T06_listUpMonitor() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "896")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.listUpMonitor(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T07_refreshUpMonitor() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "897")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.refreshUpMonitor(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T08_listUpMonitorStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "898")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.listUpMonitorStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T09_deleteUpMonitor() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "899")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = upMonitor.deleteUpMonitor(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}