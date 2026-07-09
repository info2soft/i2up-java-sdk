package com.i2soft.common.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class BigScreen {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public BigScreen(Auth auth) {
        this.auth = auth;
    }

    /**
     * 大屏展示 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createBigScreen(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyBigScreen(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigScreen(String uuid) throws I2softException {
        String url = String.format("%s/big_screen/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大屏展示 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigScreen(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大屏展示 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBigScreen(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - logo上传
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs uploadBigScreenLogo(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/logo", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - logo删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteBigScreenLogo(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/logo", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示-logo列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigScreenLogo() throws I2softException {
        String url = String.format("%s/big_screen/logo_list", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 大屏展示 - 更新配置
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs configBigScreen(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/config", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - 获取配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigScreenConfig(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/config", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大屏展示 - 清零
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs clearBigScreenStatData(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/clear_data", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 大屏展示 - 获取规则
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigScreenStatRules(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/rules", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大屏展示-统计数据
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeBigScreenStat(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/stat", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 大屏展示-拓扑图
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBigScreenGraph(StringMap args) throws I2softException {
        String url = String.format("%s/big_screen/graph", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}