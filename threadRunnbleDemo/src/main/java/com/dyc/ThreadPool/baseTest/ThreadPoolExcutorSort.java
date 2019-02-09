package com.dyc.ThreadPool.baseTest;
/**
 * @Auther: tony_jaa
 * @Date: 2018/12/25 14:39
 * @Description:
 */

import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/25 14:39
 * @Description:线程池当前线程数及任务队列变化情况
 */
public class ThreadPoolExcutorSort {
    private int num;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    private ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(5);
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 500,TimeUnit.MILLISECONDS, arrayBlockingQueue);

    public static void main(String[] args) throws InterruptedException {
        new ThreadPoolExcutorSort().startMain();
    }


    public void startMain() throws InterruptedException {
        for( int i = 0; i < 15; i++){
            MyRunnable myRunnable = new MyRunnable();
            System.out.println("");
            threadPoolExecutor.execute(myRunnable);
            System.out.println("线程池中线程数："+threadPoolExecutor.getPoolSize());
            System.out.println("任务队列个数："+arrayBlockingQueue.size());
            Thread.sleep(1000);
        }
        System.out.println("");
        System.out.println("主线程阻塞3s");
        Thread.sleep(3000);
        countDownLatch.countDown();
        do {
            System.out.println("");
            System.out.println("线程池中线程数："+threadPoolExecutor.getPoolSize());
            System.out.println("任务队列个数："+arrayBlockingQueue.size());
            Thread.sleep(1000);
            if(  5 == num++ ) break;
        }while (true);
        System.out.println("=======================================================");
        countDownLatch = new CountDownLatch(1);
        for( int i = 0; i < 6; i++){
            MyRunnable myRunnable = new MyRunnable();
            System.out.println("");
            threadPoolExecutor.execute(myRunnable);
            System.out.println("线程池中线程数："+threadPoolExecutor.getPoolSize());
            System.out.println("任务队列个数："+arrayBlockingQueue.size());
            Thread.sleep(1000);
        }
        System.out.println("");
        System.out.println("主线程阻塞3s");
        Thread.sleep(3000);
        countDownLatch.countDown();

    }

    class MyRunnable implements Runnable{

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

}
