package com.dyc.ThreadPool.baseTest;
/**
 * @Auther: tony_jaa
 * @Date: 2018/12/25 14:39
 * @Description:
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/25 14:39
 * @Description:线程池当前线程数及任务队列变化情况，主要是测试有界队列情况下，线程如何存活
 */
public class ThreadPoolExcutorSort2 {
    private int num;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private CountDownLatch coreDownLatch = new CountDownLatch(1);
    private ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(5);
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 500,TimeUnit.MILLISECONDS, arrayBlockingQueue);

    public static void main(String[] args) throws InterruptedException {
        new ThreadPoolExcutorSort2().startMain();
    }


    public void startMain() throws InterruptedException {
        for( int i = 0; i < 5; i++){
            startTask(new TmpTask());
        }
        for( int i = 0; i < 10; i++){
            startTask(new TmpTask());
        }
        System.out.println("");
        System.out.println("主线程阻塞3s");
        Thread.sleep(3000);
        countDownLatch.countDown();
        Thread.sleep(2000);
        showLog(0);
        startTask(new CoreTask());
        showLog(7);
        System.out.println("结束==================================");
    }



        public void startTask( Runnable myRunnable ){
            System.out.println("");
            threadPoolExecutor.execute(myRunnable);
            System.out.println("线程池中线程数："+threadPoolExecutor.getPoolSize());
            System.out.println("任务队列个数："+arrayBlockingQueue.size());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        public void showLog( int num ){
            do {
                System.out.println("");
                System.out.println("线程池中线程数："+threadPoolExecutor.getPoolSize());
                System.out.println("任务队列个数："+arrayBlockingQueue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(  5 == num++ ) break;
            }while (true);
            System.out.println("循环结束");
            System.out.println("");
        }


    class TmpTask implements Runnable{
        @Override
        public void run() {
            try {
                System.out.println("当前线程名："+Thread.currentThread().getName());
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class CoreTask implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("当前线程名："+Thread.currentThread().getName());
                coreDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
