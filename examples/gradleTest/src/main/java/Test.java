import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.rep.v20190805.RepBackup;
import com.i2soft.resource.v20190805.Node;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        try {
            // 控制台地址
            String ip = "https://10.1.50.4:58086";
            String cachePath = "E:\\cache_10.1.50.4\\";   // token 缓存地址

            /**
             * token认证
             */
//            String username = "admin";
//            String password = "info1234";

            // 鉴权
//            Auth auth = Auth.token(ip, username, password, cachePath);

            /**
             * AK认证
             */
            // 登录后，用户个人信息里获取
            String ak = "Sq6ICJvA30cWHQBPn92YUusgelVGopiN";
            String sk = "eb5OFnB1sKcwjxq6dYh0umLNpRfXoCTQAkGZ7VtJ";
            // 鉴权
            Auth auth = Auth.access(ip, ak, sk, cachePath);

            auth.client.setHeader("User-Lang", "zh-CN");

            // 实例化节点管理类
            Node node = new Node(auth);

            // 获取节点列表
            StringMap listArgs = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(listArgs);

            System.out.println(rs);
            // 如访问正常，此处 rs 包含 info_list（节点列表）


            RepBackup repBackup = new RepBackup(auth);
            Map map = repBackup.listRepBackup(new StringMap());
            Long code = (Long) map.get("code");
            if (code != null && code == 0) {
                List<Map> reps = (List<Map>) map.get("info_list");
                for (Map rep : reps) {
                    System.out.println(rep);
//                    String uuid = String.valueOf(rep.get("rep_uuid"));
//                    I2Rs.I2SmpRs rs2 = repBackup.startRepBackup(new String[]{uuid}); // 启动规则
//                    System.out.println(rs2.code);
//                    System.out.println(rs2.message);
//                    rs2 = repBackup.stopRepBackup(new String[]{uuid}); // 停止规则
//                    System.out.println(rs2.code);
                }
            }
        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}
