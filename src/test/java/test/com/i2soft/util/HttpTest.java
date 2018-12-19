package test.com.i2soft.util;

import com.i2soft.util.Configuration;
import com.i2soft.util.Constants;
import com.i2soft.http.I2softException;
import com.i2soft.http.Client;
import com.i2soft.http.ProxyConfiguration;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class HttpTest {
    private Client client;

    @Before
    public void setUp() {
        this.client = new Client(TestConfig.ip, new Configuration());
    }

    /**
     * 报错测试
     */
    @Test
    public void testDummyGet() {
        Response r;
        try {
            client.get(String.format("%s/test/dummy_get", client.cc_url));
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    /**
     * 入参和返回data内容一致即正常
     */
    @Test
    public void testGet1() {
        Response r;
        try {
            StringMap query = new StringMap();

            query.put("foo", "bar"); // str -> str
            query.put("hallo", new String[]{"a", "b", "c"}); // str -> str[]
            query.put("type", new Integer[]{2, 5, 0}); // str -> int[]
            query.put("search", new StringMap().put("name", "John").put("age", 6)); // str -> map

            r = client.get(String.format("%s/test/get", client.cc_url), query);
            System.out.println(r.bodyString());

            r = client.post(String.format("%s/test/post", client.cc_url), query);
            System.out.println(r.bodyString());

            r = client.put(String.format("%s/test/put", client.cc_url), query);
            System.out.println(r.bodyString());

            r = client.delete(String.format("%s/test/delete", client.cc_url), query);
            System.out.println(r.bodyString());

            Assert.assertNotNull(r);

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost1() {
        Response r;
        try {
            r = client.post("http://www.baidu.com", new StringMap());
            Assert.assertNotNull(r);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost3() {
        Response r = null;
        try {
            r = client.post("http://httpbin.org/status/500", new StringMap());
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
            r = client.post("http://httpbin.org/status/418", new StringMap());
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
        Response r;
        try {
            r = client.post("http://httpbin.org/status/298", new StringMap());
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
        Client c = new Client(null, null, false, proxy,
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
