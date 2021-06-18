package com.i2soft.common;

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
        String url = String.format("%s/sys/settings", auth.cc_url);
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
        String url = String.format("%s/sys/settings", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 系统设置-获取公开配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPublicSettings() throws I2softException {
        String url = String.format("%s/sys/public_settings", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 系统设置-控制台主机IP
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCCip() throws I2softException {
        String url = String.format("%s/sys/settings/ips", auth.cc_url);
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
     * 用户Profile(all user)-修改密码
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUserPwd(StringMap args) throws I2softException {
        String url = String.format("%s/user/password", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户Profile(all user)-获取用户Profile
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listProfile() throws I2softException {
        String url = String.format("%s/user/profile", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 用户Profile(all user)-修改Profile
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyProfile(StringMap args) throws I2softException {
        String url = String.format("%s/user/profile", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户Profile(all user)-退出登录
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs logout() throws I2softException {
        String url = String.format("%s/user/logout", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * AccessKey列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAk() throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * AccessKey新建
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createAk() throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * AccessKey更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * AccessKey删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.delete(url, args);
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
    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
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
     * 配置备份 - 备份历史操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
//    public I2Rs.I2SmpRs tempFuncName(StringMap args) throws I2softException {
//        String url = String.format("%s/cc/bak_history_operate", auth.cc_url);
//        Response r = auth.client.post(url, args);
//        return r.jsonToObject(I2Rs.I2SmpRs.class);
//    }
}