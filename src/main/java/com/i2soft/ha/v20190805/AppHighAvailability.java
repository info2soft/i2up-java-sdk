package com.i2soft.ha.v20190805;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
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
     * 高可用列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 操作：启动
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startHA(String[] uuids) throws I2softException {
        String url = String.format("%s/ha/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("ha_uuid", uuids).put("type", "start");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 操作：停止
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopHA(String[] uuids) throws I2softException {
        String url = String.format("%s/ha/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("ha_uuid", uuids).put("type", "stop");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 高可用 - 操作：强制切换
     *
     * @param uuids: uuid数组
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map forceSwitchHA(String[] uuids) throws I2softException {
        String url = String.format("%s/ha/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("ha_uuid", uuids).put("type", "force_switch");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToMap();
    }

    /**
     * 删除HA
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHAStatus(StringMap args) throws I2softException {
        String url = String.format("%s/ha/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * HA脚本目录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHAScriptPath(StringMap args) throws I2softException {
        String url = String.format("%s/ha/script_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 新建高可用-检查HA名称是否重复
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs haVerifyName(StringMap args) throws I2softException {
        String url = String.format("%s/ha/verify_name", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改高可用
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建高可用
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 节点网卡信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNicInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ha/netif", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查看HA详细信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHA(String uuid) throws I2softException {
        String url = String.format("%s/ha/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
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
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteHAGroup(StringMap args) throws I2softException {
        String url = String.format("%s/ha/group", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
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
    public I2Rs.I2SmpRs resumeHAGroupSwitch(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s/task", auth.cc_url, uuid);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuid", args.get("task_uuid").toString()).put("operate", "resume");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 高可用组 - 操作强制切换任务
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs pauseHAGroupSwitch(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/ha/group/%s/task", auth.cc_url, uuid);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuid", args.get("task_uuid").toString()).put("operate", "pause");
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}