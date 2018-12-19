package com.i2soft.http;

import java.io.IOException;

/**
 * SDK异常封装类，封装了http响应数据
 */
public final class I2softException extends IOException {
    public final Response response;
    private String msg;


    public I2softException(Response response) {
        super(response != null ? response.getInfo() : null);
        this.response = response;
    }

    public I2softException(Exception e) {
        this(e, null);
    }

    public I2softException(Exception e, String msg) {
        super(msg, e);
        this.response = null;
        this.msg = msg;
    }

    public int ret() {
        return response == null ? -1 : response.ret;
    }

    public String msg() {
        if (msg != null) {
            return msg;
        }
        if (response == null || response.ret / 100 == 2 || response.isNotJson()) {
            return null;
        }
        Error.HttpErr e = null;
        try {
            e = response.jsonToObject(Error.HttpErr.class);
        } catch (I2softException e1) {
            e1.printStackTrace();
        }
        msg = e == null ? "" : e.msg;
        return msg;
    }
}
