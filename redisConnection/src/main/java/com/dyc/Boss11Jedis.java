package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/10 17:51
 * @Description:
 */

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/10 17:51
 * @Description:
 */
public class Boss11Jedis {
    private static final Integer PORT = 6339;
    private static final String GAME_BOX = "game_box";
    private static final String HOST = "192.168.0.12";
    private static Jedis jedis;

    public static void main(String[] args) throws Exception {
//         jedis = new Jedis(HOST,PORT);
//         while ( true ){
//             System.out.println(jedis.ping());
//         }
        new Boss11Jedis().startMain();
    }

    public void startMain() throws Exception{
        String key = "paramMenu_:userId58menuUrl_:monitor/datebaseMonitor/list.html";
        for (int i = 0; i < 6; i++) {
            Jedis jedis2 = new Jedis(HOST,6339+i);
            System.out.println(jedis2.ping());
            System.out.println(jedis2.set(key,""));
        }
    }
}
