package com.i2soft.recoveryRule.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RecoveryRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RecoveryRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyRecoveryRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopRecoveryRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个详情
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRecoveryRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRecoveryRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件恢复 获取目录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDir(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/dir", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件恢复 获取目录（post方法防止特殊字符路径转义错误）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDirPost(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/dir", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Oracle 获取参数文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSbtContrlFile(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/sbt_contrlfile", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Oracle 获取恢复点日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryOracleRcPointInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/rc_sbt", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Oracle 获取DBID
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeSbtDbid(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/sbt_dbid", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 验证备份介质 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVerifyBackupMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/verify_backup_media", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取备份服务器备选地址
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getRecoveryBkServerAddr(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/get_bk_server_addr", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取覆盖指定时间点的日志备份集
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCoveringLogBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_rule/covering_log_backup_set", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}