package com.i2soft.common.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class UserSettings {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public UserSettings(Auth auth) {
        this.auth = auth;
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
     * 用户修改个人资料
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
     * 用户修改消息推送地址
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUserNotifyAddr(StringMap args) throws I2softException {
        String url = String.format("%s/user/notify_addr", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户Profile(all user)-退出登录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map logout(StringMap args) throws I2softException {
        String url = String.format("%s/user/logout", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 2FA - 当前信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTwoFactor() throws I2softException {
        String url = String.format("%s/2fa", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2FA - 获取绑定信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeOtp() throws I2softException {
        String url = String.format("%s/2fa/otp", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2FA - 生成新恢复码
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map renewRecoveryCode() throws I2softException {
        String url = String.format("%s/2fa/recovery_code", auth.cc_url);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 2FA - 配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map configTwoFactor(StringMap args) throws I2softException {
        String url = String.format("%s/2fa", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * AccessKey列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * AccessKey新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createAk(StringMap args) throws I2softException {
        String url = String.format("%s/ak", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
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
}