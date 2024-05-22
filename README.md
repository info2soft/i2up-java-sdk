I2UP Java SDK
========

简介
==

此 SDK 适用于 Java 8 。使用此 SDK 构建您的网络应用程序，无论您的网络应用是一个网站程序，还是包括从云端（服务端程序）到终端（手持设备应用）的架构服务或应用，都能让您以非常便捷地方式使用英方统一数据管理平台（下简称“英方平台”）管理您的业务，同时也让您的服务端更加轻盈。

I2UP Java SDK 属于英方服务端SDK之一，主要用于对接英方控制台，跳过页面进行管理。

开源
==

*   [Java SDK 发布地址](https://gitee.com/i2soft/i2up-java-sdk)
*   [Java SDK 备用地址](https://github.com/info2soft/i2up-java-sdk)

安装
==

*   [使用Gradle](#Gradle)
*   [使用Maven](#Maven)
*   [手动安装](#手动安装)

### Gradle

    compile 'org.info2soft:i2up-java-sdk:8.1.5'

* [gradleProject Demo](examples/gradleTest)
* [gradleProject Demo.zip](examples/gradleTest.zip)

### Maven

    <dependency>
      <groupId>org.info2soft</groupId>
      <artifactId>i2up-java-sdk</artifactId>
      <version>8.1.5</version>
    </dependency>

建议手动指定一个**固定的版本**。

 * [mavenProject Demo](examples/mavenTest)
 * [mavenProject Demo.zip](examples/mavenTest.zip)

### 手动安装

请尽量使用包管理工具自动解决依赖问题。如果条件实在不满足，只能通过手动下载jar包的方式来解决。本项目自身jar及依赖的第三方库如下：

Java SDK依赖的第三方库及其版本如下：

    <dependencies>
        <dependency>
          <groupId>com.i2soft</groupId>
          <artifactId>i2up-java-sdk</artifactId>
          <version>7.1.0</version>
          <scope>compile</scope>
        </dependency>
        <dependency>
          <groupId>com.squareup.okhttp3</groupId>
          <artifactId>okhttp</artifactId>
          <version>4.9.3</version>
          <scope>compile</scope>
        </dependency>
        <dependency>
          <groupId>com.google.code.gson</groupId>
          <artifactId>gson</artifactId>
          <version>2.9.0</version>
          <scope>compile</scope>
        </dependency>
      </dependencies>


 | 库名称 | 库项目地址 | 库下载地址 | 
 | ----- | --------- | --------- | 
 | i2up-java-sdk |  [链接🔗](https://github.com/info2soft/i2up-java-sdk)  | [链接🔗](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22i2up-java-sdk%22) | 
 | okhttp3 | [链接🔗](https://github.com/square/okhttp) | [链接🔗](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.squareup.okhttp3%22) | 
 | gson | [链接🔗](https://github.com/google/gson) | [链接🔗](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.google.code.gson%22) | 

可以点击每个库的下载链接，然后选择对应的jar进行下载，然后引入到项目中。

示例
==

获取英方平台上添加的节点列表

1. 准备英方平台的地址：您安装英方平台的服务器地址，格式为 `http://[ip]:[port]`。
2. 准备 SDK 本地缓存路径：本地会保存访问凭证以减少网络请求次数，您需要提供一个有读写权限的路径，格式为 `"D:\cache\"`。
3. 获取凭证（Auth）：英方Java SDK的所有的功能，都需要合法的授权。授权凭证需要英方平台下的一对有效的`用户名`和`密码`。
4. 实例化具体业务管理类：如此处为 `Node类`。
5. 调用对应业务方法：如此处为 `获取节点列表`。
6. 方法返回：如访问正常，会包含请求结果，如此处为 `info_list`（节点列表）。
7. 异常：I2softException 会在发生 http 错误或方法执行异常时抛出，其中 response 中有错误的详细信息。

如下为获取节点列表

### AK、SK 鉴权

    import com.i2soft.common.Auth;
    import com.i2soft.http.I2softException;
    import com.i2soft.resource.v20190805.Node;
    import com.i2soft.util.Configuration;
    import com.i2soft.util.StringMap;

    import java.util.Map;

    public class Demo {

        public static void main(String[] args) {
            try {
                String ip = "http://[ip]:[port]";                        // 英方平台地址
                String ak = "oishvmn5YPHJcEDaIjtwd0R9Ug7BN1fk";          // 英方平台 Access Key
                String sk = "****";  // 英方平台 Secret Key
                String cachePath = "D:\cache\";     // token 缓存地址
    
                // 鉴权
                Auth auth = Auth.access(ip, ak, sk, cachePath);

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

### 用户名密码鉴权：

    import com.i2soft.common.Auth;
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
                String cachePath = "D:\cache\";     // token 缓存地址

                // 鉴权
                Auth auth = Auth.token(ip, username, password, cachePath);

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

API 参考
======

*   SDK方法 详细参数请参照 [API 参考](https://docs.i2yun.com/i2up-docs/)。

常见问题
====

*   I2softException 保留了请求响应的信息，失败情况下会抛出此异常，可以提交给我们排查问题。
*   API 的使用，demo 可以参考[单元测试](https://github.com/info2soft/i2up-java-sdk/tree/develop/src/test/java/test/com/i2soft)。
*   多语言: `auth.client.setHeader("User-Lang", "zh-CN");` `en-US 英文`， `zh-TW 繁体中文`，`zh-CN 简体`

相关资源
====

如果您有任何关于我们文档或产品的建议和想法，欢迎您通过以下方式与我们互动讨论：

*   [服务与支持](https://www.info2soft.com/support) \- 在这里您可以获得直接的一对一支持。
*   [提交工单](http://support.info2soft.com/welcome/) \- 如果您的问题不适合在论坛讨论或希望及时解决，您也可以提交一个工单，我们的技术支持人员会第一时间回复您。
*   [常见问题FAQ](http://support.info2soft.com/service/public.pl)

贡献代码
====

1.  Fork
    
2.  创建您的特性分支 git checkout -b my-new-feature
    
3.  提交您的改动 git commit -am 'Added some feature'
    
4.  将您的修改记录提交到远程 git 仓库 git push origin my-new-feature
    
5.  然后到 github 网站的该 git 远程仓库的 my-new-feature 分支下发起 Pull Request

