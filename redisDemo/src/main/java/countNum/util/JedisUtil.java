package countNum.util;

import com.dyc.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/18
 */
public class JedisUtil {

    public static Jedis getJedis(){
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
        }
        return jedis;
    }
}
