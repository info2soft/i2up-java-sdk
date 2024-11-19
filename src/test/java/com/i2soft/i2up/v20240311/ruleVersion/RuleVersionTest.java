package com.i2soft.i2up.v20240311.ruleVersion;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.ruleVersion.RuleVersion;
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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RuleVersionTest {

    private static Auth auth;
    private static RuleVersion ruleVersion;

    @BeforeClass
    public static void setUp() {
        if (ruleVersion != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        ruleVersion = new RuleVersion(auth);
    }

    @Test
    public void T5617_listRuleVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5617")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleVersion.listRuleVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5618_describeRuleVersionInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "5618")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = ruleVersion.describeRuleVersionInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}