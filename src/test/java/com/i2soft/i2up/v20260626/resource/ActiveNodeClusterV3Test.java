package com.i2soft.i2up.v20260626.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20260626.ActiveNodeClusterV3;
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
public class ActiveNodeClusterV3Test {

    private static Auth auth;
    private static ActiveNodeClusterV3 activeNodeClusterV3;

    @BeforeClass
    public static void setUp() {
        if (activeNodeClusterV3 != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        activeNodeClusterV3 = new ActiveNodeClusterV3(auth);
    }

    @Test
    public void T8630_listActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8630")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.listActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8626_createActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8626")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeClusterV3.createActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8631_getActiveNodeClusterInfo() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = activeNodeClusterV3.getActiveNodeClusterInfo(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8628_modifyActiveNodeCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8628")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeClusterV3.modifyActiveNodeCluster(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8633_deleteActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8633")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.deleteActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8635_listClusterActiveNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8635")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.listClusterActiveNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8632_addNodeActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8632")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.addNodeActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8634_removeNodeActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8634")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.removeNodeActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8627_listActiveNodeClusterStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8627")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.listActiveNodeClusterStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8629_switchAdtiveNodeClusterMaintenance() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "8629")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeClusterV3.switchAdtiveNodeClusterMaintenance(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9932_listActiveNodeClusterCandidates() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9932")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = activeNodeClusterV3.listActiveNodeClusterCandidates(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T9933_migrateActiveNodeCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "9933")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = activeNodeClusterV3.migrateActiveNodeCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}