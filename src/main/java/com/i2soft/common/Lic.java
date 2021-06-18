package com.i2soft.common;

import com.i2soft.http.I2Req;
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
     * 其他 - 获取激活所需信息（组激活，离线激活）
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
     * 其他 - 下载lic绑定信息、mac变更记录
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
     * 其他 - 获取控制机识别码
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
     * 其他 - 获取节点识别码
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
     * 其他 - 在线更新
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
     * Lic - 获取 lic 列表
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
     * Lic - 添加 lic
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Lic - 更新 lic（批量，离线）
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
     * Lic - 获取单个 lic
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
     * Lic-7 删除 lic
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
     * 绑定 - 获取许可绑的资源（许可管理）
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
     * 绑定 - 获取资源绑的许可（节点/VP管理）
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
     * 绑定 - 更新许可绑的资源（许可管理）
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
     * Obj - 获取 Obj 列表
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

    /**
     * CDM容量管理
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cdmCapacity() throws I2softException {
        String url = String.format("%s/lic/cdm_capacity", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }
}