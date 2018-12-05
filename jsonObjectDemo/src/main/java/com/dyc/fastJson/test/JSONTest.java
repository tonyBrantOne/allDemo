package com.dyc.fastJson.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/25 20:41
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/25 20:41
 * @Description:
 */
public class JSONTest {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("host","192.168.0.11:6339");
        map.put("sourceBeanName","jedisTemplateData");
        String str = map.toString().replaceAll("\\s*", "");
        System.out.println(str);
        str = str.replaceAll("=","\":\"").replaceAll(",","\",\"").replaceAll("\\{","\\{\"").replaceAll("\\}","\"\\}");
        map = JSONObject.parseObject(str,Map.class);
        System.out.println(map);
        System.out.println(str);
        System.out.println(JSON.toJSONString(map));

    }

    public void test(){
        List<Map<String,Object>> list = new ArrayList<>();

        Collections.sort(list, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                return 0;
            }
        });


        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("c", 3);
        hashMap.put("a", 2);
        hashMap.put("b", 1);
        hashMap.put("d", 4);
        List<Map.Entry<String, Integer>> hashList = new ArrayList<Map.Entry<String, Integer>>(hashMap.entrySet());
        Collections.sort(hashList, new Comparator<Map.Entry<String, Integer>>() {
           @Override
           public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
               return 0;
           }
       });
    }
}
