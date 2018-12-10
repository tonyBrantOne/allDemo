package com.dyc.ztest;

import com.dyc.util.JedisPoolUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * title:测试lua脚本
 * create by tony_jaa
 * date 2018/11/18
 */
public class RedisLuaTest {
    JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
    private static final String KEY = "key";

    public static void main(String[] args) throws Exception {
        new RedisLuaTest().startTest();
    }

    public void startTest() throws Exception {
    //    setJedis();
    //    delJedis();
    }
    public void setJedis(){
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.set(KEY,"123"));
    }

//    public void delJedis() throws Exception {
//        Jedis jedis = jedisPool.getResource();
//        String name = "E:\\progect\\allDemo\\redisDemo\\src\\main\\java\\com\\dyc\\unLock.lua";
//        String scriptStr = getFileStr(name);
//        System.out.println(scriptStr);
//        Object object = jedis.eval(scriptStr, Arrays.asList(KEY) ,Arrays.asList("123"));
//        System.out.println(object);
//    }
//
//    public String getFileStr( String name ) throws Exception {
//        InputStreamReader inputReader = null;
//        BufferedReader bf = null;
//        try {
//            File file = new File(name);
//            System.out.println("exist:"+file.exists());
//            inputReader = new InputStreamReader(new FileInputStream(file));
//            bf = new BufferedReader(inputReader);
//            // 按行读取字符串
//            String str;
//            StringBuilder stringBuilder = new StringBuilder("");
//            while ((str = bf.readLine()) != null) {
//                stringBuilder.append(str);
//            }
//            return stringBuilder.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }finally {
//            bf.close();
//            inputReader.close();
//        }
//    }
}
