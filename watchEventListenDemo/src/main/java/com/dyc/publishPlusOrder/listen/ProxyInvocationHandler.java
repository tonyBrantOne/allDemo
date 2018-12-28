package com.dyc.publishPlusOrder.listen;



import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.util.ReflectUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.concurrent.FutureTask;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 15:08
 * @Description:
 */
public class ProxyInvocationHandler implements InvocationHandler {

    public Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(target);
//        System.out.println(method.getName());
        Object object = ReflectUtil.invoke(target,method.getName(), (MonitorDTO) args[0]);
        return object;
    }

}
