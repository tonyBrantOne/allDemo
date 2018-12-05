package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2018/8/19 16:36
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.dyc.model.Server;
import com.dyc.util.RedisUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/19 16:36
 * @Description:
 */
public class Boss11Test {
    private static final Integer PORT = 6339;
    private static final String GAME_BOX = "game_box";
    private static final String HOST = "192.168.0.11";

    public static void main(String[] args) throws UnknownHostException {
        JedisCluster jedis = getRedisClute();
    //    Set<String> set = jedis.k("publish/info/*");
    //    System.out.println(set);
    //   for( String key : set ){
//            byte[] bytes = jedis.get("publish/file/package:jasper.jar:".getBytes());
//            System.out.println(bytes);
    //    }
        test1();
    }

    public static Set<String> test1( JedisCluster  jedisCluster){
        Set<String> redisKey = new HashSet<String>();
        Map<String, JedisPool> map = jedisCluster.getClusterNodes();
           for(String k : map.keySet()) {
               JedisPool jp = map.get(k);
               Jedis jedis = jp.getResource();
               Set<String> keys = jedis.keys("publish/update/package:*");
               for(String str : keys){
                   redisKey.add(str);
               }
           }
           return redisKey;
        }

    public static JedisCluster getRedisClute(){
        HostAndPort hostAndPort = new HostAndPort(HOST, PORT);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        return new JedisCluster(hostAndPortSet);
    }

    public static void test1() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();


        JedisCluster jedis = getRedisClute();
        Server server = new Server();
        server.setServerIp(inetAddress.getHostAddress());
        server.setServerName(hostName);
        String jsonStr = JSON.toJSONString(server);
        String l = jedis.set("publish/info/server:"+hostName+":",jsonStr);
    }


}
