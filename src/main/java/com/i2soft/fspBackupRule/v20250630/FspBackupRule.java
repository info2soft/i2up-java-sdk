package com.i2soft.fspBackupRule.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class FspBackupRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public FspBackupRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 整机备份 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机备份 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeFspBackupRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyFspBackupRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机备份 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 整机备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map enableFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map disableFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map manualStartFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cloneFspBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 整机备份 - 获取节点设备列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFspBackupDeviceInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/fsp/backup_rule/device_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}