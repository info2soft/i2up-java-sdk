package test.com.i2soft.res;

import com.i2soft.common.Configuration;
import com.i2soft.common.I2softException;
import com.i2soft.res.NodeMgr;
import com.i2soft.res.ResResult;
import com.i2soft.util.Auth;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.com.i2soft.util.TestConfig;

public class NodeMgrTest {

    private Configuration cfg;
    private Auth auth;
    private NodeMgr nodeMgr;

    @Before
    public void setUp() {
        this.cfg = new Configuration();
        try {
            this.auth = Auth.create(TestConfig.ip, TestConfig.user, TestConfig.pwd, this.cfg);
        } catch (I2softException e) {
            e.printStackTrace();
        }
        this.nodeMgr = new NodeMgr(auth);
    }

    @Test
    public void nodeList() {
        try {
            ResResult.NodeList nodeList = nodeMgr.getList();
            Assert.assertNotNull(nodeList);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
