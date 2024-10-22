package com.i2soft.dto.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class DtoArchive {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public DtoArchive(Auth auth) {
        this.auth = auth;
    }

    /**
     * 归档数据管理 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtoArchive(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 归档数据管理 - 导出
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] exportDtoArchiveData(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/export", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 归档数据管理 - 获取年份
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs getDtoArchiveYear() throws I2softException {
        String url = String.format("%s/dto/archive/archive_year", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 归档数据管理 - 下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] downloadDtoArchiveData(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }

    /**
     * 归档数据管理 - 解冻
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map restoreDtoArchiveData(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/restore", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 归档数据管理统计 - 规则新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createDtoArchiveReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 归档数据管理统计 - 规则修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyDtoArchiveReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_rule", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 归档数据管理统计 - 规则查看
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeDtoArchiveReportRule(String uuid) throws I2softException {
        String url = String.format("%s/dto/archive/report_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 归档数据管理统计 - 规则删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDtoArchiveReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_rule/", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 归档数据管理统计 - 规则列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtoArchiveReportRule(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 归档数据管理统计 - 导出历史
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtoArchiveReportHistory(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_history", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 归档数据管理统计 - 统计报表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDtoArchiveReportStatistics(StringMap args) throws I2softException {
        String url = String.format("%s/dto/archive/report_statistics", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}