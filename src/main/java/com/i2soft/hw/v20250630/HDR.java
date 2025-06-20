package com.i2soft.hw.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class HDR {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public HDR(Auth auth) {
        this.auth = auth;
    }

    /**
     * 系统设置 - 更新云平台配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateSetting(StringMap args) throws I2softException {
        String url = String.format("%s/sys/settings/", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * VDC管理员 - 保存云账户
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyProfile(StringMap args) throws I2softException {
        String url = String.format("%s/user/hcs_info", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * VDC管理员 - 查看当前登录用户信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listProfile() throws I2softException {
        String url = String.format("%s/user/profile/", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 获取操作日志用户列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getOpLogUsers() throws I2softException {
        String url = String.format("%s/user/op_log_user", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 统一许可 - 获取指定许可数据
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getLicenseData(StringMap args) throws I2softException {
        String url = String.format("%s/rest/license/data", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 统一许可 - 获取全部许可数据
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getLicenseItems() throws I2softException {
        String url = String.format("%s/rest/license/items", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 统一许可 - 获取许可数据描述
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getLicenseDescribe(StringMap args) throws I2softException {
        String url = String.format("%s/rest/license/describe", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 统一许可 - 获取许可文件
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getLicenseFiles() throws I2softException {
        String url = String.format("%s/rest/license/files", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 统一许可 - 更新许可文件
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateLicenseFile(StringMap args) throws I2softException {
        String url = String.format("%s/rest/license/file", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}