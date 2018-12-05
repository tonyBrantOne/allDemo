package com.dyc.handle;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggerInvocationHandler implements InvocationHandler {
    public Object target;

    public LoggerInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 代理类调用任何方法都会到invoke这个方法里，从mehtod这个方法里就可以知道应该调用被代理类的哪个方法了。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行：=="+method.getDeclaringClass().getName()+"类=====执行："+method.getName());
        System.out.println("传入的参数："+args[0]);
        Object result =  method.invoke(target,args);
        System.out.println("执行后返回值:" + result);
        return result;
    }
}
