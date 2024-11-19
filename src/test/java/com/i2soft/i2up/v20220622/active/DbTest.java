package com.i2soft.i2up.v20220622.active;

import com.i2soft.active.v20220622.Db;
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.i2up.util.TestConfig;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DbTest {

    private static Auth auth;
    private static Db db;

    @BeforeClass
    public static void setUp() {
        if (db != null) {
            return;
        }
        try {
            auth = Auth.token(TestConfig.addr, TestConfig.user, TestConfig.pwd, TestConfig.cachePath, new Configuration());
        } catch (I2softException e) {
            e.printStackTrace();
        }
        db = new Db(auth);
    }

    @Test
    public void T2346_listDbRule() {
        try {
            Map rs = db.listDbRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2347_createDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2347")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = db.createDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2348_modifyDbRule() {
        try {
            I2Rs.I2SmpRs rs = db.modifyDbRule(); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2349_describeDbRule() {
        try {
            Map rs = db.describeDbRule(UUID.randomUUID().toString().toUpperCase()); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2350_deleteDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2350")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.deleteDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2351_stopDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "stop");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_restartDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "restart");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_start_analysisDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "start_analysis");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_stop_analysisDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "stop_analysis");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_reset_analysisDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "reset_analysis");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_stop_and_stopanalysisDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "stop_and_stopanalysis");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2351_stop_scheduleDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "stop_schedule");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void T2351_start_scheduleDbRule() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2351")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "resume");
            args.put("rule_uuid", UUID.randomUUID().toString().toUpperCase());
            I2Rs.I2SmpRs rs = db.operateDbRule(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2352_listDbRuleLog() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2352")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = db.listDbRuleLog(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2759_createDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2759")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = db.createDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2760_describeDb() {
        try {
            String uuid = UUID.randomUUID().toString().toUpperCase();
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2760")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.describeDb(uuid, args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2761_deleteDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2761")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = db.deleteDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2762_listDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2762")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.listDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2763_listDb() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2763")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.listDb(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2772_startCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2772")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "cmp_start");
            I2Rs.I2SmpRs rs = db.operateCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    public void T2772_stopCmp() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2772")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            args.put("operate", "cmp_stop");
            I2Rs.I2SmpRs rs = db.operateCmp(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2773_deleteCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2773")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            I2Rs.I2SmpRs rs = db.deleteCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2774_listCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2774")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.listCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2780_describeTbCmpResult() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2780")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.describeTbCmpResult(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2776_describeCmpErrorMsg() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2776")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.describeCmpErrorMsg(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void T2779_listCmpDiffMap() {
        try {
            Response r = auth.client.get(String.format(TestConfig.rapDataUrl, "2779")); // 获取请求数据
            StringMap args = new StringMap().putAll(Objects.requireNonNull(r.jsonToMap())); // 填充请求数据
            Map rs = db.listCmpDiffMap(args); // 发送请求
            Assert.assertNotNull(rs); // 检查结果
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}