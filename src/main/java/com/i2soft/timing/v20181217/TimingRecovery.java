package com.i2soft.timing.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class TimingRecovery {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public TimingRecovery(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 恢复 准备-2 恢复 获取还原时间点 - Mssql
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryMssqlTime(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_mssql_time", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 恢复 准备-3 恢复 获取Mssql初始信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingRecoveryMssqlInitInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_mssql_init_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 恢复 准备-1 恢复 获取还原时间点 - 文件
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryPathList(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_path_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 恢复 准备-4 恢复 认证MsSql数据库
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs verifyTimingRecoveryMssqlInfo(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/rc_verify_mssql_info", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 恢复 新建/编辑-1 恢复 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 恢复 新建/编辑-3 恢复 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTimingRecovery(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 恢复 新建/编辑-2 恢复 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTimingRecovery(String uuid) throws I2softException {
        String url = String.format("%s/timing/recovery/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 3 恢复 列表-1 恢复 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 恢复 列表-2 恢复 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTimingRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3 恢复 列表-3 恢复 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTimingRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/timing/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时备份恢复 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs startTimingRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/timing/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 定时备份恢复 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs stopTimingRecovery(String[] uuids) throws I2softException {
        String url = String.format("%s/timing/recovery/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}