package com.i2soft.active;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Mask {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Mask(Auth auth) {
        this.auth = auth;
    }

    /**
     * 敏感类型列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTypes(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_type", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取总览列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummaryView(StringMap args) throws I2softException {
        String url = String.format("%s/mask/summary/list_view", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改敏感类型
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifySensType(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_type/:id", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个类型
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptSensType() throws I2softException {
        String url = String.format("%s/mask/sens_type/:id", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 新建脱敏算法
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAlgo(StringMap args) throws I2softException {
        String url = String.format("%s/mask/algo", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 脱敏算法列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAlgos(StringMap args) throws I2softException {
        String url = String.format("%s/mask/algo", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个算法
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptAlgo() throws I2softException {
        String url = String.format("%s/mask/algo/:id", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 脱敏规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMaskRules(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建脱敏规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createMaskRules(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 操作规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateMaskRule(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteMaskRule(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单条规则
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeMaskRule() throws I2softException {
        String url = String.format("%s/mask/rule/:id", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMaskRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个集合
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptMap() throws I2softException {
        String url = String.format("%s/mask/sens_db_map/:id", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 类型列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_map", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建集合
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_map", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改集合
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_map/:id", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除集合
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_map", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建数据库集合
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createDbMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_db_map", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 数据库集合列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDbMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_db_map", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除数据库集合
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteDbMap(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_db_map", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改数据库集合
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDbMap() throws I2softException {
        String url = String.format("%s/mask/sens_db_map", auth.cc_url);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建敏感发现任务
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createSensCheck(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改敏感发现任务
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifySensCheck(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check/:uuid", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除敏感发现任务
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteSensCheck(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check/delete", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取敏感发现列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSensCheck(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个任务详情
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map descriptSensCheck() throws I2softException {
        String url = String.format("%s/mask/sens_check/:uuid", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取任务状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSensCheckStatus(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSensCheckResult(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check/result/:uuid", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 忽略列
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listSensCheckIgnoreCol(StringMap args) throws I2softException {
        String url = String.format("%s/mask/sens_check/ignore_col", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 总览页面
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSummary() throws I2softException {
        String url = String.format("%s/mask/summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 算法测试
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs algoTest(StringMap args) throws I2softException {
        String url = String.format("%s/mask/algo/test", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改规则·
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyMaskRules(StringMap args) throws I2softException {
        String url = String.format("%s/mask/rule/:id", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}