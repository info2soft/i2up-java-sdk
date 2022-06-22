package com.i2soft.common.v20181217;

import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Monitor {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Monitor(Auth auth) {
        this.auth = auth;
    }

    /**
     * 磁盘信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listDriversInfo(String uuid) throws I2softException {
        String url = String.format("%s/monitor/drivers_info/%s ", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 当前硬件信息
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listPhyInfo(String uuid) throws I2softException {
        String url = String.format("%s/monitor/phy_info/%s ", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 获取图表展示项
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listChartConfig(String uuid) throws I2softException {
        String url = String.format("%s/monitor/chart_config/%s ", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 设置图表展示项
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs setChartConfig(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/monitor/chart_config/%s ", auth.cc_url, uuid);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 图表数据
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listChartData(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/monitor/chart_data/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}