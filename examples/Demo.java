
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
            String password = "xxxxx";          // 英方平台密码
            String cachePath = "D:\\cache\\";   // token 缓存地址

            // 鉴权
            Auth auth = Auth.token(ip, username, password, cachePath);
            auth.client.setHeader("User-Lang", "zh-CN");

            // 实例化节点管理类
            Node node = new Node(auth);

            // 获取节点列表
            StringMap listArgs = new StringMap().put("limit", 1).put("direction", "DESC"); // 填充请求数据
            Map rs = node.listNode(listArgs);

            // 如访问正常，此处 rs 包含 info_list（节点列表）

        } catch (I2softException e) {
            e.printStackTrace();
        }
    }
}