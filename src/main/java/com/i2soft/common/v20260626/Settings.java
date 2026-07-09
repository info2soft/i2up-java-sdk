package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Settings {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Settings(Auth auth) {
        this.auth = auth;
    }

    /**
     * 系统设置-更新配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSetting(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 系统设置-获取配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSysSetting(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 系统设置-更新安全配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSecuritySetting(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/security_settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 系统设置-控制台主机IP
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCCip() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/ips", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 系统设置-获取公开配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPublicSettings() throws I2softException {
        String url = String.format("%s/vers/v3/sys/public_settings", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 系统设置-更新消息推送配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateNotifySetting(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/notify_settings", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 更新节点参数
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateNodeConf(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/node_conf", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取节点参数
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeConf() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/node_conf", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取拓扑备份服务器列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTopologyBackupServers() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/topology_backup_servers", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 设置拓扑备份服务器
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs setTopologyBackupServers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/topology_backup_servers", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取备份拓扑数据
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTopologyBackupServersData() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/topology_backup_servers_data", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 用户管理(admin)-新增用户
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createUser(StringMap args) throws I2softException {
        String url = String.format("%s/user", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 用户管理(admin)-用户列表(admin)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUser(StringMap args) throws I2softException {
        String url = String.format("%s/user", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 用户管理(admin)-获取用户
     *
     * @param id: id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUser(Integer id) throws I2softException {
        String url = String.format("%s/user/%s", auth.cc_url, id);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 用户管理(admin)-删除账户
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteUser(StringMap args) throws I2softException {
        String url = String.format("%s/user", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户管理 - 解除用户登录锁定
     *
     * @param uuid: uuid
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs clearLoginAttempt(String uuid) throws I2softException {
        String url = String.format("%s/user/%s/clear_login_attempt", auth.cc_url, uuid);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户管理(admin)-修改用户信息
     *
     * @param id: id
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUser(Integer id, StringMap args) throws I2softException {
        String url = String.format("%s/user/%s", auth.cc_url, id);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户 - 手机号/邮箱 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUserEmailOrMobile(StringMap args) throws I2softException {
        String url = String.format("%s/user/email_mobile", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 角色管理 - 角色列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRole(StringMap args) throws I2softException {
        String url = String.format("%s/role", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNpsvr(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr获取单个
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNpsvr(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyNpsvr(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * npsvr删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteNpsvr(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * npsvr状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNpsvrStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr 备份历史列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNpsvrBakList(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr_bak_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr 备份历史操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs recoveryNpsvrBak(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * npsvr 备份历史操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteNpsvrBak(StringMap args) throws I2softException {
        String url = String.format("%s/cc/npsvr_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置备份 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakConfig(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_config_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置备份 - 单个
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBakConfig(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_config", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置备份 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBakConfig(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_config", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置备份 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBakConfig(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_config", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置备份 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakConfigStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_config_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置备份 - 获取备份历史列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakHistory(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_history_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置备份-导入
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] importConfig(StringMap args) throws I2softException {
        String url = String.format("%s/cc/import", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }

    /**
     * 配置备份-导出
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportConfig() throws I2softException {
        String url = String.format("%s/cc/export", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.body();
    }

    /**
     * 配置备份 - 备份历史操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs recoveryBakConfigInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_history_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置备份 - 备份历史操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBakConfigInfo(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_history_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置备份 - 获取Ctrl备份配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCtrlBakSetting() throws I2softException {
        String url = String.format("%s/cc/bak_setting", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 配置备份 - 修改Ctrl备份配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCtrlBakSetting(StringMap args) throws I2softException {
        String url = String.format("%s/cc/bak_setting", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 查看音频文件
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDownloadCustomAudio() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/custom_audio_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 上传音频文件
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs uploadDownloadCustomAudio(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/custom_audio", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除音频文件
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteDownloadCustomAudio(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/custom_audio", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 下载音频文件
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadCustomAudio() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/custom_audio", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * 错误代码 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listErrorCode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cc/error_code", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * VP - 是否允许同时添加到备份、复制规则当中
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map vpAllowDifferentRules() throws I2softException {
        String url = String.format("%s/vers/v3/sys/settings/vp_allow_different_rules", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}