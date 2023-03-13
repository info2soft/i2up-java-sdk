package com.i2soft.i2up.v20230227.resource;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.resource.v20230227.ContainerCluster;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import com.i2soft.i2up.util.TestConfig;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContainerClusterTest {

    private static Auth auth;
    private static ContainerCluster containerCluster;

    @BeforeClass
    public static void setUp() {
        if (containerCluster != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.ip, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        containerCluster = new ContainerCluster(auth);
    }

    @Test
    public void T3731_createBackupDestination() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3731")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.createBackupDestination(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3732_listBackupDestination() {
        try {
            Map rs = containerCluster.listBackupDestination(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3733_descibeBackupDestination() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = containerCluster.descibeBackupDestination(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3734_modifyBackupDestination() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3734")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.modifyBackupDestination(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3735_deleteBackupDestination() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3735")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.deleteBackupDestination(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3769_listBackupDestinationStatus() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3769")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.listBackupDestinationStatus(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3747_listContainerClusterInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3747")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.listContainerClusterInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3999_syncContainerClusterInfo() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3999")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.syncContainerClusterInfo(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4014_listContainerClusterResource() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4014")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.listContainerClusterResource(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4023_listContainerClsNamespace() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4023")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.listContainerClsNamespace(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4017_containerClusterMonitoringOverview() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "4017")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.containerClusterMonitoringOverview(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T4018_containerClusterMonitoringNode() {
        try {
            I2Rs.I2SmpRs rs = containerCluster.containerClusterMonitoringNode(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3736_createContainerCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3736")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.createContainerCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3737_listContainerCluster() {
        try {
            Map rs = containerCluster.listContainerCluster(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3738_describeContainerCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = containerCluster.describeContainerCluster(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3739_modifyContainerCluster() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3739")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.modifyContainerCluster(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3740_deleteContainerCluster() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3740")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.deleteContainerCluster(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3741_createCallbackSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3741")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.createCallbackSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3742_listCallbackSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3742")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.listCallbackSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3743_describeCallbackSettings() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Map rs = containerCluster.describeCallbackSettings(uuid); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3744_modifyCallbackSettings() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3744")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.modifyCallbackSettings(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3745_deleteCallbackSettings() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3745")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.deleteCallbackSettings(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3784_tempFuncName() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3784")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = containerCluster.tempFuncName(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T3799_verifyCallbackSettingsPod() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "3799")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = containerCluster.verifyCallbackSettingsPod(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}