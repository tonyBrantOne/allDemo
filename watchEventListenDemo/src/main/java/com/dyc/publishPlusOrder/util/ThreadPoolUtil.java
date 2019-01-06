package com.dyc.publishPlusOrder.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */



import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:39
 * @Description:
 */
public class ThreadPoolUtil {
    public static ExecutorService executorService = new ThreadPoolExecutor(10, 20, 1000,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(50));
}
