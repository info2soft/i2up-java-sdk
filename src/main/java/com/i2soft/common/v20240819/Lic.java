package com.i2soft.common.v20240819;

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
     * CDM容量管理
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map cdmCapacity(StringMap args) throws I2softException {
        String url = String.format("%s/lic/cdm_capacity", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Lic - 退订操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map unsubscribeLic(StringMap args) throws I2softException {
        String url = String.format("%s/lic/unsubscribe", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * hdfs容量管理
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map hdfsCapacity() throws I2softException {
        String url = String.format("%s/lic/hdfs_capacity", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Lic - 即将过期提示许可列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNearExpirationLicenses() throws I2softException {
        String url = String.format("%s/lic/list_near_expiration", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Lic - 更新许可 单个
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
     * VP许可授权详情
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeVpAuthDetail(StringMap args) throws I2softException {
        String url = String.format("%s/lic/vp_auth_detail", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * LIC - 获取节点列表（sysadmin角色下无用户权限过滤）
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getNodeListForLicense() throws I2softException {
        String url = String.format("%s/lic/node_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Backup9授权详情
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicBackupAuthDetail(StringMap args) throws I2softException {
        String url = String.format("%s/lic/backup9_auth_detail", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 消息 - 许可消息弹窗
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listLicAlert() throws I2softException {
        String url = String.format("%s/lic/list_alert", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 许可弹窗消息 - 不再提醒
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs avoidAlert(StringMap args) throws I2softException {
        String url = String.format("%s/lic/forbid_alert", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}