package com.i2soft.recoveryDrill.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RecoveryDrill {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RecoveryDrill(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 恢复演练 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map createRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则-获取详情
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRecoveryDrill(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyRecoveryDrill(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 获取状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRecoveryDrillStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map enableRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map disableRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练规则 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map manualDrillRecoveryDrill(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/recovery_drill/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练副本-列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDrillInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/drill_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练副本-操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map operateDrillInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/drill_info/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练副本-状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDrillInfoStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/drill_info/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 演练副本-删除
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteDrillInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/drill_info", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }
}