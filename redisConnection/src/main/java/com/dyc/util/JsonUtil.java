package com.dyc.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 10:42
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/27 10:42
 * @Description:
 */
public class JsonUtil {


    public static <T>T getGameParamInRedis(Jedis jedis, String key , Class<T> clazz){
        try{
            String jsonStr = (String)jedis.get( key );
            T map = null;
            if( StringUtils.isNotBlank(jsonStr) ){
                map = JSONObject.parseObject(jsonStr, clazz);
            }
            return map;
        }finally {
            //  jedis.close();
        }

    }

    public static <T>T castJsonObjectToObject( Object jsonObject , Class<T> clazz){
            T t = null;
            if( jsonObject != null ){
                String sysParamStr = JSON.toJSONString(jsonObject);
                t = (T) JSONObject.parseObject(sysParamStr,clazz);
            }
            return t;

    }


}
