package com.dyc.util;

import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisUtil {
 //   private static final String HOST = "192.168.150.132";
    private static final String HOST = "192.168.0.11";
    private static final Integer PORT = 6339;


    public static void main(String[] args) throws InterruptedException {
        Jedis jedis = getRedis(HOST,PORT);
    //    Set<String> keys = jedis.keys("*");
        for(;;){
            System.out.println(jedis.get("41530856300483"));
            Thread.sleep(1000);
        }
    }

    public static Jedis getRedis(String HOST,Integer PORT){
        Jedis jedis = new Jedis(HOST,PORT);
        System.out.println(jedis.ping());
        return jedis;
    }



}
