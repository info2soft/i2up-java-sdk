package com.i2soft.ha.v20220622;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class AppHighAvailability {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public AppHighAvailability(Auth auth) {
        this.auth = auth;
    }

    /**
     * 高可用组 - 阶段选项
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStageOptions() throws I2softException {
        String url = String.format("%s/ha/group/stage_options", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 高可用组-新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createHAGroup(StringMap args) throws I2softException {
        String url = String.format("%s/ha/group", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHAGroup(StringMap args) throws I2softException {
        String url = String.format("%s/ha/group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHAGroup(StringMap args) throws I2softException {
        String url = String.format("%s/ha/group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHAGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 高可用组 - 单个详细信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHAGroup(String uuid) throws I2softException {
        String url = String.format("%s/ha/group/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 组强制切换
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map forceSwitchHAGroup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s/task", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 切换状态
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHASwitchTaskStatus(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s/task/status", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用组 - 操作强制切换任务
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs operateHASwitchTask(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s/task", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}