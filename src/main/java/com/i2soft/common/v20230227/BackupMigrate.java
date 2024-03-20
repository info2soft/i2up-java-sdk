package com.i2soft.common.v20230227;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BackupMigrate {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BackupMigrate(Auth auth) {
        this.auth = auth;
    }

    /**
     * 远程校验被迁移控制机状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map decribeCcMoveRemoteStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/check_remote_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取当前可迁移业务模块关系
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map decribeCcMoveModules() throws I2softException {
        String url = String.format("%s/cc_move/check_modules", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 配置迁移规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2CreateRs createCcMove(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2CreateRs.class);
    }

    /**
     * 配置迁移规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map decribeCcMoveStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置迁移规则 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCcMove(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 配置迁移规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteCcMove(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单表数据（控制机后端调用）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs decribeCcMoveTable(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/table", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置迁移规则 - 重新迁移
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs makeCcMoveRemigrate(StringMap args) throws I2softException {
        String url = String.format("%s/cc_move/remigrate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}