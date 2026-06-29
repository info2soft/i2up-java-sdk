package com.i2soft.stream.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class MigrateRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public MigrateRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 结构迁移 - 新建（参数与规则一致）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createMigrateRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/migrate_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}