package com.i2soft.common;

import com.i2soft.util.StringMap;

import java.util.Map;

/**
 * 这里定义了请求参数的封装类
 */
public class I2Req {
    /**
     * 获取列表通用参数
     */
    public static class ListArgs {

        // 分页
        public Integer limit = null;
        public Integer page = null;
        public String order_by = null;
        public String direction = null;

        // 搜索
        public String search_value = null;
        public String search_field = null;

        // 类型过滤
        public Integer type = null;

        // 是否是以组过滤
        public Integer filter_by_biz_grp = null;

        // 批量搜索/过滤
        public Map<String, String> like_args = null;
        public Map<String, String> where_args = null;

        public ListArgs() {
        }

        public StringMap toStringMap() {
            return new StringMap()
                    .putNotEmpty("limit", limit)
                    .putNotEmpty("page", page)
                    .putNotEmpty("order_by", order_by)
                    .putNotEmpty("direction", direction)
                    .putNotEmpty("search_value", search_value)
                    .putNotEmpty("search_field", search_field)
                    .putNotEmpty("search_field", search_field)
                    .putNotEmpty("type", type)
                    .putNotEmpty("filter_by_biz_grp", filter_by_biz_grp)
                    .putNotNull("like_args", like_args)
                    .putNotNull("where_args", where_args);
        }
    }
}
