package com.i2soft.resource.v20260209;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class TapeV3 {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public TapeV3(Auth auth) {
        this.auth = auth;
    }

    /**
     * 磁带库 - 扫描
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map scanTapeLibraries(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/scan", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 获取带库驱动器列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeLibraryDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/drivers", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTapeLibrary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeLibrary() throws I2softException {
        String url = String.format("%s/vers/v3/tape_library", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTapeLibrary(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 单个
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeTapeLibrary(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTapeLibrary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 清点 - 刷新
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refreshTapeLibrarySlot(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/refresh_slot", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 出库 - 获取Slot
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBusySlot(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/busy_slot", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 入库 - 扫描I/O插槽
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listBusyIeSlot(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/busy_ie_slot", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map importTapeLibrary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 驱动器管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs enableTapeLibraryDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/drivers_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 驱动器管理 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs moveTapeLibraryDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/drivers_operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 介质 - 磁带池列表
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapePools() throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/tape_pools", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 获取备份主机状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeLibraryStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带池 - 新建
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createTapePool(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/tape_pool", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 介质 - 磁带池 - 修改
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs updateTapePool(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/tape_pool/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 介质 - 磁带池 - 删除
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs deleteTapePool(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/tape_pool", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map freezeTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map browseTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rebuildTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map exportTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map moveTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refreshTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map formatTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map eraseTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 介质 - 磁带 - 列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeMedia(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查看磁带
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeMediaBkData(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/bkdata", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查看磁带 - 磁带数据
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeMediaBkFiles(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/bkfiles", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 查看磁带 - 磁带详情
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeMediaDetails(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_media/details", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 发现新带库
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map refreshTapeLibrary(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/refresh", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 机械臂主机列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeLibraryRoboticArm(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/robotic_arm_list", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 设置驱动/磁带冻结次数
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs setTapeLibraryFreezeNumber(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/freeze_number", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 机械臂主机 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map modifyTapeLibraryRoboticArm(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/robotic_arm", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 修改备份服务器 注册新的备份服务器
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map registerTapeLibraryBackupSvrDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/register", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 修改备份服务器 获取驱动
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listTapeLibraryBackupSvrDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/backup_svr_drivers", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 磁带库 - 备份服务器 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTapeLibraryBackupSvr(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/backup_svr", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 磁带库 - 驱动器 - 修改
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyTapeLibraryDrivers(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/tape_library/drivers", auth.cc_url);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }
}