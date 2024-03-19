package com.i2soft.ruleVersion;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class RuleVersion {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public RuleVersion(Auth auth) {
        this.auth = auth;
    }

    /**
     * 获取规则历史版本列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRuleVersion(StringMap args) throws I2softException {
        String url = String.format("%s/rule_version", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查看具体配置
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeRuleVersionInfo(StringMap args) throws I2softException {
        String url = String.format("%s/rule_version/info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }
}