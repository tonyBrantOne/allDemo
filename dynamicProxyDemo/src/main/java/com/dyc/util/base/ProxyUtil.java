package com.dyc.util.base;

import com.dyc.handle.LoggerInvocationHandler;

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
        InvocationHandler invocationHandler = new LoggerInvocationHandler(obj);
        T helloProxy = (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                    new Class<?>[]{clazz},
                        invocationHandler);
        return helloProxy;
    }


}
