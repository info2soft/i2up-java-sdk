package test.com.i2soft.res;

import com.i2soft.util.Configuration;
import com.i2soft.http.I2Req;
import com.i2soft.http.I2softException;
import com.i2soft.resource.Node;
import com.i2soft.resource.ResRs;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;
import org.junit.*;
import org.junit.runners.MethodSorters;
import test.com.i2soft.util.TestConfig;

import java.util.Map;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NodeTest {

    private static Auth auth;
    private static Node node;

    @BeforeClass
    public static void setUp() {
        if (node != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        node = new Node(auth);
    }

    @Test
    public void T1_nodeList() {
        try {
            I2Req.ListArgs args = new I2Req.ListArgs();
            args.limit = 1;
            ResRs.NodeList nodeList = node.listNode(args);
            Assert.assertNotNull(nodeList);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2_checkCapacity() {
        StringMap args = new StringMap()
                .put("config_addr", "192.168.72.76")
                .put("config_port", "26821")
                .put("cache_path", "C:\\Program Files (x86)\\info2soft-i2node\\cache\\");
        try {
            Map rs = node.checkCapacity(args);
            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3_getVgList() {

        try {
            Map rs = node.listVg(new StringMap()
                    .put("config_addr", "192.168.72.76")
                    .put("config_port", "26821"));

            Assert.assertNotNull(rs);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
