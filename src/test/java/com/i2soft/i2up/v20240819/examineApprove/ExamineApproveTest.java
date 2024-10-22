package com.i2soft.i2up.v20240819.examineApprove;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.examineApprove.v20240819.ExamineApprove;
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
public class ExamineApproveTest {

    private static Auth auth;
    private static ExamineApprove examineApprove;

    @BeforeClass
    public static void setUp() {
        if (examineApprove != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        examineApprove = new ExamineApprove(auth);
    }

    @Test
    public void T7192_createExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7192")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = examineApprove.createExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7193_listExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7193")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.listExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7194_approveExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7194")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.approveExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7194_enableExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7194")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.enableExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7194_receiptExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7194")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.receiptExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7194_deleteExamineApprove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7194")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.deleteExamineApprove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7200_listExamineApproveApproverList() {
        try {
            Map rs = examineApprove.listExamineApproveApproverList(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7221_examineApproveImport() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7221")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = examineApprove.examineApproveImport(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7222_listExamineApproveFileInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7222")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = examineApprove.listExamineApproveFileInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7225_examineApproveDownlowdFile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "7225")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            byte[] rs = examineApprove.examineApproveDownlowdFile(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}