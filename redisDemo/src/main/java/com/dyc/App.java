package com.dyc;

import com.dyc.util.JedisPoolSpringUtil;
import com.dyc.util.JedisPoolUtil;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        test1();
    }

    /**
     * 最简单的jedis配置
     */
    public static void test1(){
        Jedis jedis = new Jedis("192.168.16.131",6379);
        System.out.println(jedis.ping());
        Set<String> a = jedis.keys("*");
        jedis.set("b","1");
        System.out.println(a);
    }

    public static void test2(){
   //     JedisPool
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String result = jedis.set("pool1","jedis2");
            System.out.println("result=="+result);
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }

    /**
     *
     */
    public static void test3(){
        JedisConnectionFactory jedisConnectionFactory = JedisPoolSpringUtil.getJedisConnectionFactoryInstance();
        Jedis jedis = null;
        try {
            RedisConnection redisConnection = jedisConnectionFactory.getConnection();
            Object object  = redisConnection.getNativeConnection();
//            Object object2 = jedisConnectionFactory.getConnection().getNativeConnection();
//            if( object == object2){
//                System.out.println("两次值相等");
//                return;
//            }
            if( object instanceof Jedis){
                jedis = (Jedis) object;
            }
            String result = jedis.set("pool1","jedis2");
            System.out.println("result=="+result);
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            jedis.close();
        }
    }



}
