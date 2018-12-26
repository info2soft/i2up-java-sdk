package test.com.i2soft.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.Cluster;
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
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClusterTest {

    private static Auth auth;
    private static Cluster cluster;

    @BeforeClass
    public static void setUp() {
        if (cluster != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        cluster = new Cluster(auth);
    }

    @Test
    public void T1_authCls() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "517")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = cluster.authCls(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_verifyClsNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "518")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = cluster.verifyClsNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_createCls() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "524")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = cluster.createCls(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_describeCls() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = cluster.describeCls(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_modifyCls() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "523")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = cluster.modifyCls(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_listCls() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "520")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = cluster.listCls(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_listClsStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "521")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = cluster.listClsStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_deleteCls() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "519")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = cluster.deleteCls(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_clsDetail() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = cluster.clsDetail(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}