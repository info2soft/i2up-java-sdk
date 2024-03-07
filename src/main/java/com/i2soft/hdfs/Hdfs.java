package com.i2soft.hdfs;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Hdfs {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Hdfs(Auth auth) {
        this.auth = auth;
    }

    /**
     * hdfs同步 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHdfs(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * hdfs - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHdfs(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/hdfs/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * hdfs同步 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfs(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs同步 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHdfs(String uuid) throws I2softException {
        String url = String.format("%s/hdfs/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * hdfs同步 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHdfs(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs同步 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map tempFuncName(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs同步 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsStatus(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}