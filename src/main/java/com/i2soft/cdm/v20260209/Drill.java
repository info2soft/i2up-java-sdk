package com.i2soft.cdm.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Drill {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Drill(Auth auth) {
        this.auth = auth;
    }

    /**
     * 自动演练规则 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createCdmDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 获取单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCdmDrill(String uuid) throws I2softException {
        String url = String.format("%s/cdm_drill/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 获取组
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCdmDrillGroup(String uuid) throws I2softException {
        String url = String.format("%s/cdm_drill/%s/group", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCdmDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stopCdmDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startCdmDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map setStatusCdmDrill(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCdmDrillStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 自动演练规则 - 获取虚机状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map queryGroupVmStatus(StringMap args) throws I2softException {
        String url = String.format("%s/cdm_drill/vm_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}