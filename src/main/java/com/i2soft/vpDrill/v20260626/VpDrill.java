package com.i2soft.vpDrill.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class VpDrill {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public VpDrill(Auth auth) {
        this.auth = auth;
    }

    /**
     * 演练 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createVpDrillRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 演练 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyVpDrillRule(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练 - 获取详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpDrillRule(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 演练 - 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpDrillRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map operateVpDrillRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteVpDrillRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpDrillRuleStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练 - 新建/修改前置校验
     *
     * @return 二进制文件
     * @throws I2softException:
     */
    public byte[] preCheckVpDrillRule() throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_rule/pre_check", auth.cc_url);
        Response r = auth.client.post(url, new StringMap());
        return r.body();
    }

    /**
     * 副本管理 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpDrillInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 副本管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map operateVpDrillinfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_info/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 副本管理 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listVpDrillInfoStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_info/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 副本管理 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map delVpDrillRule(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/vp/drill_info", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}