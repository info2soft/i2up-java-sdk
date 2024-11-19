package com.i2soft.i2up.v20240819.remoteRep;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.remoteRep.v20240819.RemoteRep;
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
public class RemoteRepTest {

    private static Auth auth;
    private static RemoteRep remoteRep;

    @BeforeClass
    public static void setUp() {
        if (remoteRep != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        remoteRep = new RemoteRep(auth);
    }

    @Test
    public void T3555_createRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3555")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteRep.createRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3556_modifyRemoteRep() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3556")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = remoteRep.modifyRemoteRep(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3557_listRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3557")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3558_describeRemoteRep() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = remoteRep.describeRemoteRep(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3559_startRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3559")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.startRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3559_stopRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3559")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.stopRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3559_startImmediatelyRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3559")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.startImmediatelyRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3560_deleteRemoteRep() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3560")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.deleteRemoteRep(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3573_listRemoteRepStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3573")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listRemoteRepStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3563_listStoragePoolRuleList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3563")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listStoragePoolRuleList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3564_listFileSystem() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3564")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listFileSystem(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6911_listFirstCloneVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6911")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listFirstCloneVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3565_describeCloneVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3565")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.describeCloneVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3575_filterStorageNode() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3575")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.filterStorageNode(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3580_listFileSnapshot() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3580")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = remoteRep.listFileSnapshot(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}