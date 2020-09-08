
import com.i2soft.http.I2softException;
import com.i2soft.resource.v20190805.Node;
import com.i2soft.util.Configuration;
import com.i2soft.util.StringMap;

import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        try {
            String ip = "http://[ip]:[port]";   // 英方平台地址

            String username = "admin";          // 英方平台用户名
            String password = "1qaz@erqw";          // 英方平台密码
            String cachePath = "E:\\cache\\";   // token 缓存地址

            // 登录后，用户个人信息里获取
            String ak = "";
            String sk = "";

            // 鉴权
            Auth auth = Auth.token(ip, username, password, cachePath);
            // Auth auth = Auth.access(ip, ak, sk);

            // 设置语言
            auth.client.setHeader("User-Lang", "zh-CN");

            // 实例化节点管理类
            Node node = new Node(auth);

            // 获取节点列表
            StringMap listArgs = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(listArgs);

            // 如访问正常，此处 rs 包含 info_list（节点列表）
            System.out.println(rs);

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}