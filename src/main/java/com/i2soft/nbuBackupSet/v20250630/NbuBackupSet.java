package com.i2soft.nbuBackupSet.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class NbuBackupSet {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public NbuBackupSet(Auth auth) {
        this.auth = auth;
    }

    /**
     * NBU转储结果 - 历史结果
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBackupWork(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/nbu_backup_set/history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * NBU转储结果 - 获取列表查询候选信息副本
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listQueryArgsNbuBackupSet(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/nbu_backup_set/query_args", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}