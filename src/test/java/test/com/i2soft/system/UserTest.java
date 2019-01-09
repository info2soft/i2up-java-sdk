package test.com.i2soft.system;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.system.v20181217.User;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;
import java.util.Objects;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {

    private static Auth auth;
    private static int id = 8;
    private static User user;

    @BeforeClass
    public static void setUp() {
        if (user != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        user = new User(auth);
    }

    @Test
    public void T01_createUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "188")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = user.createUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_listUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "186")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = user.listUser(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_describeUser() {
        try {
            Map rs = user.describeUser(id); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_modifyUser() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "187")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = user.modifyUser(id, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_modifyUserPwd() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "191")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = user.modifyUserPwd(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_listProfile() {
        try {
            Map rs = user.listProfile(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_modifyProfile() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "193")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = user.modifyProfile(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_deleteUser() {
        try {
            I2Rs.I2SmpRs rs = user.deleteUser(new Integer[]{id}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_logout() {
        try {
            I2Rs.I2SmpRs rs = user.logout(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}