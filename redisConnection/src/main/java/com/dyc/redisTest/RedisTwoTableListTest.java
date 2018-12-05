package com.dyc.redisTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyc.model.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 16:16
 * @Description:
 */
public class RedisTwoTableListTest {

    private static final String GAME_BOX = "maintenceShowObj:orderId_:userId_";
    private static final String HOST = "192.168.0.11";
    private static final Integer PORT = 6339;
    private static JedisCluster jedisClusterSingle;

    static {
        jedisClusterSingle = getRedisClute();
    }

    public static JedisCluster getRedisClute(){
        HostAndPort hostAndPort = new HostAndPort(HOST, PORT);
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(hostAndPort);
        return new JedisCluster(hostAndPortSet);
    }


    public static void main(String[] args) throws InterruptedException {
    //    setFoldKeyByClusterList(getRedisClute());
    //    getFoldKeyByClusterList(getRedisClute());
    //    update(getRedisClute());
    //    getCountNum(getRedisClute());
    //     delKeys(getRedisClute());
    //    getBroopLpushAllVal();
        getParamMerry();
    }

    public static void setFoldKeyByClusterList(JedisCluster jedisCluster){
        Order order = new Order(1,"1233",1);
        String str = jedisCluster.set("maintenceShowObj", JSON.toJSONString(order));
        System.out.println(str);
    }

    public static void update(JedisCluster jedisCluster){
        Order order = new Order(3,"3",1);
        String str = jedisCluster.set("maintenceShowObj", JSON.toJSONString(order));
        System.out.println(str);
        System.out.println("GAME_BOX==="+GAME_BOX+"*");
  //      System.out.println(jedisCluster.del(GAME_BOX+"*"));
    }





    public static void getFoldKeyByClusterList(JedisCluster jedisCluster){
        String strJson = jedisCluster.get("maintenceShowObj");
        Order order = JSONObject.parseObject(strJson,Order.class);
        String key1 = "maintenceShowObj:orderId_"+order.getId()+":userId_";
        for( int i = 0; i < 3; i++ ){
            String key = key1 + i;
            Long str = jedisCluster.setnx(key,i+"");
            System.out.println(str);
            String result = jedisCluster.get(key);
            System.out.println("key=="+key+" result=="+result);
        }
    }

    public static void getCountNum(JedisCluster jedisCluster) throws InterruptedException {
        while (true){
            Thread.sleep(1000);
            String strJson = jedisCluster.get("messageCenterCountNum:userId_0");
            System.out.println(strJson);
        }
    }

    public static void delKeys(JedisCluster jedisCluster) throws InterruptedException {
        System.out.println(jedisCluster.del("maintenceShowObj"));
    }


    public static void setLoopAllVal(){
        String key = "messageReadFlag:userId_"+0;
        for( int i = 0; i < 3; i++){
            System.out.println(jedisClusterSingle.rpush(key,i+""));
        }
    }

    public static void getLoopAllVal(){
        String key = "messageReadFlag:userId_"+0;
        List<String> a = jedisClusterSingle.blpop(10000,"messageReadFlag:userId_"+0);
        System.out.println(a);
    }

    public static void getBroopLpushAllVal(){
        String key = "messageReadFlag:userId_"+0;
     //   List<String> a = jedisClusterSingle.br
        String s = jedisClusterSingle.get(key);
        System.out.println(s);
    }

    public static void getParamMerry(){
        String key = "paramMenu_:userId8menuUrl_:monitor/redisMonitor/list.html";
        //   List<String> a = jedisClusterSingle.br
        String s = jedisClusterSingle.get(key);
        System.out.println(s);
    }

}
