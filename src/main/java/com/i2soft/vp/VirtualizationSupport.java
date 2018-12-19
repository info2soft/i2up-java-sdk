package com.i2soft.vp;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class VirtualizationSupport {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public VirtualizationSupport(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVp(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 编辑
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVp(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVp(StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 查询 虚机列表
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVM(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/vm", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 平台属性
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpAttribute(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/info", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 备机上备份列表（RC）1
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakVer(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/bak_ver", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 备份点信息/虚机配置信息（RC）2
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBakVerInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/bak_ver_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 数据存储下文件列表（RC）3
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastoreFile(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore_file", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 数据中心列表（MOVE/REP）1
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacenter(String uuid) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datacenter", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 数据中心主机列表 （MOVE/REP）2
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatacenterHost(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datacenter_host", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 存储列表 （MOVE/REP）3
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastore(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查询 存储信息 （MOVE/REP）4
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDatastoreInfo(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/platform/%s/datastore_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 修改（仅模板）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyVpBackup(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpBackup(String uuid) throws I2softException {
        String url = String.format("%s/vp/backup/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取单个（组）
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpBackupGroup(String uuid) throws I2softException {
        String url = String.format("%s/vp/backup/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 列表（组）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupGroup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/group", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpBackupStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 操作 启停
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName1(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpBackup(StringMap args) throws I2softException {
        String url = String.format("%s/vp/backup", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个（组）
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpRecoveryGroup(String uuid) throws I2softException {
        String url = String.format("%s/vp/recovery/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRecoveryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 操作 启停
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName2(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpRecovery(StringMap args) throws I2softException {
        String url = String.format("%s/vp/recovery", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpMove(StringMap args) throws I2softException {
        String url = String.format("%s/vp/(move|rep)", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpMove(String uuid) throws I2softException {
        String url = String.format("%s/vp/(move|rep)/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 修改（模板）
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVpMove(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vp/(move|rep)/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 获取列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpMove() throws I2softException {
        String url = String.format("%s/vp/(move|rep)", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpMoveStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vp/(move|rep)/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tempFuncName3(StringMap args) throws I2softException {
        String url = String.format("%s/vp/(move|rep)/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteVpMove(StringMap args) throws I2softException {
        String url = String.format("%s/vp/(move|rep)", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 获取快照列表信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpRepPointList(String uuid) throws I2softException {
        String url = String.format("%s/vp/rep/%s/point_list", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }
}