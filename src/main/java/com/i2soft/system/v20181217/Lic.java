package com.i2soft.system.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Lic {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Lic(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1 获取激活所需信息（组激活，离线激活）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeActivateInfo(StringMap args) throws I2softException {
        String url = String.format("%s/lic/activate", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 下载lic绑定信息、mac变更记录
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map downloadLicInfo(String uuid) throws I2softException {
        String url = String.format("%s/lic/%s/download_lic_info", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 3 获取控制机识别码
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLicCcHwCode() throws I2softException {
        String url = String.format("%s/lic/cc_hw_code", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 4 获取节点识别码
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLicObjHwCode(StringMap args) throws I2softException {
        String url = String.format("%s/lic/obj_hw_code", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 5 在线激活（激活所有许可并更新，页面下端）
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map activateLicAll() throws I2softException {
        String url = String.format("%s/lic/activate", auth.cc_url);
        Response r = auth.client.put(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 1 添加 lic
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 更新 lic
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateLic(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/lic/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 更新 lic（批量，离线）
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateBatchLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic/batch", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 5 获取单个 lic
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeLic(String uuid) throws I2softException {
        String url = String.format("%s/lic/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 6 获取 lic 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 7 删除 lic
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2 获取 Lic 绑定情况 列表（节点/VP管理）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicObjBind(StringMap args) throws I2softException {
        String url = String.format("%s/lic/obj_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2 获取 Lic 绑定情况 列表（许可管理）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicBind(StringMap args) throws I2softException {
        String url = String.format("%s/lic/lic_bind", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 更新绑定（许可管理）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map updateLicBind(StringMap args) throws I2softException {
        String url = String.format("%s/lic/lic_bind", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 1 获取 Obj 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicObj(StringMap args) throws I2softException {
        String url = String.format("%s/lic/obj", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}