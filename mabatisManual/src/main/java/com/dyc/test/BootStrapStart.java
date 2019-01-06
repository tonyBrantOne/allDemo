package com.dyc.test;

import com.dyc.dao.UserDao;
import com.dyc.sqlSession.SqlSession;
import com.dyc.sqlSession.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * title:
 * create by tony_jaa
 * date 2019/1/6
 */
public class BootStrapStart {

    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id","1");
        map.put("name","tony");
        List<Map<String, Object>> resultMap = userDao.selectList(map);
    //    Map<String, Object> resultMap = userDao.selectByPrimaryKey(map);
        System.out.println("返回值"+resultMap);
    }
}
