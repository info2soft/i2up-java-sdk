package test.com.i2soft.fsp;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.fsp.v20181217.FspMove;
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
public class FspMoveTest {

    private static Auth auth;
    private static String uuid = TestConfig.testUuid;
    private static FspMove fspMove;

    @BeforeClass
    public static void setUp() {
        if (fspMove != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        fspMove = new FspMove(auth);
    }

    @Test
    public void T01_listFspMoveNic() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "474")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.listFspMoveNic(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T02_listFspMoveDir() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "475")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.listFspMoveDir(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T03_verifyFspMoveLicense() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "476")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspMove.verifyFspMoveLicense(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T04_verifyFspMoveOldRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "477")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspMove.verifyFspMoveOldRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T05_verifyFspMoveVolumeSpace() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "478")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.verifyFspMoveVolumeSpace(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T06_verifyFspMoveOsVersion() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "479")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.verifyFspMoveOsVersion(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T07_createFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "467")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspMove.createFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T08_describeFspMove() {
        try {
            Map rs = fspMove.describeFspMove(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T09_modifyFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "467")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspMove.modifyFspMove(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T10_listFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "471")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.listFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T11_stopFspMove() {
        try {
            I2Rs.I2SmpRs rs = fspMove.stopFspMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T12_startFspMove() {
        try {
            I2Rs.I2SmpRs rs = fspMove.startFspMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T13_moveFspMove() {
        try {
            I2Rs.I2SmpRs rs = fspMove.moveFspMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T14_rebootFspMove() {
        try {
            I2Rs.I2SmpRs rs = fspMove.rebootFspMove(new String[]{uuid}); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T15_listFspMoveStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "473")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = fspMove.listFspMoveStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void T16_deleteFspMove() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "470")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = fspMove.deleteFspMove(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}