package com.dyc.test;

import com.dyc.util.DBCon;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/17 11:12
 * @Description:
 */
public class NumersConnection {
    private static String  sql = "select count(1) as current_connections from pg_stat_activity";

    public static void main(String[] args) throws Exception {
        Long current_connections = 0L;
       while (true){
           if( current_connections.intValue() >= 900 ) continue;
           DBCon dbCon = new DBCon();
           Connection connection = dbCon.getCon();
           ResultSet resultSet = dbCon.query(connection,sql,null);
           List<Map<String, Object>> list = parasRs(resultSet);
           current_connections = (Long) list.get(0).get("current_connections");
           System.out.println(current_connections.intValue());
           if( current_connections.intValue() >= 950 ){
               Thread.sleep(1000);
           }
       }
    }

    public static List<Map<String, Object>> parasRs( ResultSet resultSet ) throws SQLException {
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData md = resultSet.getMetaData(); //获得结果集结构信息,元数据
        int columnCount = md.getColumnCount();   //获得列数
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<String, Object>(columnCount);
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), resultSet.getObject(i));
            }
            list.add(rowData);
        }
        return list;
    }
}
