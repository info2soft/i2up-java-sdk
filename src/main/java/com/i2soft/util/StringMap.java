package com.i2soft.util;

import com.google.gson.internal.LinkedTreeMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * 封装 http 请求参数，query/body 的参数转换（json/url args）
 * put：key: String, value: String | Integer | Long | String[] | Integer[] | Long[] | StringMap | Map<String, String>
 */
public final class StringMap {
    private Map<String, Object> map;

    public StringMap() {
        this(new HashMap<String, Object>());
    }

    public StringMap(Map map) {
        if (map != null && map.size() > 0) {
            this.map = (Map<String, Object>) map;
        } else {
            this.map = new HashMap<>();
        }
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

    public StringMap put(String key, Boolean value) {
        map.put(key, value);
        return this;
    }

    public StringMap put(String key, Double value) {
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

    public StringMap putNotEmpty(String key, StringMap[] value) {
        if (value != null && value.length > 0) {
            List<Map> list = new ArrayList<>();
            for (StringMap v : value) {
                list.add(v.map());
            }
            map.put(key, list);
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
    public StringMap putAll(Map map) {
        for (Object o : map.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            this.map.put(entry.getKey().toString(), entry.getValue());
        }
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
        if (map != null) {
            return map.size();
        } else {
            return 0;
        }
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

    public String formStringNew() {
        final StringBuilder b = new StringBuilder();
        final boolean[] notStart = {false};

        processMap(map, "", b, notStart);
        return b.toString();
    }

    private void processMap(Map<String, Object> currentMap, String prefix, StringBuilder b, boolean[] notStart) {
        for (Map.Entry<String, Object> entry : currentMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            String fullKey = prefix.isEmpty() ? key : prefix + "[" + key + "]";

            processValue(fullKey, value, b, notStart);
        }
    }

    private void processValue(String key, Object value, StringBuilder b, boolean[] notStart) {
        try {
            if (value == null || (value instanceof String && ((String) value).isEmpty())) {
                // 处理null值或空字符串
                appendKeyValue(key, "", b, notStart);
            } else if (value instanceof String) {
                appendKeyValue(key, (String) value, b, notStart);
            } else if (value instanceof Number || value instanceof Boolean) {
                appendKeyValue(key, value.toString(), b, notStart);
            } else if (value instanceof String[]) {
                String[] array = (String[]) value;
                for (int i = 0; i < array.length; i++) {
                    String arrayKey = key + "[" + i + "]";
                    appendKeyValue(arrayKey, array[i] != null ? array[i] : "", b, notStart);
                }
            } else if (value instanceof Integer[]) {
                Integer[] array = (Integer[]) value;
                for (int i = 0; i < array.length; i++) {
                    String arrayKey = key + "[" + i + "]";
                    appendKeyValue(arrayKey, array[i] != null ? array[i].toString() : "", b, notStart);
                }
            } else if (value instanceof Long[]) {
                Long[] array = (Long[]) value;
                for (int i = 0; i < array.length; i++) {
                    String arrayKey = key + "[" + i + "]";
                    appendKeyValue(arrayKey, array[i] != null ? array[i].toString() : "", b, notStart);
                }
            } else if (value instanceof List) {
                List<?> list = (List<?>) value;
                for (int i = 0; i < list.size(); i++) {
                    String arrayKey = key + "[" + i + "]";
                    processValue(arrayKey, list.get(i), b, notStart);
                }
            } else if (value instanceof Map) {
                Map<String, Object> nestedMap = (Map<String, Object>) value;
                processMap(nestedMap, key, b, notStart);
            } else {
                // 其他类型转为字符串处理
                appendKeyValue(key, value.toString(), b, notStart);
            }
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private void appendKeyValue(String key, String value, StringBuilder b, boolean[] notStart) throws UnsupportedEncodingException {
        b.append(notStart[0] ? "&" : "?");
        b.append(URLEncoder.encode(key, "UTF-8"));
        b.append('=');
        if (value != null && !value.isEmpty()) {
            String encodedValue = URLEncoder.encode(value, "UTF-8");
            b.append(encodedValue);
        }
        notStart[0] = true;
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
                            b.append(notStart ? "&" : "?").append(URLEncoder.encode(key, "UTF-8")).append("[]=")
                                    .append(URLEncoder.encode(val, "UTF-8"));
                            notStart = true;
                        }

                    } else if (valueType == ArrayList.class) { // String -> ArrayList

                        for (Object o : (List) value) {
                            b.append(notStart ? "&" : "?").append(URLEncoder.encode(key, "UTF-8")).append("[]=")
                                    .append(URLEncoder.encode(o.toString(), "UTF-8"));
                            notStart = true;
                        }
                    } else if (valueType == Integer[].class) { // String -> Integer[]

                        for (Integer val : (Integer[]) value) {
                            b.append(notStart ? "&" : "?").append(URLEncoder.encode(key, "UTF-8")).append("[]=")
                                    .append(URLEncoder.encode(val.toString(), "UTF-8"));
                            notStart = true;
                        }

                    } else if (valueType == Long[].class) { // String -> Long[]

                        for (Long val : (Long[]) value) {
                            b.append(notStart ? "&" : "?").append(URLEncoder.encode(key, "UTF-8")).append("[]=")
                                    .append(URLEncoder.encode(val.toString(), "UTF-8"));
                            notStart = true;
                        }

//                    } else if (valueType == HashMap.class) { // String -> HashMap<String, Object>
//
//                        HashMap newMap = (HashMap) value; // 判断后强转，且put时有类型限定
//
//                        for (Object o : newMap.entrySet()) {
//                            Map.Entry entry = (Map.Entry) o;
//
//                            b.append(notStart ? "&" : "?");
//                            try {
//                                b.append(URLEncoder.encode(key, "UTF-8"));
//                                b.append("[").append(URLEncoder.encode(entry.getKey().toString(), "UTF-8")).append("]");
//                                b.append('=');
//                                b.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
//                            } catch (UnsupportedEncodingException e) {
//                                e.printStackTrace();
//                            }
//                            notStart = true;
//                        }

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
            Object value = map.get(field);
            if (value != null) {
                map.put(field, rsa.encryptByPublicKey(value.toString()));
            }
        }
    }

    public void forEachAll(Consumer imp) {
        forEachAll(map, imp);
    }

    private void forEachAll(Map m, Consumer imp) {
        for (Object o : m.entrySet()) {
            Map.Entry entry = (Map.Entry) o;

            if (entry.getValue().getClass().equals(Map.class)) {
                // 如果值为map，就递归下一层
                forEachAll((Map) entry.getValue(), imp);
            } else if (entry.getValue().getClass().equals(Map[].class)) {
                // 如果值为map数组，就递归下一层
                for (Map subMap : (Map[]) entry.getValue()) {
                    forEachAll(subMap, imp);
                }
            } else {
                imp.accept(entry.getKey().toString(), entry.getValue());
            }
        }
    }

    /**
     * 过滤空的嵌套结构（空Map和空List）
     * @param data 输入数据
     * @return 过滤后的数据
     */
    public static Object filterEmpty(Object data) {
        if (data instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) data;
            Map<String, Object> result = new LinkedHashMap<>(); // 使用LinkedHashMap保持输入顺序

            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (value instanceof Map || value instanceof List) {
                    Object filteredValue = filterEmpty(value);
                    if (isNotEmpty(filteredValue)) {  // 只有非空时才保留
                        result.put(key, filteredValue);
                    }
                } else {
                    result.put(key, value);
                }
            }
            return result;

        } else if (data instanceof List) {
            List<?> list = (List<?>) data;
            List<Object> result = new ArrayList<>();

            for (Object item : list) {
                if (item instanceof Map || item instanceof List) {
                    Object filteredItem = filterEmpty(item);
                    if (isNotEmpty(filteredItem)) {  // 只有非空时才保留
                        result.add(filteredItem);
                    }
                } else {
                    result.add(item);
                }
            }
            return result;

        } else {
            return data;
        }
    }

    /**
     * 判断对象是否非空
     * @param obj 对象
     * @return true表示非空
     */
    private static boolean isNotEmpty(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Map) {
            return !((Map<?, ?>) obj).isEmpty();
        }
        if (obj instanceof List) {
            return !((List<?>) obj).isEmpty();
        }
        return true;
    }

    /**
     * 对当前StringMap执行空结构过滤
     * @return 过滤后的新StringMap
     */
    public StringMap filterEmpty() {
        Object filtered = filterEmpty(this.map);
        return new StringMap((Map<String, Object>) filtered);
    }

    public StringMap removeEmptyValue() throws UnsupportedEncodingException {
        StringMap temp = new StringMap();
        for (String key : this.map.keySet()) {
            Object value = this.map.get(key);
            // 移除空值（rap上定义的类似like_args[task_name]=""会被错误移除，但是实际调用不允许使用这种key值所以可以暂时忽略）
            if (value.toString().length() == 0 || value.toString().equals("[]")) {
                continue;
            }
            if (value instanceof String) {
                temp.put(key, value.toString());
            } else {
                if ((value instanceof ArrayList || value instanceof String[]) && !(value.toString().contains("{") && value.toString().contains("}"))){                    // 处理纯uuid数组，直接toString会多出空格
//                     {
//                         "uuids": [
//                            "C88159F0-6FEc-34FF-9d8f-DABEeAB5bD68",
//                            "F40Bc9d2-ccf7-6FFC-a5bF-888d6Dd4ACCc"
//                        ]
//                     }
//                     转为uuids=[C88159F0-6FEc-34FF-9d8f-DABEeAB5bD68,F40Bc9d2-ccf7-6FFC-a5bF-888d6Dd4ACCc]
                    temp.put(key, Json.encode(value));
                } else {
                    // 处理对象，转为带等号的json格式并且逗号前需要有空格
//                    {
//                        "search_value": "''",
//                        "limit": 15,
//                        "type": 1,
//                        "page": 1,
//                        "search_field": "",
//                        "status": "",
//                        "where_args": {
//                            "rule_uuid": "xxxxx",
//                            "status": "replication"
//                        }
//                    }
//                    转为_=oqyDB3CuNkuQHHrp&limit=15&page=1&search_value=''&type=1&where_args={rule_uuid=xxxxx, status=replication}
                    temp.put(key, value.toString());
                }
            }
        }
        return temp;
    }
}