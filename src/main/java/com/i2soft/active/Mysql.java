package com.i2soft.active;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Mysql extends Rule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Mysql(Auth auth) {
        super(auth);
        this.auth = auth;
    }

    /**
     * mysql规则管理-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public I2Rs.I2CreateRs createMysqlRule(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2CreateRs.class);
    }

    /**
     * mysql规则管理-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteMysqlRules(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql同步规则-操作base
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateRule(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql同步规则 - 操作base
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateRule(String uuid, StringMap args) throws I2softException {
        args.put("mysql_uuid", uuid);
        return this.operateRule(args);
    }

    /**
     * mysql同步规则 - 操作 - 停止
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopMysqlRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", STOP);
        return operateRule(uuid, args);
    }

    /**
     * mysql同步规则 - 操作 - 继续
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeMysqlRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", RESUME);
        return operateRule(uuid, args);
    }

    /**
     * mysql同步规则 - 操作 - 重启
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartMysqlRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", RESTART);
        return operateRule(uuid, args);
    }

    /**
     * mysql规则管理-规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlRules(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listMysqlLog(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/log", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-同步状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamSyncStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/sync_status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-历史信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHistory(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/history", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-资源占用
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeResource(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/resouce", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql规则管理-修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyStreamRule(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql规则管理-获取单个信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeMysqlRule(String uuid) throws I2softException {
        String url = String.format("%s/stream/rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStreamCmp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createStreamCmp(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteStreamRules(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql-表比较-获取规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamCmps(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-状态接口
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStreamCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/stream/tb_cmp/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * mysql-表比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql-表比较-比较结果的查看
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql表比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTbCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-查看单条
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeStreamCmp(StringMap args) throws I2softException {
        String url = String.format("%s/stream/result_fix_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表比较-单条错误信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCmpErrorMsg(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/error_msg", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 比较结果列表的修复
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs listFixResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/result_fix_list", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 比较结果列表的导出
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs exportCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/export", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 历史结果中的修复
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCmpDiffMap(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/diff_map", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备机接管-查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBkTakeover(String uuid) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 备机接管-删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBkTakeover(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 备机接管-接管结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTakeoverResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/stream/bk_takeover/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 备机接管-获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTakeoverStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/bk_takeover/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 备机接管列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTakeoverList() throws I2softException {
        String url = String.format("%s/stream/bk_takeover", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * mysql-对象修复-新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 对象修复 - 获取单个
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjFix(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-对象修复 -删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-对象修复 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjFix(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象修复-操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/stream/obj_fix/operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }

    /**
     * 对象修复 - 修复结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjFixResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象修复--获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjFixStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_fix/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较-比较结果的删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs describeObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql对象比较 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjCmp(String uuid) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * mysql对象比较-比较结果时间列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpResultTimeList(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/result_time_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteObjCmp(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql对象比较 - 操作
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * mysql获取对象比较状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较-比较结果详细信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listObjCmpCmpInfo(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/cmp_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql对象比较-比较任务结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeObjCmpResult(StringMap args) throws I2softException {
        String url = String.format("%s/stream/obj_cmp/result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql-表修复-新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createStreamTableFix(StringMap args) throws I2softException {
        String url = String.format("%s/stream/tb_cmp/table_fix", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}