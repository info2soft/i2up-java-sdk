package test.com.i2soft.util;

import com.i2soft.common.I2softException;
import com.i2soft.common.Configuration;
import com.i2soft.util.Auth;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest {

    @Test
    public void auth() {
        Configuration cfg = new Configuration();

        try {
            Auth auth = Auth.create(TestConfig.ip, TestConfig.user, TestConfig.pwd, cfg);
            Assert.assertNotNull(auth.token);

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
