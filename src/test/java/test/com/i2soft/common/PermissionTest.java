package test.com.i2soft.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.common.v20190805.Permission;
import com.i2soft.util.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;

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
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        permission = new Permission(auth);
    }

    @Test
    public void T01_listCategory() {
        try {
            Map rs = permission.listCategory(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_listCatPerms() {
        try {
            Map rs = permission.listCatPerms(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}