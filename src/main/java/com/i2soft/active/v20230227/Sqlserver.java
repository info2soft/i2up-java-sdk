package com.i2soft.active.v20230227;


import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Sqlserver {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Sqlserver(Auth auth) {
        this.auth = auth;
    }

    /**
     * sqlser同步规则-增量失败DML统计
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesDML(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/incre_dml_summary", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * sql规则-已同步的对象具体信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesObjInfo(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/sync_obj_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 批量新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchCreateRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/batch_add", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeSqlserverRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 状态获取
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 批量新建时重名检查
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs checkName() throws I2softException {
        String url = String.format("%s/sqlserver/rule/check_name", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRule(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则-日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleLog(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个规则
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeListRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 同步规则-失败的对象
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSyncRulesFailObj(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/rule/fail_obj", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 状态接口
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较 历史结果查看表比较时间结果集
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTbCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopTbCmp(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeTbCmpResuluTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 表比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-错误信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpErrorMsg(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/error_msg", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 表比较-比较结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/sqlserver/tb_cmp/cmp_result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}