package com.i2soft.vpBackupRule.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class VpBackupRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public VpBackupRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVpBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule", auth.cc_url);
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
    public I2Rs.I2SmpRs modifyVpBackupRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 批量设置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchModifyVpBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/batch_update", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpBackupRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVpBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule", auth.cc_url);
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
    public Map operateVpBackupRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 将虚机加入到规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map taskAddVms(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/task_add_vms", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 虚拟化备份 - 新建/修改前置校验
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] preCheckVpBackupRule() throws I2softException {
        String url = String.format("%s/vers/v3/vp/backup_rule/pre_check", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.body();
    }
}