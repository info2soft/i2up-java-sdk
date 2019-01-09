package com.i2soft.common.v20181217;

import com.i2soft.common.Auth;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Storage {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Storage(Auth auth) {
        this.auth = auth;
    }

    /**
     * storage_list
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public Map listStorageInfo(StringMap args) throws I2softException {
        String url = String.format("%s/storage", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}