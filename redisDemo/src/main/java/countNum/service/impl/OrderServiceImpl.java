package countNum.service.impl;

import countNum.RedisCountTest;
import countNum.service.OrderService;
import countNum.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/18
 */
public class OrderServiceImpl implements OrderService {
    public static Integer allMoney = 1000;
    private Jedis jedis = JedisUtil.getJedis();
    @Override
    public void purchaseProduct() {
        String randomKey = new Random().nextInt()+"";
        String result = jedis.set("countLock",randomKey,"nx","ex",60 * 60);
        if( result != null ){
            allMoney = allMoney - 100;
            System.out.println("当前剩余："+allMoney);
            RedisCountTest.endCountDownLatch.countDown();
            try {
                delJedis(randomKey);
            } catch (Exception e) {
                e.printStackTrace();
            }
      //      jedis.del("countLock");
        }else{
            this.purchaseProduct();
        }
    }


    public void delJedis(String randomKey) throws Exception {
        String name = "E:\\progect\\allDemo\\redisDemo\\src\\main\\java\\com\\dyc\\unLock.lua";
        String scriptStr = getFileStr(name);
        Object object = jedis.eval(scriptStr, Arrays.asList("countLock") ,Arrays.asList(randomKey));
    }

    public String getFileStr( String name ) throws Exception {
        InputStreamReader inputReader = null;
        BufferedReader bf = null;
        try {
            File file = new File(name);
            inputReader = new InputStreamReader(new FileInputStream(file));
            bf = new BufferedReader(inputReader);
            // 按行读取字符串
            String str;
            StringBuilder stringBuilder = new StringBuilder("");
            while ((str = bf.readLine()) != null) {
                stringBuilder.append(str);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }finally {
            bf.close();
            inputReader.close();
        }
    }

}
