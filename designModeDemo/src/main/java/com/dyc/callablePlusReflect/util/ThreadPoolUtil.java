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
public class ThreadPoolUtil {
    private static ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

    public static BaseDTO execute( BaseController baseController, String methodName,  BaseDTO baseDTO) throws Exception {
        Callable callable = new ThreadPoolUtil().new CommonCallable(baseController,methodName,baseDTO);
        FutureTask<BaseDTO> futureTask = new FutureTask(callable);
        executorService.submit(futureTask);
        return futureTask.get();
    }


    class CommonCallable implements Callable<BaseDTO> {

        BaseController baseController;
        String methodName;
        BaseDTO baseDTO;

        public CommonCallable(BaseController baseController, String methodName, BaseDTO baseDTO) {
            this.baseController = baseController;
            this.methodName = methodName;
            this.baseDTO = baseDTO;
        }

        @Override
        public BaseDTO call() throws Exception {
            System.out.println("休眠中");
            Thread.sleep(3000);
            Object object = ReflectUtil.doHandleController(baseController,methodName,baseDTO);
            BaseDTO dto = (BaseDTO) object;
            System.out.println("休眠结束");
            return dto;
        }


    }

}
