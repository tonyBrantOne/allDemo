package com.dyc.fileInOut;/**
 * @Auther: tony_jaa
 * @Date: 2018/8/18 15:55
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyc.fileInOut.constants.FileConstants;
import com.dyc.fileInOut.constants.RedisConstants;
import com.dyc.fileInOut.model.ProductServer;
import com.dyc.fileInOut.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Set;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/18 15:55
 * @Description:
 */
public class Test {
    public static final String UPDATE_KEY = "publish/update/package:";
    private static final String[] arr = {"aaa:soul.jar","bbb:pub.jar"};
    public static void main(String[] args) throws UnknownHostException {
//        Jedis jedis = RedisUtil.getRedis(RedisConstants.HOST,RedisConstants.PORT);
//        for( int i = 0; i < 2; i++){
//            String keyUrl = getHostKeys();
//            keyUrl += arr[i];
//            System.out.println(keyUrl);
//            ProductServer productServer = new ProductServer();
//            productServer.setStatus("2");
//        //    productServer.setFilePath("files/SG/0/headImage/1/1534504703696.png");
//            productServer.setFilePath("war/jasper.jar/20180818/jasper.jar");
//            String jsonStr = JSON.toJSONString(productServer);
//            String l = jedis.set(keyUrl,jsonStr);
//
//        }
        getHostKeys();
    }

    /**
     * 获得redis的key
     * @return
     * @throws UnknownHostException
     */
    public static String getHostKeys() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();
        System.out.println(hostName);
        String keyUrl = new StringBuilder( UPDATE_KEY).append(hostName).append(":").toString();
        return keyUrl;
    }
    public static void getHostKeys2() throws UnknownHostException {
        Jedis jedis = RedisUtil.getRedis(RedisConstants.HOST,RedisConstants.PORT);
        String keyInfoUrl = "publish/info/package:MicroWin10-1353:bbb:pub.jar";
        String jsonPack = (String)jedis.get( keyInfoUrl );
        System.out.println(jsonPack);
        ProductServer productServer = JSONObject.parseObject(jsonPack,ProductServer.class);
        productServer.setStatus("3");
        String jsonStr = JSON.toJSONString(productServer);
      //  jedis.set(keyUrl,jsonStr);
    }

}
