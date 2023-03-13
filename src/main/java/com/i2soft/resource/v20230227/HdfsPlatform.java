package com.i2soft.resource.v20230227;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class HdfsPlatform {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public HdfsPlatform(Auth auth) {
        this.auth = auth;
    }

    /**
     * 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHdfsPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHdfsPlatform(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHdfsPlatform(String uuid) throws I2softException {
        String url = String.format("%s/hdfs_platform/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHdfsPlatform(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取同步路径
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsPath(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform/hdfs_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取hive资源（数据库，表）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsHiveEntity(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_platform/hive_entity", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}