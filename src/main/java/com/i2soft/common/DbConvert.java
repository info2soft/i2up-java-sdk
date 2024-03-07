package com.i2soft.common;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DbConvert {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DbConvert(Auth auth) {
        this.auth = auth;
    }

    /**
     * 上传备份数据
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs dbConvertImport() throws I2softException {
        String url = String.format("%s/db_convert/import", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取convert列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map dbConvertListConverts(StringMap args) throws I2softException {
        String url = String.format("%s/db_convert/convert_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 执行迁移
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs dbConvertMigrate(StringMap args) throws I2softException {
        String url = String.format("%s/db_convert/migrate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}