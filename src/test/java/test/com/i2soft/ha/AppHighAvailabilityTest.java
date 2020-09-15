package test.com.i2soft.ha;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.ha.v20190805.AppHighAvailability;
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
public class AppHighAvailabilityTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static AppHighAvailability appHighAvailability;

    @BeforeClass
    public static void setUp() {
        if (appHighAvailability != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        appHighAvailability = new AppHighAvailability(auth);
    }

    @Test
    public void T01_listNicInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "218")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.listNicInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_createHA() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "217")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.createHA(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_modifyHA() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "217")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())).put("random_str", uuid); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.modifyHA(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_listHA() {
        try {
            Map rs = appHighAvailability.listHA(new StringMap()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_listHAStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "214")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.listHAStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_describeHA() {
        try {
            Map rs = appHighAvailability.describeHA(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_describeHAScriptPath() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "215")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.describeHAScriptPath(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_stopHA() {
        try {
            Map rs = appHighAvailability.stopHA(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_startHA() {
        try {
            Map rs = appHighAvailability.startHA(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_forceSwitchHA() {
        try {
            Map rs = appHighAvailability.forceSwitchHA(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_deleteHA() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "213")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.deleteHA(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_haVerifyName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "814")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.haVerifyName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void T13_listStageOptions() {
        try {
            Map rs = appHighAvailability.listStageOptions(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T14_createHAGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2244")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.createHAGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T15_listHAGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2251")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.listHAGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T16_deleteHAGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2250")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.deleteHAGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T17_modifyHAGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2245")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.modifyHAGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T18_describeHAGroup() {
        try {
            Map rs = appHighAvailability.describeHAGroup(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T19_forceSwitchHAGroup() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2247")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.forceSwitchHAGroup(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T20_listHASwitchTaskStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2248")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = appHighAvailability.listHASwitchTaskStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T21_resumeHAGroupSwitch() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2249")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.resumeHAGroupSwitch(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T22_pauseHAGroupSwitch() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2249")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = appHighAvailability.pauseHAGroupSwitch(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}