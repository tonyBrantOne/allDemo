package com.dyc.publishPlusOrder.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */


import com.dyc.publishPlusOrder.model.MonitorDTO;

import java.lang.reflect.Method;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ReflectUtil {


    public static Object invoke(Object object, String methodName, MonitorDTO baseDTO ) throws Exception {
        Method method = object.getClass().getMethod(methodName,baseDTO.getClass());
        Object result = method.invoke(object,baseDTO);
        return result;
    }
}
