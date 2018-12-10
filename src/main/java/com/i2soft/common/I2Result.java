package com.i2soft.common;

/**
 * 这里定义了请求相关回复的封装类
 */
public class I2Result {
    /**
     * auth/token
     */
    public class AuthRs {
        /**
         * token
         */
        public String token;
        /**
         * sso_token
         */
        public String sso_token;
    }
}
