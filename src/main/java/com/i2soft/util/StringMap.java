package com.i2soft.util;

import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 封装 http 请求参数，query/body 的参数转换（json/url args）
 * put：key: String, value: String | Integer | Long | String[] | Integer[] | Long[] | StringMap | Map<String, String>
 */
public final class StringMap {
    private Map<String, Object> map;

    public StringMap() {
        this(new HashMap<String, Object>());
    }

    public StringMap(Map<String, Object> map) {
        this.map = map;
    }

    // put
    public StringMap put(String key, String value) {
        map.put(key, value);
        return this;
    }

    public StringMap put(String key, Integer value) {
        map.put(key, value);
        return this;
    }

    public StringMap put(String key, Long value) {
        map.put(key, value);
        return this;
    }

    // put arr
    public StringMap put(String key, String[] value) {
        map.put(key, value);
        return this;
    }

    public StringMap put(String key, Integer[] value) {
        map.put(key, value);
        return this;
    }

    public StringMap put(String key, Long[] value) {
        map.put(key, value);
        return this;
    }

    // put map
    public StringMap put(String key, StringMap value) {
        map.put(key, value.map());
        return this;
    }

    public StringMap put(String key, Map<String, String> value) {
        map.put(key, value);
        return this;
    }

    // putNotNull
    public StringMap putNotEmpty(String key, String value) {
        if (!StringUtils.isNullOrEmpty(value)) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotNull(String key, Integer value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotNull(String key, Long value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }

    // putNotNull arr
    public StringMap putNotEmpty(String key, String[] value) {
        if (value != null && value.length > 0) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotEmpty(String key, Integer[] value) {
        if (value != null && value.length > 0) {
            map.put(key, value);
        }
        return this;
    }

    public StringMap putNotEmpty(String key, Long[] value) {
        if (value != null && value.length > 0) {
            map.put(key, value);
        }
        return this;
    }

    // putNotNull map
    public StringMap putNotNull(String key, StringMap value) {
        if (value != null) {
            map.put(key, value.map());
        }
        return this;
    }

    public StringMap putNotNull(String key, Map<String, String> value) {
        if (value != null) {
            map.put(key, value);
        }
        return this;
    }

    // putAll
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

    public interface Consumer {
        void accept(String key, Object value);
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

    // StringMap 转 json 串 body
    public RequestBody toJson() {
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        return RequestBody.create(JSON, Json.encode(map));
    }

    /**
     * get 参数拼接
     * 入参为本身的map，其key为str，val可以是 String / Integer / Long / HashMap<String, Object>
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

                    } else if (valueType == HashMap.class) { // String -> HashMap<String, Object>

                        HashMap newMap = (HashMap) value; // 判断后强转，且put时有类型限定

                        for (Object o : newMap.entrySet()) {
                            Map.Entry entry = (Map.Entry) o;

                            b.append(notStart ? "&" : "?");
                            try {
                                b.append(URLEncoder.encode(key, "UTF-8"));
                                b.append("[").append(URLEncoder.encode(entry.getKey().toString(), "UTF-8")).append("]");
                                b.append('=');
                                b.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                            notStart = true;
                        }

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

    public void fieldsRsa(String[] fields) {
        final Rsa rsa = new Rsa();
        for (String field : fields) {
            map.put(field, rsa.encryptByPublicKey(map.get(field).toString()));
        }
    }
}
