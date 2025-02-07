package com.i2soft.hdfs.v20250123;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
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
     * 大数据平台 - 总览
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map hdfsSummary() throws I2softException {
        String url = String.format("%s/hdfs/summary", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
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
     * hdfs同步 - 修改
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
    public Map startHdfs(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs同步 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopHdfs(StringMap args) throws I2softException {
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

    /**
     * hdfs差异比较 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHdfsCompare(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * hdfs差异比较 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHdfsCompare(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * hdfs差异比较 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsCompare(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs差异比较 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHdfsCompare(String uuid) throws I2softException {
        String url = String.format("%s/hdfs_compare/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * hdfs差异比较 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHdfsCompare(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs差异比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startHdfsCompare(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs差异比较 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopHdfsCompare(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs差异比较 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsCompareStatus(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 差异比较 - 获取历史记录列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsCompareHistory(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/list_compare_history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 差异比较 - 获取单个历史记录详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHdfsCompareHistory(String uuid) throws I2softException {
        String url = String.format("%s/hdfs_compare/%s/compare_history", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 差异比较 - 删除比较结果历史记录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteHdfsCompareHistory(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/compare_history", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 差异比较 - 获取比较结果列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsCompareResult(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/list_compare_result", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 差异比较 - 获取比较结果详情列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHdfsCompareResultDetail(StringMap args) throws I2softException {
        String url = String.format("%s/hdfs_compare/list_compare_result_detail", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}