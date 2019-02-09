package com.dyc;
/**
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
    private static final String HOST = "192.168.0.12";
    private JedisCluster jedis;

    public static void main(String[] args) throws Exception {
    //    Set<String> set = jedis.k("publish/info/*");
    //    System.out.println(set);
    //   for( String key : set ){
//            byte[] bytes = jedis.get("publish/file/package:jasper.jar:".getBytes());
//            System.out.println(bytes);
    //    }
   //      test1();
        new Boss11Test().startMain();
    }

    public void startMain() throws Exception{
        test2();
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


    public void test2() throws Exception {
        String key = "paramMenu_:userId58menuUrl_:monitor/datebaseMonitor/list.html";
        for (int i = 0; i < 6; i++) {
            JedisCluster jedisCluster = getRedisClute(HOST,6399);
            System.out.println(jedisCluster.del(key));
        }
    }

    public static JedisCluster getRedisClute( String host,int port){
        HostAndPort hostAndPort = new HostAndPort(host, port);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        return new JedisCluster(hostAndPortSet);
    }


}
