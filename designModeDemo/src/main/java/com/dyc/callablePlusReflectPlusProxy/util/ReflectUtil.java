package com.dyc.callablePlusReflectPlusProxy.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */


import com.dyc.callablePlusReflectPlusProxy.controller.BaseController;
import com.dyc.callablePlusReflectPlusProxy.model.BaseDTO;

import java.lang.reflect.Method;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ReflectUtil {


    public static Object doHandleController(Object object, String methodName, BaseDTO baseDTO ) throws Exception {
        Method method = object.getClass().getMethod(methodName,baseDTO.getClass());
        Object result = method.invoke(object,baseDTO);
        return result;
    }
}
