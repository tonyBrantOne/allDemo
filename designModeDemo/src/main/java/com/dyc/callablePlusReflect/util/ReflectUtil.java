package com.dyc.callablePlusReflect.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */

import com.dyc.callablePlusReflect.controller.BaseController;
import com.dyc.callablePlusReflect.model.BaseDTO;

import java.lang.reflect.Method;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ReflectUtil {


    public static Object doHandleController(BaseController baseController, String methodName, BaseDTO baseDTO ) throws Exception {
        Method method = baseController.getClass().getMethod(methodName,baseDTO.getClass());
        Object object = method.invoke(baseController,baseDTO);
        return object;
    }
}
