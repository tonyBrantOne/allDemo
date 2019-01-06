package com.dyc.excutor;

import com.dyc.config.MappedStatement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * title:
 * create by tony_jaa
 * date 2019/1/6
 */
public class DefaultExcutor implements Excutor {

    @Override
    public <E> List<E> query(MappedStatement ms, Object parameter) {
        System.out.println("要执行的sql:"+ms.getSql());
        Map<String, String> sortMap = ms.getParamSortMap();
        Map<String,Object> map = (Map<String, Object>) parameter;
        for(Map.Entry<String, String> entry : sortMap.entrySet()){
            System.out.println("第"+ entry.getKey()+"个参数值：" + map.get(entry.getValue()));
        }
    //    System.out.println("参数："+map);
        map.put("id","1");
        List<Map<String,Object>> list = new ArrayList();
        list.add(map);
        return (List<E>) list;
    }
}
