package com.i2soft.remoteRep.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RemoteRep {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RemoteRep(Auth auth) {
        this.auth = auth;
    }

    /**
     * 远程复制 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyRemoteRep(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 远程复制 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRemoteRep(String uuid) throws I2softException {
        String url = String.format("%s/remote_rep/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startImmediatelyRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRemoteRep(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程复制 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRemoteRepStatus(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 根据存储池获取规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStoragePoolRuleList(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/storage_pool_rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 根据存储池获取文件系统列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFileSystem(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/file_system", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取（远程）复制卷的副本卷
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFirstCloneVolume(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/mount_task", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取（二级）副本卷
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCloneVolume(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/clone_volume", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 根据备份规则过滤存储节点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map filterStorageNode(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/filter_storage", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 远程恢复 - 文件合成备份还原时间点
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listFileSnapshot(StringMap args) throws I2softException {
        String url = String.format("%s/remote_rep/file_snapshot_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}