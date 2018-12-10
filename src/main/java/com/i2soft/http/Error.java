package com.i2soft.http;

/**
 * 业务请求逻辑错误封装类，主要用来解析API请求返回如下的内容：
 * <pre>
 * {
 *     "ret": 200,
 *     "msg": "http err msg",
 *     "data": {
 *         "code": 0,
 *         "message": "biz err msg"
 *     }
 * }
 * </pre>
 */
public final class Error {

    public final class HttpErr {
        public Integer ret = null;
        public String msg = null;
        I2Err data;
    }

    final class HttpErrData {
        Object data;
    }

    public final class I2Err {
        Integer code;
        String message;
    }
}
