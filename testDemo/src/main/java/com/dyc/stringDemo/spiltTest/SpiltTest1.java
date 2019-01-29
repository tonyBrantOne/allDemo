package com.dyc.stringDemo.spiltTest;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/8 14:39
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/8 14:39
 * @Description:
 */
public class SpiltTest1 {
    private static final String path = "jdbc:postgresql://192.168.0.10:5432/boss?currentSchema=site-3&characterEncoding=UTF-8";
    public static void main(String[] args) {
       String s = path.split("\\?")[0].split("//")[1];
        System.out.println(s);
    }
}
