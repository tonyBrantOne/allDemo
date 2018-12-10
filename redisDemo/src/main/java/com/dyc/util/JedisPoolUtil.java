package com.dyc.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * title:JedisPool工具类
 * create by tony_jaa
 * date 2018/10/3
 */
public class JedisPoolUtil {

    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil() {};

    /**
     * 获取单列连接池，保证豪仔里只有一个游泳池
     * @return
     */
    public static JedisPool getJedisPoolInstance(){
        if( null == jedisPool ){
            synchronized ( JedisPool.class ){
                if(  null == jedisPool  ){
                    JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
                    jedisPool = new JedisPool(jedisPoolConfig,"192.168.16.131",6379);
                }
            }
            return jedisPool;
        }else{
            return jedisPool;
        }
    }

    /**
     * jedis连接池配置
     * @return
     */
    private static JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        /**
         * 最多
         */
        jedisPoolConfig.setMaxTotal(1000);
        /**
         * 控制一个pool最多有多少个状态为idle空闲的jedis实例。
         */
        jedisPoolConfig.setMaxIdle(32);
        /**
         * 借实例时，最大等待时长。超过这个时间抛出异常。
         */
        jedisPoolConfig.setMaxWaitMillis(100*1000);
        /**
         * 获取jedis实例时，是否检查连接的可用性。
         */
        jedisPoolConfig.setTestOnBorrow(true);
        return jedisPoolConfig;
    }

    public static void relaseCon(JedisPool jedisPool, Jedis jedis){
        try {
            if( null != jedis ){
                jedisPool.returnResourceObject(jedis);
            }
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {

        }
    }
}
