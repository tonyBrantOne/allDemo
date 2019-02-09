package com.dyc.hashCodeDemo;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/4 14:01
 * @Description:
 */
public class identifyHashCodeTest {
    private static final String key = "host:jdbc:postgresql://192.168.0.12:5432/boss?currentSchema=manager&characterEncoding=UTF-8";
    private static final String key2 = "host:jdbc:postgresql://192.168.0.12:5432/boss?currentSchema=manager&characterEncoding=UTF-8";

    public static void main(String[] args) {
       int integer = System.identityHashCode(key);
       int integer2 = System.identityHashCode(key2);
        System.out.println(integer);
        System.out.println(integer2);
    }

}
