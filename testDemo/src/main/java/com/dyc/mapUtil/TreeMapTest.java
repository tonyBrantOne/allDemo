package com.dyc.mapUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/23 14:46
 * @Description:
 */
public class TreeMapTest {
    public static Map<String,String> firstMap = new HashMap<>();
    public static Map<String, Map<String,String>> allChildrenMap = new HashMap<>();
    public static void main(String[] args) {
//        firstMap.put("systemCode","系统");
//        firstMap.put("monitorCode","监控");
//
//        Map<String,String> childrenMap1 = new HashMap<>();
//        childrenMap1.put("gameLogsCode","数据异常");
//        childrenMap1.put("dbErrCode","数据源");
//
//
//        Map<String,String> childrenMap2 = new HashMap<>();
//        childrenMap2.put("maintenice","维护");
//
//        allChildrenMap.put("systemCode",childrenMap1);
//        allChildrenMap.put("monitorCode",childrenMap2);

        TreeMapTest.setInnerMap();

    }

    public void getProperty(){
//            StandardServletEnvironment standardServletEnvironment = (StandardServletEnvironment) environment;
//            MutablePropertySources mutablePropertySources = standardServletEnvironment.getPropertySources();
//            org.springframework.core.env.PropertySource<?> propertySource = mutablePropertySources.get( "class path resource [conf/dubbo-version-conf.properties]" );
//            ResourcePropertySource resourcePropertySource = (ResourcePropertySource) propertySource;
//            Map<String,Object> resultMap = new HashMap<>();
//            resourcePropertySource.getSource().forEach((k,v)->{ if ( k.contains("redis")) resultMap.put(k.split("\\.")[1],k);});
//            //        Map<String,Object> newList = map.entrySet().stream().filter((e) -> checkValue(e.getValue()))
////                .collect(Collectors.toMap( (e) -> (String) e.getKey(), (e) -> e.getValue()
////        ));
//            return resultMap;
    }


    public static void setInnerMap(){
        Map<String,String> map = new HashMap<>();
        String a = map.get("1");
        if( null == a) map.put("1","2");
        System.out.println(a);
    }
}
