package com.i2soft.i2up.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20190805.Node;
import com.i2soft.resource.v20190805.ResRs;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static Map obj;
    private static Node node;
    private static Integer os_type;

    @BeforeClass
    public static void setUp() {
        if (node != null) {
            return;
        }
        auth = Auth.access(TestConfig.ip, TestConfig.ak, TestConfig.sk);
        node = new Node(auth);
    }

    @Test
    public void T01_authNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "450")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.authNode(args); // 发送请求
            if (Integer.parseInt(rs.get("code").toString()) != 0) {
                System.out.println("\nFail: " + Integer.parseInt(rs.get("code").toString()));
                return;
            }
            os_type = Integer.parseInt(rs.get("os_type").toString());
            System.out.println("\nos_type: " + os_type);
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_checkCapacity() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "451")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.checkCapacity(args);
            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_listVg() {
        if (os_type != null && os_type.equals(1)) {
            return;
        }
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "742")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.listVg(args);
            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_checkNodeOnline() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "449")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.checkNodeOnline(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_createNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "441")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.createNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_listNode() {
        try {
            StringMap args = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(args);
            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_upgradeNode() {
        try {
            I2Rs.I2SmpRs rs = node.upgradeNode(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_listNodeStatus() {
        try {
            Map rs = node.listNodeStatus(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_describeNode() {
        try {
            Map rs = node.describeNode(uuid); // 发送请求
            obj = rs;
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_describeDeviceInfo() {
        try {
            Map rs = node.describeDeviceInfo(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_modifyNode() {
        try {
            I2Rs.I2SmpRs rs = node.modifyNode(uuid, new StringMap(obj)); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_deleteNode() {
        try {
            I2Rs.I2SmpRs rs = node.deleteNode(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T13_createBatchNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "443")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = node.createBatchNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            Assert.fail();
            e.printStackTrace();
        }
    }

    @Test
    public void T14_listNode() {
        try {
            I2Req.ListArgs args = new I2Req.ListArgs();
            args.limit = 1;
            args.direction = "DESC";
            ResRs.NodeList nodeList = node.listNode(args);
            uuid = nodeList.info_list[0].node_uuid;
            System.out.println("\nuuid: " + uuid);
            Assert.assertNotNull(uuid);
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T15_deleteNode() {
        try {
            I2Rs.I2SmpRs rs = node.deleteNode(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}