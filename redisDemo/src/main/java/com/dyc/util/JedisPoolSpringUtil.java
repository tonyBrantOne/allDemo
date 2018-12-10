package com.dyc.util;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPoolConfig;

/**
 * title:
 * create by tony_jaa
 * date 2018/10/4
 */
public class JedisPoolSpringUtil {

    private static volatile JedisConnectionFactory jedisConnectionFactory = null;

    private JedisPoolSpringUtil() {};

    public static JedisConnectionFactory getJedisConnectionFactoryInstance(){
        if( null == jedisConnectionFactory ){
            synchronized ( JedisConnectionFactory.class ){
                if( null == jedisConnectionFactory ){
                    JedisPoolConfig jedisPoolConfig = getJedisPoolConfig();
                    jedisConnectionFactory = new JedisConnectionFactory();
                    jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
                    setJedisConnectionFactoryConfig(jedisConnectionFactory);
                }
            }
        }
        return jedisConnectionFactory;

    };


    /**
     * jedis池配置
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
        return jedisPoolConfig;
    }

    /**
     * jedis连接工厂数据源的配置
     * @param jedisConnectionFactory
     */
    private static void setJedisConnectionFactoryConfig( JedisConnectionFactory jedisConnectionFactory){
        jedisConnectionFactory.setHostName("192.168.16.131");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setTimeout(3000);
        jedisConnectionFactory.setDatabase(0);
    }


}
