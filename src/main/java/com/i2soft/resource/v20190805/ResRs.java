package com.i2soft.resource.v20190805;

/**
 * 这里定义了请求相关回复的封装类
 */
public class ResRs {
    /**
     * node
     */
    public class NodeList {
        public ListNode[] info_list;
    }

    public class ListNode {
        public String username;
        public String cache_path;
        public String config_addr;
        public String data_addr;
        public String disk_limit;
        public String log_path;
        public String mem_limit;
        public String node_name;
        public String node_role;
        public String node_uuid;
        public Integer os_type;
        public String os_version;
    }
}
