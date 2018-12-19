package com.i2soft.ha;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class AppHighAvailability {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public AppHighAvailability(Auth auth) {
        this.auth = auth;
    }

    /**
     * 高可用列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 操作接口
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map startHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 删除HA
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listHAStatus(StringMap args) throws I2softException {
        String url = String.format("%s/ha/status", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * HA脚本目录
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHAScriptPath(StringMap args) throws I2softException {
        String url = String.format("%s/ha/script_path", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 修改高可用
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 新建高可用
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createHA(StringMap args) throws I2softException {
        String url = String.format("%s/ha", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 节点网卡信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNicInfo(StringMap args) throws I2softException {
        String url = String.format("%s/ha/netif", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(Map.class);
    }

    /**
     * 查看HA详细信息
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeHA() throws I2softException {
        String url = String.format("%s/ha/:uuid([a-f-0-9] )", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToObject(Map.class);
    }
}