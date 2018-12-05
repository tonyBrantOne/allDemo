package com.dyc.stringDemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/19 11:07
 * @Description:
 */
public class StringDemo1 {

    public static void main(String[] args) throws ParseException {
     //   replaceTest();
     //   spiltLikeJson();
        switchBig();
    }

    public static void test1(){
        String path1 = "/D:/apache-tomcat-8.0.52/webapps/publishFile/WEB-INF/lib/basePub-1.0-SNAPSHOT.jar";
        path1 = path1.substring(1);
        System.out.println(path1);
    }


    public static void test2() throws ParseException {
        String createTime = "2018-09-14T07:03:49.558Z";
        createTime = createTime.replace("T"," ").replace("Z","");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = sdf.parse(createTime);
        System.out.println(date);
    }
    public static void test3(){
        String a = null;
        String str = String.valueOf(a);
        System.out.println(str);
    }

    public static void replaceTest(){
        String str = "JudgeServic2342342342e:{23234534\"5\"4";
        if( !str.startsWith("{") ){

            str = str.substring( str.split("\\{")[0].length() ,str.length() );
            System.out.println(str);
        }
    }


    public static  void spiltLikeJson(){
//        Map<String,Object> map = new HashMap<>();
//        map.put("host","192.168.0.11:6339");
//        map.put("sourceBeanName","jedisTemplateData");
//        System.out.println(map);
        String string = "{host=192.168.0.11:6339, sourceBeanName=jedisTemplateData, dataSourceName=redis.data.hosts}";
        string = string.substring(1,string.length() - 1);
        String[] arr = string.split(",");
        System.out.println(string);
    }

    public static  void spiltPunctua(){
        String str = "redis.data.hosts";
        System.out.println(str.indexOf(".",6));
        String[] a = str.split("\\.");
        System.out.println(a);
    }

    public static  void replicePunctua(){
        String str = "redis.data";
        System.out.println(str.indexOf("."));
        String a = str.replaceAll("redis\\.","");
        System.out.println(a);
    }
    public static void switchBig(){
        String str = "name";
        str = str.substring(0,1).toUpperCase() + str.substring(1,str.length());
        System.out.println(str);
    }

    public static void switchSmall(){
        String str = "name";
        str = str.substring(0,1).toLowerCase() + str.substring(1,str.length());
        System.out.println(str);
    }
}
