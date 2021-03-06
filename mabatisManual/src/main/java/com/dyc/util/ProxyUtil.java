package com.dyc.util;

import com.dyc.sqlSession.DefaultSqlSession;
import com.dyc.sqlSession.SqlSession;
import com.dyc.util.listen.MappedProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    /**
     * 通class对象决定返回值类型
     * @param clazz
     * @param obj
     * @param <T>
     * @return
     */
    public static <T>T getInstance(Class<T> clazz, Object obj){
        InvocationHandler invocationHandler = new MappedProxy((DefaultSqlSession) obj);
        T helloProxy = (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                    new Class<?>[]{clazz},
                        invocationHandler);
        return helloProxy;
    }


}
