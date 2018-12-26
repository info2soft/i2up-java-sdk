package test.com.i2soft.notifications;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.notifications.Notifications;
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
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NotificationsTest {

    private static Auth auth;
    private static Notifications notifications;

    @BeforeClass
    public static void setUp() {
        if (notifications != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        notifications = new Notifications(auth);
    }

    @Test
    public void T1_listNotifications() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "737")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = notifications.listNotifications(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_describeNotifications() {
        try {
            String uuid = UUID.randomUUID().toString();
            Map rs = notifications.describeNotifications(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_describeNotificationsCount() {
        try {
            Map rs = notifications.describeNotificationsCount(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_deleteNotifications() {
        try {
            I2Rs.I2SmpRs rs = notifications.deleteNotifications(new String[]{}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4_readNotifications() {
        try {
            I2Rs.I2SmpRs rs = notifications.readNotifications(1); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T5_describeNotificationsConfig() {
        try {
            Map rs = notifications.describeNotificationsConfig(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T6_updateNotificationsConfig() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "741")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            I2Rs.I2SmpRs rs = notifications.updateNotificationsConfig(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T7_testNotificationsEmail() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "744")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToObject(Map.class))); // 填充请求数据
            Map rs = notifications.testNotificationsEmail(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T8_resetNotificationsTimes() {
        try {
            Map rs = notifications.resetNotificationsTimes(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}