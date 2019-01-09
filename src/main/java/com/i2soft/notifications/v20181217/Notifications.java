package com.i2soft.notifications.v20181217;

import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Notifications {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Notifications(Auth auth) {
        this.auth = auth;
    }

    /**
     * 消息 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listNotifications(StringMap args) throws I2softException {
        String url = String.format("%s/notifications", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 消息 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNotifications(String uuid) throws I2softException {
        String url = String.format("%s/notifications/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 消息 数量
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNotificationsCount() throws I2softException {
        String url = String.format("%s/notifications/count", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 消息 - 操作：删除
     *
     * @param uuids: uuid数组
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteNotifications(String[] uuids) throws I2softException {
        String url = String.format("%s/notifications/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotEmpty("task_uuids", uuids).put("operate", "delete");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 消息 - 操作：标记已读
     *
     * @param type: 需要标记已读的类型
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs readNotifications(Integer type) throws I2softException {
        String url = String.format("%s/notifications/operate", auth.cc_url);
        StringMap newArgs = new StringMap().putNotNull("type", type).put("operate", "read");
        Response r = auth.client.post(url, newArgs);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 配置 获取
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeNotificationsConfig() throws I2softException {
        String url = String.format("%s/notifications/config", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToMap();
    }

    /**
     * 配置 更新
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateNotificationsConfig(StringMap args) throws I2softException {
        String url = String.format("%s/notifications/config", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 邮件测试
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs testNotificationsEmail(StringMap args) throws I2softException {
        String url = String.format("%s/notifications/email_test", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 重置通知次数
     *
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs resetNotificationsTimes() throws I2softException {
        String url = String.format("%s/notifications/reset_notify_times", auth.cc_url);
        Response r = auth.client.get(url);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}