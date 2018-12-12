package com.dyc.callablePlusReflectPlusProxy.handle;
/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 15:08
 * @Description:
 */

import com.dyc.callablePlusReflectPlusProxy.annotion.AutoMapping;
import com.dyc.callablePlusReflectPlusProxy.controller.BaseController;
import com.dyc.callablePlusReflectPlusProxy.model.BaseDTO;
import com.dyc.callablePlusReflectPlusProxy.util.ThreadPoolUtil;
import org.apache.commons.lang3.StringUtils;

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
        String value = this.judgeIsEmpty(method,AutoMapping.class);
        if( StringUtils.isBlank(value) ) return null;
        FutureTask<BaseDTO> futureTask = ThreadPoolUtil.execute(target,value,(BaseDTO) args[0]);
        return futureTask;
    }

    public String judgeIsEmpty( Method method, Class clazz ){
        AutoMapping autoMapping = method.getAnnotation(AutoMapping.class);
        if( autoMapping == null ) return null;
        String[] value = autoMapping.value();
        if( null == value || value.length == 0 ) return null;
        return value[0];
    }
}
