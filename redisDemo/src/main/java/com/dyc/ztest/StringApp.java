package com.dyc.ztest;

import com.dyc.util.JedisPoolUtil;
import countNum.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * title:
 * create by tony_jaa
 * date 2018/10/6
 */
public class StringApp {
    JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
    private static Jedis jedis = JedisUtil.getJedis();


    public static void main(String[] args) {
        String result = jedis.set("countLock","111","nx","ex",10);
        System.out.println(result == null);
    }

}
