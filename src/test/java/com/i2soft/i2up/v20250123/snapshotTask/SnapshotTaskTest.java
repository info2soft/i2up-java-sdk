package com.i2soft.i2up.v20250123.snapshotTask;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.snapshotTask.v20250123.SnapshotTask;
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
public class SnapshotTaskTest {

    private static Auth auth;
    private static SnapshotTask snapshotTask;

    @BeforeClass
    public static void setUp() {
        if (snapshotTask != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        snapshotTask = new SnapshotTask(auth);
    }

    @Test
    public void T2107_createSnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2107")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = snapshotTask.createSnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2440_modifySnapshotTask() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            byte[] rs = snapshotTask.modifySnapshotTask(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2108_listSnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2108")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.listSnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2141_deleteSnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2141")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.deleteSnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2139_listSnapshotTaskStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2139")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.listSnapshotTaskStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2140_describeSnapshotTask() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = snapshotTask.describeSnapshotTask(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2142_startImmediatelySnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2142")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.startImmediatelySnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2142_startSnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2142")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.startSnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2142_stopSnapshotTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2142")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.stopSnapshotTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2109_listSnapshotList() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2109")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.listSnapshotList(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2110_deleteSnapshotList() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2110")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = snapshotTask.deleteSnapshotList(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}