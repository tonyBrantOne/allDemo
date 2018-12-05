package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 10:43
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.dyc.model.Product;
import com.dyc.model.Server;
import com.dyc.model.User;
import com.dyc.util.JsonUtil;
import com.dyc.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 10:43
 * @Description:
 */
public class GameRedisStart {

 //   private static final String HOST = "192.168.150.132";
    private static final Integer PORT = 6339;
    private static final String GAME_BOX = "game_box";
    private static final String HOST = "192.168.0.11";

    public static void main(String[] args) throws InterruptedException, UnknownHostException {
//        Jedis jedis = RedisUtil.getRedis(HOST,PORT);
//
//
//        Map gameBoxMap = JsonUtil.getGameParamInRedis(jedis,GAME_BOX,Map.class);
//        if( gameBoxMap != null){
//            Object userMap = gameBoxMap.get("tony");
//            if( userMap != null ){
//                User a = JsonUtil.castJsonObjectToObject(userMap,User.class);
//                System.out.println(a.getClass().getName());
//                return;
//            }
//        }
//        User user = new User("tony","dyc");
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("tony",user);
//        String jsonStr = JSON.toJSONString(map);
//        String l = jedis.set(GAME_BOX,jsonStr);

//        for(;;){
//            System.out.println(jedis.get("41530856300483"));
//            Thread.sleep(1000);
//        }
        test1();
    }

    public static void test1() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();


        Jedis jedis = RedisUtil.getRedis(HOST,PORT);
        Server server = new Server();
        server.setServerIp(inetAddress.getHostAddress());
        server.setServerName(hostName);
        String jsonStr = JSON.toJSONString(server);
        String l = jedis.set("publish/info/server:"+hostName+":",jsonStr);
    }

}
