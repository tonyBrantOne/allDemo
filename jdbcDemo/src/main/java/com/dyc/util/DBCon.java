package com.dyc.util;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/3 17:41
 * @Description:
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/3 17:41
 * @Description:
 */
public class DBCon {



    private static final String DRIVER = "org.postgresql.Driver";
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    private static String host= "jdbc:postgresql://192.168.0.12:5432/boss?currentSchema=site-3&characterEncoding=UTF-8";
    private static String user = "manager";
    private static String password = "manager";
    /**
     * @return返回数据库连接对象
     */
    public  Connection getCon() throws Exception{
            Connection con = null;
            //注册驱动
            Class.forName(DRIVER);
            con=DriverManager.getConnection( host, user , password );
            return con;
    }

    /**
     * 关闭所有数据库连接资源
     */
    public static void closeAll( PreparedStatement ps, ResultSet rs ) throws Exception {
        if(rs!=null) rs.close();
        if(ps!=null) ps.close();
    }


    /**
     * @param
     * @param
     * @return返回结果集
     */
    public  ResultSet query( Connection con,String sql,String... pras ) throws Exception{
            //创建预编译处理对象
            PreparedStatement ps=con.prepareStatement(sql);
            //为参数赋值
            if(pras!=null){
                //遍历每个参数进行赋值
                for(int i=0;i<pras.length;i++){
                    ps.setString(i+1, pras[i]);
                }
            }
            //执行查询命令
            ResultSet rs=ps.executeQuery();
            //这里不要写关闭所有资源
            return rs;
    }

    /**
     * @param
     * @param
     * @return返回结果集
     */
    public static ResultSet query(  PreparedStatement ps,String sql,String... pras ) throws Exception{
        //为参数赋值
        if(pras!=null){
            //遍历每个参数进行赋值
            for(int i=0;i<pras.length;i++){
                ps.setString(i+1, pras[i]);
            }
        }
        //执行查询命令
        ResultSet rs=ps.executeQuery();
        //这里不要写关闭所有资源
        return rs;
    }




}
