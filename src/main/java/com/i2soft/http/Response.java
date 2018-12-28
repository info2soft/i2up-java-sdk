package com.i2soft.http;

import com.i2soft.util.Json;
import com.i2soft.util.StringUtils;
import okhttp3.MediaType;

import java.io.IOException;
import java.util.Map;

/**
 * 定义HTTP请求的日志信息和常规方法
 */
public final class Response {

    /**
     * 回复状态码
     */
    public final int ret;
    /**
     * 错误信息
     */
    public final String msg;
    /**
     * 自定义回复状态码
     */
    public final int code;
    /**
     * 自定义错误信息
     */
    public final String message;
    /**
     * 请求消耗时间，单位秒
     */
    public final double duration;
    /**
     * 服务器IP
     */
    public final String address;

    private byte[] body;
    private okhttp3.Response response;

    private Response(okhttp3.Response response, int ret, String address, double duration, String msg, byte[] body, int code, String message) {
        this.response = response;
        this.duration = duration;
        this.address = address;
        this.body = body;
        this.ret = ret;
        this.msg = msg;
        this.code = code;
        this.message = message;
    }

    public static Response create(okhttp3.Response response, String address, double duration) {
        String msg = null;
        int ret = response.code();
        byte[] body = null;
        int code = 0;
        String message = null;

        try {
            if (response.body() != null) {
                body = response.body().bytes();
                String bodyJsonStr = new String(body);
                Error.HttpErr httpErr = Json.decode(bodyJsonStr, Error.HttpErr.class);
                msg = httpErr.msg;

                // 处理返回data结果
                if (response.code() == 200 && httpErr.data != null) {
                    // i2 err code
                    code = httpErr.data.code;
                    message = httpErr.data.message;

                    // 过滤，如没http错，则仅将data放入body中
                    Object data = Json.decode(bodyJsonStr, Error.HttpErrData.class).data; // 用obj类型取出data
                    body = StringUtils.utf8Bytes(Json.encode(data)); // 重编码为 json bytes
                }
            }
        } catch (Exception e) {
            if (response.code() < 300) {
                msg = e.getMessage();
            }
        }
        return new Response(response, ret, address, duration, msg, body, code, message);
    }

    public Map jsonToMap() throws I2softException {
        if (isNotJson()) {
            return null;
        }
        String b = bodyString();
        StringUtils.printLog("RS: " + b);
        return Json.decode(b).map();
    }

    public <T> T jsonToObject(Class<T> classOfT) throws I2softException {
        if (isNotJson()) {
            return null;
        }
        String b = bodyString();
        StringUtils.printLog("RS: " + b);
        return Json.decode(b, classOfT);
    }

    public String bodyString() throws I2softException {
        return StringUtils.utf8String(body());
    }

    public synchronized byte[] body() throws I2softException {
        if (body != null) {
            return body;
        }
        try {
            this.body = response.body() != null ? response.body().bytes() : new byte[0];
        } catch (IOException e) {
            throw new I2softException(e);
        }
        return body;
    }

    public boolean isNotJson() {
        return !contentType().equals(Client.JsonMime);
    }

    public String contentType() {
        return ctype(response);
    }

    private static String ctype(okhttp3.Response response) {
        MediaType mediaType = response.body() != null ? response.body().contentType() : null;
        if (mediaType == null) {
            return "";
        }
        return mediaType.type() + "/" + mediaType.subtype();
    }

    public String getInfo() {
        String[] msg = new String[3];
        try {
            msg[0] = url();
        } catch (Throwable ignored) {
        }
        try {
            msg[1] = toString();
        } catch (Throwable ignored) {
        }
        try {
            msg[2] = bodyString();
        } catch (Throwable ignored) {
        }
        return StringUtils.join(msg, "  \n");
    }

    public String url() {
        return response.request().url().toString();
    }
}
