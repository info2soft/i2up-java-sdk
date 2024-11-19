package com.i2soft.i2up.v20230227.common;

import com.i2soft.common.Auth;
import com.i2soft.common.v20230227.Permission;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PermissionTest {

    private static Auth auth;
    private static Permission permission;

    @BeforeClass
    public static void setUp() {
        if (permission != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        permission = new Permission(auth);
    }

    @Test
    public void T2848_listPermission() {
        try {
            I2Rs.I2SmpRs rs = permission.listPermission(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}