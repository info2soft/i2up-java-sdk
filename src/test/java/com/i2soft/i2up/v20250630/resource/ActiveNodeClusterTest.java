package com.i2soft.i2up.v20250630.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20250630.ActiveNodeCluster;
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
public class ActiveNodeClusterTest {

    private static Auth auth;
    private static ActiveNodeCluster activeNodeCluster;

    @BeforeClass
    public static void setUp() {
        if (activeNodeCluster != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        activeNodeCluster = new ActiveNodeCluster(auth);
    }

    @Test
    public void T3958_listActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3958")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.listActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3954_createActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3954")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeCluster.createActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3967_getActiveNodeClusterInfo() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = activeNodeCluster.getActiveNodeClusterInfo(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3956_modifyActiveNodeCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3956")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeCluster.modifyActiveNodeCluster(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3968_deleteActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3968")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.deleteActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7634_listClusterActiveNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7634")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.listClusterActiveNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7582_addNodeActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7582")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.addNodeActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7583_removeNodeActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7583")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.removeNodeActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3955_listActiveNodeClusterStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3955")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeCluster.listActiveNodeClusterStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3957_switchAdtiveNodeClusterMaintenance() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3957")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeCluster.switchAdtiveNodeClusterMaintenance(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}