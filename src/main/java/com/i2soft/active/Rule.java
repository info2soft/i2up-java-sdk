package com.i2soft.active;

import com.i2soft.common.Auth;

public abstract class Rule {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Rule(Auth auth) {
        this.auth = auth;
    }

}