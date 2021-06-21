package com.i2soft.active;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

public abstract class Rule {
    public static final String STOP = "stop";
    public static final String RESUME = "resume";
    public static final String RESTART = "restart";

    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Rule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 同步规则-操作base
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateRule(StringMap args) throws I2softException {
        String url = String.format("%s/stream/rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 同步规则 - 操作base
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateRule(String uuid, StringMap args) throws I2softException {
        args.put("mysql_uuid", uuid);
        return this.operateRule(args);
    }

    /**
     * 同步规则 - 操作 - 停止
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException :
     */
    public I2Rs.I2SmpRs stopSyncRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", STOP);
        return operateRule(uuid, args);
    }

    /**
     * 同步规则 - 操作 - 继续
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resumeSyncRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", RESUME);
        return operateRule(uuid, args);
    }

    /**
     * 同步规则 - 操作 - 重启
     *s
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs restartSyncRule(String uuid, StringMap args) throws I2softException {
        args.put("operate", RESTART);
        return operateRule(uuid, args);
    }

}