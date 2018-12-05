package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2018/8/18 15:55
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dyc.util.RedisUtil;
import redis.clients.jedis.Jedis;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/18 15:55
 * @Description:
 */
public class Test {
    public static final String UPDATE_KEY = "publish/update/package:";
    private static final Integer PORT = 6379;
    private static final String GAME_BOX = "game_box";
    private static final String HOST = "192.168.0.10";
    private static final String[] arr = {};
    public static void main(String[] args) throws UnknownHostException {
    }

    /**
     * 获得redis的key
     * @return
     * @throws UnknownHostException
     */
    public static String getHostKeys() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();
        String keyUrl = new StringBuilder( UPDATE_KEY).append(hostName).append(":").toString();
        return keyUrl;
    }

}
