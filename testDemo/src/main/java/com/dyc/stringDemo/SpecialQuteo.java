package com.dyc.stringDemo;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/8 09:42
 * @Description:
 */
public class SpecialQuteo {

    private static final String sql = "select count(1) as current_connections from pg_stat_activity where id = #{selId} and name = #{nameStr} or type = #{typeStr}";
    private static final String regux = "#\\{(\\S*)}";

    public static void main(String[] args) {
        String a = sql.replaceAll(regux,"?");
        //   System.out.println(a);
        System.out.println(sql);
        String b = sql.replaceAll(regux,"");
        System.out.println(b);
    }




}
