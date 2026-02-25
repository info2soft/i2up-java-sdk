package com.i2soft.common.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Logs {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Logs(Auth auth) {
        this.auth = auth;
    }

    /**
     * i2node日志-规则/任务日志（uuid）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTaskLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * i2node日志-HA日志
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHaLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * i2node日志-节点日志（m_uuid）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNodeLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/node", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * npsvr日志-任务日志
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] listNpsvrLog() throws I2softException {
        String url = String.format("%s/logs/npsvr", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * traffic日志-logs.traffic
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTrafficLog(StringMap args) throws I2softException {
        String url = String.format("%s/logs/traffic", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * logserver-上传统计报表
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs collectStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/collect_statistics", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 在线日志 - 获取规则/任务关联资源列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listResList(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/los/list_res_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 在线日志 - 获取文件列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map onlineListFiles(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/logs/online_list_files", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 在线日志 - 获取日志内容
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map onlineGetContent(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/logs/online_content", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 在线日志 - 下载日志文件
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] onlineDownloadFile(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/logs/online_download_file", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.body();
    }
}