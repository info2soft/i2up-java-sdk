package test.com.i2soft.util;

import com.i2soft.common.Constants;
import com.i2soft.common.I2softException;
import com.i2soft.http.Client;
import com.i2soft.http.ProxyConfiguration;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.Test;


public class HttpTest {
    private Client httpManager = new Client();

    @Test
    public void testPost1() {
        Response r;
        try {
            r = httpManager.post("http://www.baidu.com", new StringMap());
            Assert.assertNotNull(r);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost3() {
        Response r = null;
        try {
            r = httpManager.post("http://httpbin.org/status/500", new StringMap());
            Assert.fail();
        } catch (I2softException e) {
            if (e.ret() != -1) {
                Assert.assertEquals(500, e.ret());
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testPost4() {
        Response r = null;
        try {
            r = httpManager.post("http://httpbin.org/status/418", new StringMap());
            Assert.fail();
        } catch (I2softException e) {
            if (e.ret() != -1) {
                Assert.assertEquals(418, e.ret());
            } else {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testPost5() {
        Response r = null;
        try {
            r = httpManager.post("http://httpbin.org/status/298", new StringMap());
            if (r.ret != -1) {
                Assert.assertEquals(298, r.ret);
            }
        } catch (I2softException e) {
            if (e.ret() != -1) {
                Assert.fail();
            }
        }
    }

    @Test
    public void testProxy() {
        ProxyConfiguration proxy = new ProxyConfiguration("127.0.0.1", 1080);
        Client c = new Client(null, false, proxy,
                Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT,
                Constants.DISPATCHER_MAX_REQUESTS, Constants.DISPATCHER_MAX_REQUESTS_PER_HOST,
                Constants.CONNECTION_POOL_MAX_IDLE_COUNT, Constants.CONNECTION_POOL_MAX_IDLE_MINUTES);
        Response r = null;
        try {
            r = c.post("http://www.baidu.com", new StringMap());
            Assert.fail();
        } catch (I2softException e) {
            Assert.assertNotNull(e.response);
            Assert.assertEquals(e.response.ret, 400);
        }
    }
}
