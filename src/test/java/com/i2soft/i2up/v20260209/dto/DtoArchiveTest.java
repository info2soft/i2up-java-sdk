package com.i2soft.i2up.v20260209.dto;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.dto.v20260209.DtoArchive;
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
public class DtoArchiveTest {

    private static Auth auth;
    private static DtoArchive dtoArchive;

    @BeforeClass
    public static void setUp() {
        if (dtoArchive != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        dtoArchive = new DtoArchive(auth);
    }

    @Test
    public void T6879_listDtoArchive() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6879")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.listDtoArchive(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6886_exportDtoArchiveData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6886")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = dtoArchive.exportDtoArchiveData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6906_getDtoArchiveYear() {
        try {
            I2Rs.I2SmpRs rs = dtoArchive.getDtoArchiveYear(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6887_downloadDtoArchiveData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6887")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = dtoArchive.downloadDtoArchiveData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6964_restoreDtoArchiveData() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6964")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.restoreDtoArchiveData(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6889_createDtoArchiveReportRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6889")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dtoArchive.createDtoArchiveReportRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6933_modifyDtoArchiveReportRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6933")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = dtoArchive.modifyDtoArchiveReportRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6910_describeDtoArchiveReportRule() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = dtoArchive.describeDtoArchiveReportRule(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6926_deleteDtoArchiveReportRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6926")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.deleteDtoArchiveReportRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6888_listDtoArchiveReportRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6888")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.listDtoArchiveReportRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6893_listDtoArchiveReportHistory() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6893")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.listDtoArchiveReportHistory(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6895_listDtoArchiveReportStatistics() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "6895")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = dtoArchive.listDtoArchiveReportStatistics(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}