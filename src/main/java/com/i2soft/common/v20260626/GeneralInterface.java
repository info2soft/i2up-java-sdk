package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class GeneralInterface {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public GeneralInterface(Auth auth) {
        this.auth = auth;
    }

    /**
     * 版本信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVersion() throws I2softException {
        String url = String.format("%s/version", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 新版本信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map latestVersion(StringMap args) throws I2softException {
        String url = String.format("%s/check/latest_version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取版本提交记录
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVersionHistory() throws I2softException {
        String url = String.format("%s/version_history", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 连接测试
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs nodeConnectTest(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/node/connect_test", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 展示列 - 新建|修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createColumnExt(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/column_list", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 展示列 - 单个
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeColumnext(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/column_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 导出规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public byte[] exportRules(StringMap args) throws I2softException {
        String url = String.format("%s/export_rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 导入规则
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs importRules(StringMap args) throws I2softException {
        String url = String.format("%s/import_rules", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listStatisticsReport(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/statistics/report", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 签署CSR
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map csrSign(StringMap args) throws I2softException {
        String url = String.format("%s/pki/csr_sign", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 证书清单
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCerts() throws I2softException {
        String url = String.format("%s/pki/certs", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 下载根证书
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public byte[] downloadCa() throws I2softException {
        String url = String.format("%s/pki/download_ca", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.body();
    }

    /**
     * 异步rpc任务列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRpcTask() throws I2softException {
        String url = String.format("%s/rpc_task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 后台任务列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCronTask() throws I2softException {
        String url = String.format("%s/cron_task", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 后台任务删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCronTask(StringMap args) throws I2softException {
        String url = String.format("%s/cron_task", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 文件下载
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map dl(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/dl", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}