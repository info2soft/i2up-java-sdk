package test.com.i2soft.util;

import com.i2soft.http.I2softException;
import com.i2soft.util.Configuration;
import com.i2soft.common.Auth;
import org.junit.Assert;
import org.junit.Test;

public class AuthTest {

    @Test
    public void auth() {
        Configuration cfg = new Configuration();

        try {
            Auth auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, cfg);
            System.out.println(auth.token);
            Assert.assertNotNull(auth.token);

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
