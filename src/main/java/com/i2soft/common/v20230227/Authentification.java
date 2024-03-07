package com.i2soft.common.v20230227;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Authentification {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Authentification(Auth auth) {
        this.auth = auth;
    }

    /**
     * 短信-1.时间戳
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimeStamp(StringMap args) throws I2softException {
        String url = String.format("%s/auth/t", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 短信-2.生成短信、邮件、图片验证码关联信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authGenerate() throws I2softException {
        String url = String.format("%s/auth/generate", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * auth-获取手机、邮件、图片验证码
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVerificationCode(StringMap args) throws I2softException {
        String url = String.format("%s/auth/verification_code", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * auth-检查用户是否需要验证码
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkCaptcha(StringMap args) throws I2softException {
        String url = String.format("%s/auth/check_captcha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * auth-获取token
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map token(StringMap args) throws I2softException {
        String url = String.format("%s/auth/token", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * auth-重置密码
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resetPwd() throws I2softException {
        String url = String.format("%s/auth/reset_password", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-check用户登录状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkLoginStatus(StringMap args) throws I2softException {
        String url = String.format("%s/auth/token", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * auth-注册账号(不开放)
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs regAccount() throws I2softException {
        String url = String.format("%s/auth/register", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-是否超时或账号失效
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs heartbeat(StringMap args) throws I2softException {
        String url = String.format("%s/auth/heartbeat", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * auth-公钥处理
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs encryKey(StringMap args) throws I2softException {
        String url = String.format("%s/auth/encry_key", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}