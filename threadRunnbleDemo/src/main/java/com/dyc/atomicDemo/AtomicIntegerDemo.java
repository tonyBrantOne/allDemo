package com.dyc.atomicDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/11/15 10:29
 * @Description:
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/15 10:29
 * @Description:
 */
public class AtomicIntegerDemo {

    private static Integer num = 1000;
    private static AtomicInteger atomicOnlne = new AtomicInteger(0);
    public static CountDownLatch beginCountDownLatch = new CountDownLatch(num);


    public static void main(String[] args) throws InterruptedException {
         for( int i = 0; i < num; i++ ){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
              //      System.out.println("准备中："+Thread.currentThread().getName());
                    try {
                        beginCountDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if( atomicOnlne.incrementAndGet() == 1){
                        System.out.println("=================================================运行的线程"+Thread.currentThread().getName());
                    }else{
              //          System.out.println( "没有运行" );
                    }
                }
            });
            thread.start();
            beginCountDownLatch.countDown();
        }
    }
}
