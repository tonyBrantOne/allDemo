package com.dyc.threadRunnableDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 10:11
 * @Description:
 */

import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 10:11
 * @Description:
 */
public class AppTest1 {
    private static Integer countNum = 100;
    private static  CountDownLatch beginCountDownLatch = new CountDownLatch(1);
    private static  CountDownLatch countDownLatch = new CountDownLatch(countNum);

    public static void main(String[] args) throws InterruptedException {
        new AppTest1().test1();
    }



    public void test1() throws InterruptedException {
        for( int i = 1; i <= countNum; i++){
            Thread thread = new Thread(new MyRunnable(i));
            thread.start();
        }
        System.out.println("并发数据准备中");
        beginCountDownLatch.countDown();
        System.out.println("开始冲刺，计时开始：" + new Date());
        countDownLatch.await();
        System.out.println("结束计时 = +" + new Date());
    }


    class MyRunnable implements Runnable{
        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                beginCountDownLatch.await();
                System.out.println("休眠开始 : " + "i的序号为 = " + i + ";线程名称 = " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("休眠结束 : " + "i的序号为 = " + i + ";线程名称 = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }
    }
}
