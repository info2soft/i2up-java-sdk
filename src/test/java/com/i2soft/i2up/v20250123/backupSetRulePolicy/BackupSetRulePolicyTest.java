package com.i2soft.i2up.v20250123.backupSetRulePolicy;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.backupSetRulePolicy.v20250123.BackupSetRulePolicy;
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
public class BackupSetRulePolicyTest {

    private static Auth auth;
    private static BackupSetRulePolicy backupSetRulePolicy;

    @BeforeClass
    public static void setUp() {
        if (backupSetRulePolicy != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        backupSetRulePolicy = new BackupSetRulePolicy(auth);
    }

    @Test
    public void T5583_createReplicaTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5583")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetRulePolicy.createReplicaTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5584_modifyReplicaTask() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5584")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = backupSetRulePolicy.modifyReplicaTask(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5585_listReplicaTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5585")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetRulePolicy.listReplicaTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5586_describeReplicaTask() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = backupSetRulePolicy.describeReplicaTask(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5598_deleteReplicaTask() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5598")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = backupSetRulePolicy.deleteReplicaTask(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}