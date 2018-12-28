package com.i2soft.system;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.IOHelper;
import com.i2soft.util.StringMap;

import java.io.File;
import java.util.Map;

public final class User {
    /**
     * Auth 对象
     */
    private final Auth auth;
    private String module_url;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public User(Auth auth) {
        this.auth = auth;
        this.module_url = auth.cc_url + "/user";
    }

    /**
     * 新建用户
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createUser(StringMap args) throws I2softException {
        args.fieldsRsa(new String[]{"password"});
        Response r = auth.client.post(module_url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取用户列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUser(StringMap args) throws I2softException {
        Response r = auth.client.get(module_url, args);
        return r.jsonToMap();
    }

    /**
     * 获取用户
     *
     * @param id: 用户id
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeUser(Integer id) throws I2softException {
        Response r = auth.client.get(String.format("%s/%s", module_url, id));
        return r.jsonToMap();
    }

    /**
     * 修改用户
     *
     * @param id:   用户id
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUser(Integer id, StringMap args) throws I2softException {
        args.fieldsRsa(new String[]{"password"});
        Response r = auth.client.put(String.format("%s/%s", module_url, id), args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除用户
     *
     * @param args: 用户id数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteUser(String[] args) throws I2softException {
        Response r = auth.client.delete(module_url, new StringMap().putNotEmpty("ids", args));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改用户密码
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUserPwd(StringMap args) throws I2softException {
        args.fieldsRsa(new String[]{"password", "old_password"});
        Response r = auth.client.post(String.format("%s/password", module_url), args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取用户简况
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listProfile() throws I2softException {
        Response r = auth.client.get(String.format("%s/profile", module_url));
        return r.jsonToMap();
    }

    /**
     * 修改用户简况
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyProfile(StringMap args) throws I2softException {
        Response r = auth.client.put(String.format("%s/profile", module_url), args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 退出登录
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs logout() throws I2softException {
        Response r = auth.client.post(String.format("%s/logout", module_url), new StringMap());
        IOHelper.deleteAllFilesOfDir(new File(auth.cachePath));
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}
