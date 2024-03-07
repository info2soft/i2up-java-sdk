package com.i2soft.i2up.v20230227.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.resource.v20230227.CopyVolume;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CopyVolumeTest {

    private static Auth auth;
    private static CopyVolume copyVolume;

    @BeforeClass
    public static void setUp() {
        if (copyVolume != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        copyVolume = new CopyVolume(auth);
    }

    @Test
    public void T2102_createCopyVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2102")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = copyVolume.createCopyVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3198_modifyCopyVolume() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3198")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = copyVolume.modifyCopyVolume(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2104_describeCopyVolume() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = copyVolume.describeCopyVolume(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2105_copyVolumeList() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2105")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.copyVolumeList(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2112_deleteCopyVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2112")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.deleteCopyVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3890_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3890")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2172_listCopyVolumeStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2172")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.listCopyVolumeStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2131_listSnapshotList() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2131")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.listSnapshotList(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2906_listCopyCdmVolume() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2906")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.listCopyCdmVolume(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3173_listCopyVolumeClient() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3173")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = copyVolume.listCopyVolumeClient(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}