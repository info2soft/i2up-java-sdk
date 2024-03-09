
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.rep.v20190805.RepBackup;
import com.i2soft.resource.v20190805.Node;
import com.i2soft.util.StringMap;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        // 获取节点列表， 获取规则状态， 启停规则
        try {
            String ip = "https://172.20.68.251:58086";   // 英方平台地址
            String cachePath = "E:\\cache\\";   // 缓存路径

//            String username = "admin";          // 英方平台用户名
//            String password = "xxxx";          // 英方平台密码

            // 登录后，用户个人信息里获取
            String ak = "RkIfboCzhin48STxs3DP0p6HXGmYML5a";
            String sk = "dxo******A87Kn";

            // 鉴权
//            Auth auth = Auth.token(ip, username, password, cachePath);
             Auth auth = Auth.access(ip, ak, sk, cachePath);

            auth.client.setHeader("User-Lang", "zh-CN");

            // 实例化节点管理类
            Node node = new Node(auth);

            // 获取节点列表
            StringMap listArgs = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(listArgs);

            System.out.println(rs);
            // 如访问正常，此处 rs 包含 info_list（节点列表）

            // 获取规则状态
            String uuid = "B9F494A0-3A77-49EE-B5DF-58BA9A9D167F";

            RepBackup repBackup = new RepBackup(auth);
            listArgs = new StringMap().put("force", 0).put("rep_uuids", new String[]{uuid});
            Map listRs = repBackup.listRepBackupStatus(listArgs);
            System.out.println(listRs);

            //启停规则
            I2Rs.I2SmpRs rs2 = repBackup.startRepBackup(new String[]{uuid}); // 发送请求
            System.out.println(rs2);
            rs2 = repBackup.stopRepBackup(new String[]{uuid});
            System.out.println(rs2);

        } catch (I2softException e) {
            e.printStackTrace();
        }

        // 创建复制规则
        try {
            String ip = "https://10.1.7.79:58086";   // 英方控制台地址
            String username = "admin";          // 英方控制台用户名
            String password = "***";          // 英方控制台密码
            String cachePath2 = "E:\\cache2\\";   // 缓存路径，  同时连多个控制台需要设置成不同路径

            // 鉴权
            Auth auth = Auth.token(ip, username, password, cachePath2);

            // 设置语言
            auth.client.setHeader("User-Lang", "zh-CN");

            // 实例化节点管理类
            Node node = new Node(auth);

            // 获取节点列表
            StringMap listArgs = new StringMap().put("limit", 2).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(listArgs);

            // 如访问正常，此处 rs 包含 info_list（节点列表）
            System.out.println(rs);

            System.out.println("Node number="+((List)rs.get("info_list")).size());
            // 如访问正常，此处 rs 包含 info_list（节点列表）

            StringMap createRepArg = new StringMap()
                    //基本设置
                    .put("rep_type", 0) //0: default; 1: cluster; 2: block; 10: template;（必传）
                    .put("rep_name", "test1") //复制规则名,(必传)
                    .put("wk_uuid", "56965FE0-9FDF-FE06-84D3-41E76449490B")  //工作机id（必传）
                    .put("bk_uuid", "2F82CA91-AF60-D153-51B4-B1C986B7EE34")  //备机（目标节点）的uuid ，云版可不填（block也有）
                    .put("file_type_filter_switch", 0) //包含0排除1，默认为包含
                    .put("file_type_filter", "") //文件类型过滤，比如：*.doc,*.docx
                    .put("auto_start", 1)              //规则自动启动（block也有），默认自动启动

                    //路径设置
                    .put("bk_path_policy", 0)                      //源路径目标路径路径映射关系：0：一对一，1：多对一；
                    .put("wk_path", new String[]{"/root/work/"})   //工作目录（必传）
                    .put("bk_path", new String[]{"/root/backup/"}) //备机（目标节点）路径，备份数据存放路径，云版可不填（block也有）
                    .put("excl_path", new String[]{})            //源机排除目录

                    //镜像设置
                    .put("mirr_skip", "0")       //镜像设置 - 跳过镜像；0：正常镜像；1：直接进入复制状态；2：仅同步目录；默认自动启动后自动开始镜像
                    .put("mirr_file_check", 0) //校验方式：0：md5；1：文件大小和时间校验，不同则严格校验；2：文件时间校验，不同则覆盖目标文件；3：文件总是覆写；默认为0严格校验
                    .put("mirr_sync_flag", 0)  //错误处理方式， 0 遇到错误停止， 1 写日志, 默认为0
                    .put("mirr_open_type", 0)  //文件打开方式， 0 普通文件， 1 自动选择， 2 MFT，默认为0普通文件
                    .put("mirr_sync_attr", 1)  //文件安全属性， 0 不同步； 1同步，默认同步
                    .put("traversing_sync", 0) //遍历时传输： 1-开启 0-不开启，默认不开启遍历
                    .put("thread_num", "1")    //并行任务数，默认为1
                    .put("oph_policy", 0)      //镜像阶段孤儿文件处理策略：0不处理，1删除，2移动到指定路径；6 归档；，默认为0不处理
                    .put("oph_path", "")       //镜像阶段孤儿文件，移动到指定路径、归档，必填

                    //压缩加密
                    .put("compress_switch", 0) //传输压缩开关：0，1， 默认不开启压缩加密
                    .put("compress", 0)        //压缩：0不开启；1，低；2，中；3，高（block也有）
                    .put("encrypt_switch", 0)  //0不开启，1开启（block也有）， 默认不开启压缩加密
                    .put("encrypt", 0)         //传输加密类型：0-不加密 1-传输AES加密 2-SM4加密
                    .put("secret_key", "")     //加密key（block也有）
                    .put("bk_file_crypt", 0)   //备端数据加密，1是，0否；默认为0
                    .put("bk_crypt_type", 1)  //备端数据加密类型：1：aes，2：sm4
                    .put("bk_crypt_key", "")  //备端数据加密，密钥

                    //快照设置
                    .put("snapshot_switch", 0)         //快照开关：0，1， 默认不开启快照
                    .put("snapshot_policy", 0)         //快照个数达到上限时策略，默认为0自动循环
                    .put("snapshot_start", 1546913351) //开始时间，Eg: 1515568566
                    .put("snapshot_limit", 2)          //快照数目
                    .put("snapshot_interval", 1)       //快照间隔

                    //CDP设置
                    .put("cdp_switch", 0)                //0：不启用；1：开启, 默认不开启cdp
                    .put("cdp_path", "")                 //CDP数据目录 : 如开启CDP则必填
                    .put("cdp_process_time", "00:00:00") //hh:mm:ss , 默认00:00:00
                    .put("cdp_baseline_format", 0)       //Baseline存储格式: 保持源目录结构 打包
                    .put("cdp_bl_bkup_switch", 0)        //创建baseline副本 0否1是
                    .put("cdp_path_switch", 1)           //cdp数据目录开关：0：关；1：开；
                    .put("cdp_snap_on", 0)               //使用快照做Baseline；0关1开；
                    .put("cdp_bl_sched_switch", 1)       //指定生成Baseline（全备份）的策略
                    .put("cdp_param", "3,30,0")          //CDP参数：是几个参数的合并
                    .put("cdp_data_inc_switch", 0)       //按数据增量做快照开关
                    .put("cdp_data_inc", 0)              //数据增量的大小，单位为M
                    .put("cdp_data_inc_flag", "")        //用来表示数据增量单位 M G T
                    .put("latency_threshold", 1)         //延迟告警毫秒数，默认值0不告警
                    .put("cdp_zfs_pool", "")             //CDP zfs存储池，选择系统上已有的存储池，仅在cdp页面快照打开且备机是Linux系统时的时候显示.，如果获取的value值为空，则cdp不支持linux快照方式。
                    .put("cdp_snap_interval", 30)        //CDP快照间隔,5,10,15,20,25,30,40,50,60，单位是分钟
                    .put("cdp_snap_count", 240)          //CDP快照数量，0到9999之间的整数
                    .put("cdp_bl_sched", "2|1|0|5")      //Baseline（全备份）策略 "2|0|0|1,1|1|0|1,0|31|12|1"	type | day | month | num
                    .put("del_policy", 0)                //删除策略，0：不开启；1：开启；

                    //带宽控制
                    .put("band_width", "")              //带宽控制，格式：3*03:00-14:00*2m,2*02:00-15:00*80m（block也有）


                    //比较计划
                    .put("cmp_switch", 0)                //比较同步开关：0：关；	1：开； 默认不开启比较计划
                    .put("cmp_file_check", 0)            //校验方式：   0：md5；	1：文件大小和时间校验，不同则严格校验；2：文件时间校验，不同则覆盖目标文件；3：文件总是覆写；
                    .put("cmp_schedule", new String[]{}) //比较计划，策略
                    .put("cmp_limit", 1)                 //比较计划，保留数：-1：永久保留；
                    .put("cmp_type", 1)                 //任务类型：0：只比较；1：比较并同步；

                    //高级设置
                    .put("rep_oph_switch", 0)    //复制删除文件处理，0 - 关，1 - 开，默认为0关
                    .put("rep_oph_policy", 1)    //复制删除文件处理策略：1-过滤删除 2-归档 3-重命名
                    .put("rep_oph_path", "")    //复制删除文件处理策略-归档时，必填
                    .put("filter_delete", 0)     //过滤删除，1：开；0关
                    .put("mirr_sched_switch", 0) //高级设置 - 启用禁止镜像：1；关闭：0；（block也有）
                    .put("mirr_sched", "")       //高级设置 - 禁止镜像策略；Eg: 3*03:00-14:00,2*02:00-15:00（block也有））
                    .put("mir_detect_script", "")       //高级设置 - 检测脚本路径
                    .put("mir_detect_src_script", "")   //高级设置 - 源端检测脚本

                    .put("ct_name_type", 0)      //文件名替换，0表示不启用。1加前后缀，原来部分保持不变；2前后缀加小写，3前后缀加大写4自定义
                    .put("ct_name_str1", "")     //文件名转换：prefix string / regex string
                    .put("ct_name_str2", "")     //文件名转换：suffix string / replace string
                    .put("ct_name_str3", "")     //文件名转换：restore regex string
                    .put("ct_name_str4", "")     //文件名转换：restore regex string


                    //未定
                    .put("rep_uuid", "B8166905-411E-B2CD-A742-77B1346D8E84")  //前端生成的规则uuid，接口兼容处理，如果前端不传接口会自己处理
                    .put("pool_uuid", "")  //【可选】磁盘存储池uuid，移动云备份必传
                    .put("network_type", 1)              //网络类型：	0-TCP/IP	1-LANFREE
                    .put("channel_uuid", "")             //【可选】LANFREE通道，网络类型为LANFREE时必选
                    .put("buf_in_bk", 1)  //备机增量数据缓存    0 - 不勾选      1 - 勾选
                    .put("buf_in_bk", 1)  //备机增量数据缓存    0 - 不勾选      1 - 勾选
                    .put("mscs_autostart", 1)           //开关: 集群故障转移到另一节点时，自动启动复制规则勾选是1不勾选是0
                    .put("data_ip_uuid", "")     //【可选】数据地址uuid 网络类型为TCP/IP时必选
                    .put("mscs_group", "")       //已选集群组object类型
                    .put("bkup_one_time", 1515568566)   //定时任务，执行时间（备份策略） Eg: 1515568566
                    .put("disk_limit", "0");     //该规则最大可用存储空间


            RepBackup rep1 = new RepBackup(auth);
            StringMap repBackup = new StringMap().put("rep_backup", createRepArg);
            I2Rs.I2SmpRs createRs = rep1.createRepBackup(repBackup);
            System.out.println("Create coopy response code=" + createRs.code);
            System.out.println("Create coopy response message=" + createRs.message);


            StringMap listArgss = new StringMap().put("limit", 3).put("direction", "DESC"); // 填充请求数据
            Map rs1 = rep1.listRepBackup(listArgss);

            // 如访问正常，此处 rs 包含 info_list（节点列表）
            System.out.println(rs1);
            System.out.println("coopy number="+((List)rs1.get("info_list")).size());
            // 如访问正常，此处 rs 包含 info_list（节点列表）

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}