package com.i2soft.system.v20181217;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Settings {
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
    public Settings(Auth auth) {
        this.auth = auth;
        this.module_url = auth.cc_url + "/sys/settings";
    }

    /**
     * 更新配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSetting(StringMap args) throws I2softException {
        args.fieldsRsa(new String[]{"email_pwd", "sms_password"});
        Response r = auth.client.post(module_url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取配置
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listSysSetting() throws I2softException {
        Response r = auth.client.get(module_url);
        return r.jsonToMap();
    }

    /**
     * 获取控制台主机IP
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCCip() throws I2softException {
        Response r = auth.client.get(String.format("%s/ips", module_url));
        return r.jsonToMap();
    }
}
