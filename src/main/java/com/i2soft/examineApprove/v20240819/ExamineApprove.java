package com.i2soft.examineApprove.v20240819;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class ExamineApprove {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public ExamineApprove(Auth auth) {
        this.auth = auth;
    }

    /**
     * 审批 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 审批 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map approveExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map enableExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map receiptExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteExamineApprove(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 审批人列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listExamineApproveApproverList() throws I2softException {
        String url = String.format("%s/examine_approve/approver_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 审批 - 新建 - 文件上传
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs examineApproveImport(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/import", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 审批 - 查看文件信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listExamineApproveFileInfo(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/file_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 审批 - 文件下载
     *
     * @param args: 参数详见 API 手册
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] examineApproveDownlowdFile(StringMap args) throws I2softException {
        String url = String.format("%s/examine_approve/download", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.body();
    }
}