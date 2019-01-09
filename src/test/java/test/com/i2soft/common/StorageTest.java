package test.com.i2soft.common;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.v20181217.Storage;
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
public class StorageTest {

    private static Auth auth;
    private static Storage storage;

    @BeforeClass
    public static void setUp() {
        if (storage != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
        storage = new Storage(auth);
    }

    @Test
    public void T01_listStorageInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "210")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = storage.listStorageInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}