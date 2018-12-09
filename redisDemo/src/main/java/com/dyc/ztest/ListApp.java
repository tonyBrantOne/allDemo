package com.dyc.ztest;

import com.dyc.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * title:
 * create by tony_jaa
 * date 2018/10/6
 */
public class ListApp {
    public static JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
    public static Jedis jedis;


    public static void main(String[] args) {
        jedis = jedisPool.getResource();
    //    setListByRpush();
        getListByBrpop();
    }

    public static void setListByRpush(){
        Long result = jedis.rpush("list2",new String[]{"1","2","3","4"});
        System.out.println(result);
    }

    public static void getListByBrpop(){
    //    while (true){
            List<String> list2 = jedis.brpop(3,"list2");
            System.out.println(list2);
    //    }
    }

}
