package com.dyc;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyc.fastJson.model.User;
import com.dyc.fastJson.util.FastJsonListObjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<User> list = new ArrayList<User>();
       for(int i = 0; i < 2; i++){
           User user = new User("i"+i, Long.valueOf(i));
           list.add(user);
       }
       test2(list);
//       String str = FastJsonListObjectUtil.toJsonStr(list,User.class);
//        System.out.println(str);
//       List<User> list1 = FastJsonListObjectUtil.toListObject(str,User.class);
//       System.out.println(list1);
    }


    public static void test2( List<User> list ){
        List<JSONObject> listJSONObject = FastJsonListObjectUtil.toJsonListJSONObject(list);
        List<User> userList = FastJsonListObjectUtil.toListObject(JSONArray.toJSONString(listJSONObject),User.class);
        System.out.println(userList);
    }
}
