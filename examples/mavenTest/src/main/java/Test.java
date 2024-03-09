
import com.i2soft.common.Auth;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.rep.v20190805.RepBackup;
import com.i2soft.resource.v20190805.Node;
import com.i2soft.util.StringMap;

import java.util.Map;

public class Test {

    public static void main(String[] args) {
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
    }
}