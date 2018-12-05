package com.dyc.redisTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyc.model.User;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 13:43
 * @Description:
 */
public class RedisFoldKeyListValTest {
    private static final String GAME_BOX = "maintenceShow:id";
    private static final String HOST = "192.168.0.13";
    private static final Integer PORT = 6339;


    public static void main(String[] args) {
        JedisCluster jedisCluster = getRedisClute();
    //    setFoldKeyByCluster(jedisCluster);
    //    setFoldKeyByClusterList(jedisCluster);
    //    getFoldKeyList(jedisCluster);
        getFoldKeyListObjet(jedisCluster);
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
            String[] strArr = new String[3];
            for( int i = 0; i < 3; i++){
                User user = new User(Long.valueOf(i),"tony"+i);
                String str = JSON.toJSONString(user);
                strArr[i] = str;
            }
            Long result = jedisCluster.rpush(key,strArr);
            System.out.println(result );
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
    }

    public static void getFoldKeyList( JedisCluster jedisCluster ){
        String key = new StringBuilder(GAME_BOX).append("1").toString();
        String str = jedisCluster.lpop(key);
        User user = JSONObject.parseObject(str,User.class);
        System.out.println(user);
    }

    public static void getFoldKeyListObjet( JedisCluster jedisCluster ){
        String key = new StringBuilder(GAME_BOX).append("1").toString();
        Object str = jedisCluster.get(key);
   //     List<User> list = JSONArray.parseArray(str,User.class);
   //     System.out.println(list);
   //     String str = jedisCluster.lpop(key);
        System.out.println(str);
    }


    public static JedisCluster getRedisClute(){
        HostAndPort hostAndPort = new HostAndPort(HOST, PORT);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        return new JedisCluster(hostAndPortSet);
    }
}
