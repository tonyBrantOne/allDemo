package com.dyc.callablePlusReflectPlusProxy.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */


import com.dyc.callablePlusReflectPlusProxy.controller.BaseController;
import com.dyc.callablePlusReflectPlusProxy.model.BaseDTO;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ThreadPoolUtil {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

    public static FutureTask<BaseDTO> execute(Object object, String methodName, BaseDTO baseDTO) throws Exception {
        FutureTask<BaseDTO> futureTask = new FutureTask(new ThreadPoolUtil().new CommonCallable(object,methodName,baseDTO));
        executorService.submit(futureTask);
        return futureTask;
    }


    class CommonCallable implements Callable<BaseDTO> {

        Object object;
        String methodName;
        BaseDTO baseDTO;

        public CommonCallable(Object object, String methodName, BaseDTO baseDTO) {
            this.object = object;
            this.methodName = methodName;
            this.baseDTO = baseDTO;
        }

        @Override
        public BaseDTO call() throws Exception {
            System.out.println("正在运行异步任务");
            Thread.sleep(3000);
            Object result = ReflectUtil.doHandleController(object,methodName,baseDTO);
            BaseDTO t = (BaseDTO) result;
            System.out.println("运行结束");
            return t;
        }


    }

}
