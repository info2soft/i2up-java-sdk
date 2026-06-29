package com.i2soft.active.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ExportImport {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ExportImport(Auth auth) {
        this.auth = auth;
    }

    /**
     * 数据库同步 - 规则导入
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map batchImportActiveRules(StringMap args) throws I2softException {
        String url = String.format("%s/active/rule/import", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}