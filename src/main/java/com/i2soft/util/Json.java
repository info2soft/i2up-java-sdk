package com.i2soft.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public final class Json {
    private Json() {
    }

    public static String encode(StringMap map) {
        return new Gson().toJson(map.map());
    }

    public static String encode(Object obj) {
        return new GsonBuilder().serializeNulls().create().toJson(obj);
    }

    public static <T> T decode(String json, Class<T> classOfT) {
        return getIntGson().fromJson(json, classOfT);
    }

    public static StringMap decode(String json) {
        // CHECKSTYLE:OFF
        Type t = new TypeToken<Map<String, Object>>() {
        }.getType();
        // CHECKSTYLE:ON
        Map<String, Object> x = getIntGson().fromJson(json, t);

        return new StringMap(x);
    }

    /**
     * 解决gson默认将int转换为double
     */
    private static Gson getIntGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<Map<String, Object>>() {
        }.getType(), new GsonMapDeserializerFix());
        return gsonBuilder.create();
    }
}
