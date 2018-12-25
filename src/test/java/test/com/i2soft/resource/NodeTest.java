package test.com.i2soft.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.Node;
import com.i2soft.resource.ResRs;
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
public class NodeTest {

    private static Auth auth;
    private static Node node;

    @BeforeClass
    public static void setUp() {
        if (node != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        node = new Node(auth);
    }

    @Test
    public void T1_checkCapacity() {
        StringMap args = new StringMap()
                .put("config_addr", "192.168.72.76")
                .put("config_port", "26821")
                .put("cache_path", "C:\\Program Files (x86)\\info2soft-i2node\\cache\\");
        try {
            Map rs = node.checkCapacity(args);
            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_listVg() {
        try {
            Map rs = node.listVg(new StringMap()
                    .put("config_addr", "192.168.72.76")
                    .put("config_port", "26821"));

            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_authNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "450")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = node.authNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_checkNodeOnline() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "449")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = node.checkNodeOnline(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_createNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "441")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = node.createNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_modifyNode() {
        try {
            String uuid = UUID.randomUUID().toString();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "440")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = node.modifyNode(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_describeNode() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = node.describeNode(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_createBatchNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "443")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = node.createBatchNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9_describeDeviceInfo() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = node.describeDeviceInfo(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T10_listNode() {
        try {
            I2Req.ListArgs args = new I2Req.ListArgs();
            args.limit = 1;
            ResRs.NodeList nodeList = node.listNode(args);
            Assert.assertNotNull(nodeList);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T11_upgradeNode() {
        try {
            I2Rs.I2SmpRs rs = node.upgradeNode(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T12_listNodeStatus() {
        try {
            Map rs = node.listNodeStatus(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T13_deleteNode() {
        try {
            I2Rs.I2SmpRs rs = node.deleteNode(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}