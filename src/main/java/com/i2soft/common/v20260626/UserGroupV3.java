package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class UserGroupV3 {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public UserGroupV3(Auth auth) {
        this.auth = auth;
    }

    /**
     * 用户组 - 修改授权绑定
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyUserGroupResBind(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/user_group/res_bind", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 用户组 - 获取授权绑定关系
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listUserGroupResBind(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/user_group/res_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}