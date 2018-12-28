package test.com.i2soft.util;

import com.i2soft.util.IOHelper;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class IOHelperTest {

    @Test
    public void saveTest() {
        try {
            IOHelper.saveFile(new File("E:\\aa\\Test.txt"), "1234");
            Assert.assertNotNull("111");

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void readTest() {
        try {
            String rs = IOHelper.readFile(new File("E:\\aa\\Test.txt"));
            System.out.println(rs);
            Assert.assertNotNull(rs);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void delTest() {
        Assert.assertTrue(IOHelper.deleteAllFilesOfDir(new File("E:\\aa\\")));
    }


    @Test
    public void saveJsonTest() {
        try {
            IOHelper.saveJsonFile(new File("E:\\aa\\Test.txt"), new StringMap().put("key", "val"));
            Assert.assertNotNull("111");

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void readJsonTest() {
        try {
            StringMap rs = IOHelper.readJsonFile(new File("E:\\aa\\Test.txt"));
            System.out.println(rs);
            Assert.assertNotNull(rs);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}