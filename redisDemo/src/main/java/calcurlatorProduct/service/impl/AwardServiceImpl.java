package calcurlatorProduct.service.impl;

import calcurlatorProduct.CalProTest;
import calcurlatorProduct.service.AwardService;
import calcurlatorProduct.util.ConstantMap;
import com.dyc.util.JedisPoolUtil;
import countNum.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Random;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/18
 */
public class AwardServiceImpl implements AwardService {
    JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();

    @Override
    public void calSubAward() {
        Jedis jedis = jedisPool.getResource();
        /**
         * 第一次redis没值，则把总金额放入redis中
         */
        jedis.setnx(ConstantMap.MONEY_KEY , ConstantMap.allMoney + "");
        /**
         * 保持增加减少金额的原子性
         */
        if( jedis.incrBy(ConstantMap.MONEY_KEY,-100) >= 0 ){
            System.out.println(Thread.currentThread().getName() + ":恭喜抽中");
        }else{
            System.out.println("不好意思");
        }
        ConstantMap.countDownLatchEnd.countDown();
    }

    @Override
    public void calSubAwardUnHandleAomic() {
        Jedis jedis = jedisPool.getResource();
        String allMoney = jedis.get(ConstantMap.MONEY_KEY);
        if( allMoney == null ){
            jedis.set(ConstantMap.MONEY_KEY , ConstantMap.allMoney + "");
        }
        String money = jedis.get(ConstantMap.MONEY_KEY);
        Integer currentMoney = Integer.valueOf(money) - 100;
        if( currentMoney > 0){
            jedis.set(ConstantMap.MONEY_KEY , currentMoney + "");
            System.out.println(Thread.currentThread().getName() + ":恭喜抽中:"+currentMoney);
        }else{
            System.out.println("不好意思");
        };
        ConstantMap.countDownLatchEnd.countDown();
    }
}
