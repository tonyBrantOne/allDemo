package com.dyc.ThreadPool.baseTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/16
 */
public class ThreadPoolExcutorTest {

    public static void main(String[] args) {
        new ThreadPoolExcutorTest().startMain();
    }

    public void startMain(){
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
