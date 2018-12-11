package test.com.i2soft.res;

import com.i2soft.common.Configuration;
import com.i2soft.common.I2Req;
import com.i2soft.common.I2softException;
import com.i2soft.res.NodeMgr;
import com.i2soft.res.ResResult;
import com.i2soft.util.Auth;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import test.com.i2soft.util.TestConfig;

public class NodeMgrTest {

    private Auth auth;
    private NodeMgr nodeMgr;

    @Before
    public void setUp() {
        try {
            this.auth = Auth.create(TestConfig.ip, TestConfig.user, TestConfig.pwd, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        this.nodeMgr = new NodeMgr(auth);
    }

    @Test
    public void nodeList() {
        I2Req.ListArgs args = new I2Req.ListArgs();
        args.limit = 1;

        try {
            ResResult.NodeList nodeList = nodeMgr.getList(args);
            Assert.assertNotNull(nodeList);
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
