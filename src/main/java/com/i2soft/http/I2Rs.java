package com.i2soft.http;

/**
 * 这里定义了请求相关回复的封装类
 */
public class I2Rs {

    public class I2SmpRs {
        public Integer code;
        public String message;
    }

    public class I2CreateRs {
        public Integer code;
        public String message;
        public String uuid;
    }

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
