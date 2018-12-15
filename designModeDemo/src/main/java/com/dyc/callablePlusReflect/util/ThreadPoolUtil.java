package com.dyc.callablePlusReflect.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */

import com.dyc.callablePlusReflect.controller.BaseController;
import com.dyc.callablePlusReflect.model.BaseDTO;
import com.dyc.callablePlusReflect.model.RoleDTO;

import java.lang.reflect.Method;
import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ThreadPoolUtil<T> {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
    public static <T>FutureTask<T> execute( BaseController baseController, String methodName,  BaseDTO baseDTO,Class<T> clazz) throws Exception {
        FutureTask<T> futureTask = new FutureTask(new ThreadPoolUtil().new CommonCallable(baseController,methodName,baseDTO));
        executorService.submit(futureTask);
        return futureTask;
    }


    class CommonCallable implements Callable<T> {

        BaseController baseController;
        String methodName;
        BaseDTO baseDTO;

        public CommonCallable(BaseController baseController, String methodName, BaseDTO baseDTO) {
            this.baseController = baseController;
            this.methodName = methodName;
            this.baseDTO = baseDTO;
        }

        @Override
        public T call() throws Exception {
            System.out.println("正在运行异步任务");
            Thread.sleep(3000);
            Object object = ReflectUtil.doHandleController(baseController,methodName,baseDTO);
            T t = (T) object;
            System.out.println("运行结束");
            return t;
        }


    }

}
