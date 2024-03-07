package com.i2soft.i2up.v20220622.common;

import com.i2soft.common.Auth;
import com.i2soft.common.v20220622.Menu;
import com.i2soft.http.I2softException;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MenuTest {

    private static Auth auth;
    private static Menu menu;

    @BeforeClass
    public static void setUp() {
        if (menu != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        menu = new Menu(auth);
    }

    @Test
    public void T2847_listMenu() {
        try {
            Map rs = menu.listMenu(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}