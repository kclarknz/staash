package com.netflix.paas.rest.dao;

import com.datastax.driver.core.Cluster;
import com.netflix.paas.json.JsonObject;

public class CqlDataDaoImplNew extends  CqlDataDaoImpl{

    public CqlDataDaoImplNew(Cluster cluster, MetaDao meta) {
        super(cluster, meta);
        // TODO Auto-generated constructor stub
    }

    public String writeRow(String db, String table, JsonObject rowObj) {
        // TODO Auto-generated method stub
        return null;
    }

    public String listRow(String db, String table, String keycol, String key) {
        // TODO Auto-generated method stub
        return null;
    }

    public String writeEvent(String db, String table, JsonObject rowObj) {
        // TODO Auto-generated method stub
        return null;
    }

    public String readEvent(String db, String table, String eventTime) {
        // TODO Auto-generated method stub
        return null;
    }

    public String doJoin(String db, String table1, String table2,
            String joincol, String value) {
        // TODO Auto-generated method stub
        return null;
    }

}
