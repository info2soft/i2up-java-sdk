package com.i2soft.util;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public final class StringMap {
    private Map<String, Object> map;

    public StringMap() {
        this(new HashMap<String, Object>());
    }

    public StringMap(Map<String, Object> map) {
        this.map = map;
    }

    public StringMap put(String key, Object value) {
        map.put(key, value);
        return this;
    }

    public StringMap putNotEmpty(String key, String value) {
        if (!StringUtils.isNullOrEmpty(value)) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotEmpty(String key, Integer value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotNull(String key, Object value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }


    public StringMap putWhen(String key, Object val, boolean when) {
        if (when) {
            map.put(key, val);
        }
        return this;
    }

    public StringMap putAll(Map<String, Object> map) {
        this.map.putAll(map);
        return this;
    }

    public StringMap putAll(StringMap map) {
        this.map.putAll(map.map);
        return this;
    }

    public void forEach(Consumer imp) {
        for (Map.Entry<String, Object> i : map.entrySet()) {
            imp.accept(i.getKey(), i.getValue());
        }
    }

    public int size() {
        return map.size();
    }

    public Map<String, Object> map() {
        return this.map;
    }

    public Object get(String key) {
        return map.get(key);
    }

    /**
     * get 参数拼接
     * 入参为本身的map，其key为str，val可以是 String / Integer / Long / StringMap(only str->str)
     *
     * @return String: ?key=val&key=val...
     */
    public String formString() {
        final StringBuilder b = new StringBuilder();
        forEach(new Consumer() {
            private boolean notStart = false;

            @Override
            public void accept(final String key, Object value) {

                Class valueType = value.getClass();

                try {
                    if (valueType == String[].class) { // String -> String[]

                        for (String val : (String[]) value) {
                            b.append(notStart ? "&" : "?");
                            b.append(URLEncoder.encode(key, "UTF-8")).append("[]").append('=');
                            b.append(URLEncoder.encode(val, "UTF-8"));
                            notStart = true;
                        }

                    } else if (valueType == Integer[].class) { // String -> Integer[]

                        for (Integer val : (Integer[]) value) {
                            b.append(notStart ? "&" : "?");
                            b.append(URLEncoder.encode(key, "UTF-8")).append("[]").append('=');
                            b.append(URLEncoder.encode(val.toString(), "UTF-8"));
                            notStart = true;
                        }

                    } else if (valueType == Long[].class) { // String -> Long[]

                        for (Long val : (Long[]) value) {
                            b.append(notStart ? "&" : "?");
                            b.append(URLEncoder.encode(key, "UTF-8")).append("[]").append('=');
                            b.append(URLEncoder.encode(val.toString(), "UTF-8"));
                            notStart = true;
                        }

                    } else if (valueType == StringMap.class) { // String -> StringMap

                        StringMap map = (StringMap) value;
                        map.forEach(new StringMap.Consumer() {
                            @Override
                            public void accept(String subKey, Object subValue) {
                                b.append(notStart ? "&" : "?");
                                try {
                                    b.append(URLEncoder.encode(key, "UTF-8"));
                                    b.append("[").append(URLEncoder.encode(subKey, "UTF-8")).append("]").append('=');
                                    b.append(URLEncoder.encode(subValue.toString(), "UTF-8"));
                                } catch (UnsupportedEncodingException e) {
                                    e.printStackTrace();
                                }
                                notStart = true;
                            }
                        });

                    } else {
                        b.append(notStart ? "&" : "?");
                        b.append(URLEncoder.encode(key, "UTF-8")).append('=');
                        b.append(URLEncoder.encode(value.toString(), "UTF-8"));
                        notStart = true;
                    }

                } catch (UnsupportedEncodingException e) {
                    throw new AssertionError(e);
                }
            }
        });
        return b.toString();
    }

    // StringMap 转 json 串 body
    public RequestBody toJson() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(JSON, Json.encode(map));
    }

    public interface Consumer {
        void accept(String key, Object value);
    }
}
