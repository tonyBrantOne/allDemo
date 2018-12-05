package com.dyc.redisTest;/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 16:57
 * @Description:
 */

import com.dyc.util.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/5 16:57
 * @Description:
 */
public class RedisOneTest {
    private static final String GAME_BOX = "maintenceShowObj:userId_";
    private static final String HOST = "192.168.0.13";
    private static final Integer PORT = 6339;

    public static void main(String[] args) {
        Jedis jedis = RedisUtil.getRedis(HOST,PORT);
    }
}
