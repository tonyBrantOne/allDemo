package com.dyc.redisTest;

import com.dyc.util.RedisUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 13:43
 * @Description:
 */
public class RedisFoldKeyTest {
    private static final String GAME_BOX = "maintenceShow:id";
    private static final String HOST = "192.168.0.13";
    private static final Integer PORT = 6339;


    public static void main(String[] args) {
        JedisCluster jedisCluster = getRedisClute();
    //    setFoldKeyByCluster(jedisCluster);
   //     setFoldKeyByClusterList(jedisCluster);
        getFoldKeyList(jedisCluster);
    }

    public static void setFoldKeyByCluster(JedisCluster jedisCluster){
        try {
            for( int i = 0; i < 10; i++){
                System.out.println( jedisCluster.set(new StringBuilder(GAME_BOX).append(i+"").toString(),i+""));
                System.out.println(jedisCluster.get(new StringBuilder(GAME_BOX).append(i+"").toString()));
            }
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    public static void setFoldKeyByClusterList(JedisCluster jedisCluster){
        try {
            String key = new StringBuilder(GAME_BOX).append("1").toString();
            jedisCluster.del(key);
            String[] strArr = {"1","2","3"};
            Long result = jedisCluster.rpush(key,strArr);
            System.out.println(result );
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    public static void getFoldKeyList( JedisCluster jedisCluster ){
        String key = new StringBuilder(GAME_BOX).append("1").toString();
        String str = jedisCluster.lpop(key);
        System.out.println(str);
    }


    public static JedisCluster getRedisClute(){
        HostAndPort hostAndPort = new HostAndPort(HOST, PORT);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        return new JedisCluster(hostAndPortSet);
    }
}
