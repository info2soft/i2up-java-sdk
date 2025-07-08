package com.i2soft.cdm.v20250630;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class CdmRule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public CdmRule(Auth auth) {
        this.auth = auth;
    }

    /**
     * 接管/演练 --- 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map takeOverDrillList(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createTakeOverDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTakeOverDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTakeOverDrill(String uuid) throws I2softException {
        String url = String.format("%s/cdm_rule/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 获取虚机状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getVmStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule/vm_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startTakeOverDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopTakeOverDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 接管/演练 --- 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map openConsoleTakeOverDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_rule/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}