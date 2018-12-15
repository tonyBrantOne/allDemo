package com.dyc.ThreadPool.ThreadPoolExcetureDemo.baseTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 19:14
 * @Description:ThreadPoolExecutor+Callable的使用
 */
public class ThreadPoolExcetureCallableTest {

    public static void main(String[] args) {
        new ThreadPoolExcetureCallableTest().startMain();
    }



    public void startMain(){
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        executorService.submit(new MyRunnable(this,"tony_jaa"));
    }

    class MyRunnable implements Runnable{

        ThreadPoolExcetureCallableTest threadPoolExcetureBaseTest;
        String name;

        public MyRunnable(ThreadPoolExcetureCallableTest threadPoolExcetureBaseTest, String name) {
            this.threadPoolExcetureBaseTest = threadPoolExcetureBaseTest;
            this.name = name;
        }

        @Override
        public void run() {
            threadPoolExcetureBaseTest.test(name);
        }
    }

    public void test( String str){
        System.out.println("执行现场"+ str);
    }
}
