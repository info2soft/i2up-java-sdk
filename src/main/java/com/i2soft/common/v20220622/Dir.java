package com.i2soft.common.v20220622;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Dir {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Dir(Auth auth) {
        this.auth = auth;
    }

    /**
     * 目录 - 列举（子）目录（节点已注册）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 列举（子）目录（节点未注册）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDir2(StringMap args) throws I2softException {
        String url = String.format("%s/dir2", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 创建目录
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 目录 - 检查路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map checkDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir/check", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 删除文件/路径（DTO云存储）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 删除的结果（DTO云存储）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDirDelStatus(StringMap args) throws I2softException {
        String url = String.format("%s/dir/del_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 备份卷路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listEtcdDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir/etcd_dir", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 目录 - 操作（DTO云存储）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map operateDtoDir(StringMap args) throws I2softException {
        String url = String.format("%s/dir/dto_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}