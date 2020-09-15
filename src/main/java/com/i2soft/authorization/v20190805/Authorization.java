package com.i2soft.authorization;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Authorization {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Authorization(Auth auth) {
        this.auth = auth;
    }

    /**
     * 资源授权 - 用户列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/authorization/user", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 资源授权 - 用户授权情况
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getAuthorizationUserBind(StringMap args) throws I2softException {
        String url = String.format("%s/authorization/user_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 资源授权 - 更新用户授权
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateAuthorizationUserBind(StringMap args) throws I2softException {
        String url = String.format("%s/authorization/user_bind", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 资源授权 - 资源授权情况
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getAuthorizationResBind(StringMap args) throws I2softException {
        String url = String.format("%s/authorization/res_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 资源授权 - 更新资源授权
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateAuthorizationResBind(StringMap args) throws I2softException {
        String url = String.format("%s/authorization/res_bind", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}