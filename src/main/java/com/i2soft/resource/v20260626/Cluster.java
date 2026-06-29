package com.i2soft.resource.v20260626;

import com.i2soft.http.I2Req;
import com.i2soft.http.I2Rs;
import com.i2soft.http.I2softException;
import com.i2soft.http.Response;
import com.i2soft.common.Auth;
import com.i2soft.util.StringMap;

import java.util.Map;

public final class Cluster {
    /**
     * Auth 对象
     */
    private final Auth auth;

    /**
     * 构建一个新对象
     *
     * @param auth Auth对象
     */
    public Cluster(Auth auth) {
        this.auth = auth;
    }

    /**
     * 1准备-1 集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map authCls(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/auth", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 1准备-2 集群节点验证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map verifyClsNode(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/node_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 2编辑/新建-1 新建集群
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs createCls(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 2编辑/新建-2 获取单个集群
     *
     * @param uuid: uuid
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map describeCls(String uuid) throws I2softException {
        String url = String.format("%s/vers/v3/cls/%s", auth.cc_url, uuid);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * 1准备-3 根据集群IP获取节点信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsNodeInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/node_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 2编辑/新建-3 修改集群
     *
     * @param uuid: uuid
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs modifyCls(String uuid, StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/%s", auth.cc_url, uuid);
        Response r = auth.client.put(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * 3列表-1 获取集群列表（基本信息）
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listCls(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-2 集群状态
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listClsStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-3 删除集群
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map deleteCls(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls", auth.cc_url);
        Response r = auth.client.delete(url, args);
        return r.jsonToMap();
    }

    /**
     * 3列表-4 集群操作
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDetail(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/operate", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 列表 - 状态(RAC)
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRacStatus(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/rac_status", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 获取GAUSS集群信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getGaussInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/gauss_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * 切换维护
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs switchMaintenance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/maintenance", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * Gauss HCS获取实例列表
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGaussHcsInstances(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/gauss_hcs_instances", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Gauss HCS 恢复规则获取默认值
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGaussHcsDefaultInstance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/gauss_hcs_default_instance", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Gauss Tpop 恢复规则获取实例形态和对应
     *
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGaussTpopSolution() throws I2softException {
        String url = String.format("%s/vers/v3/cls/gauss_tpop_solution", auth.cc_url);
        Response r = auth.client.get(url, new StringMap());
        return r.jsonToMap();
    }

    /**
     * Gauss Tpop 恢复规则获取默认值
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listGaussTpopDefaultInstance(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/gauss_tpop_default_instance", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * GoldenDB - 认证并获取集群信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsGoldenDBInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/golden_db_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * MongoDB认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsMongoDBInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/mongo_db_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * TDSQL认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsTdsqlDBInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/tdsql_db_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * TDSQL-Postgres认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsTdsqlPgDBInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/tdsql_pg_db_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * DMDSC - 认证并获取集群信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDmdscInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/dmdsc_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * DMDSC 获取实例信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDmdscInstanceInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/dmdsc_instance_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * DMMPP - 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDmmppInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/dmmp_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * DMMPP - 匹配
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDmmppMatch(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/dmmpp_match", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * DMRWC - 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clsDmrwcInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/dmrwc_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Doris集群认证并获取集群信息
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs clsDorisInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/doris_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * TiDB集群认证
     *
     * @param args: 参数详见 API 手册
     * @return code, message
     * @throws I2softException:
     */
    public I2Rs.I2SmpRs tidbVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/tidb_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToObject(I2Rs.I2SmpRs.class);
    }

    /**
     * (Oracle)RAC集群 - 获取实例
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map listRacInstances(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/rac_instances", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Tdsql恢复获取备选项
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getTdsqlInstanceDefaultInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/tdsql_default_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Tdsql恢复获取指定机器默认信息
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map getTdsqlInstanceDefaultMachineInfo(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/tdsql_default_machine_info", auth.cc_url);
        Response r = auth.client.get(url, args);
        return r.jsonToMap();
    }

    /**
     * Elasticsearch匹配
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map elasticsearchMatch(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/elasticsearch_match", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Elasticsearch认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map elasticsearchVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/elasticsearch_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * mysql 集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map mysqlVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/mysql_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * db2 hadr集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map db2HadrVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/db2_hadr_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * 神通集群认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map stVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/st_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * ClickHouse认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map clickHouseVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/clickhouse_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * RDS-SQLServer 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rdsSqlserverVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/rds_sqlserver_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * RDS-PostgreSQL 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map rdsPostgreSqlVerify(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/rds_postgresql_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }

    /**
     * Gbase 8s 认证
     *
     * @param args: 参数详见 API 手册
     * @return 参数详见 API 手册
     * @throws I2softException:
     */
    public Map gbase8(StringMap args) throws I2softException {
        String url = String.format("%s/vers/v3/cls/gbase8s_verify", auth.cc_url);
        Response r = auth.client.post(url, args);
        return r.jsonToMap();
    }
}