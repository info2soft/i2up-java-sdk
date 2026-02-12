package com.i2soft.recoveryRule.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BatchRecoveryRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BatchRecoveryRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 场景化恢复 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRestoreWizardRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] createRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 场景化恢复 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] modifyRestoreWizardRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.body();
    }

    /**
     * 场景化恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map regenerateRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map restoreRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRestoreWizardRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 场景化恢复 - 下载清单文件
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadRestoreWizardList(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 场景化恢复 - 查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRestoreWizardRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/restore_wizard/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}