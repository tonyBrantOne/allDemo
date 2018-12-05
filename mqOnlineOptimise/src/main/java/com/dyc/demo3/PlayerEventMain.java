package com.dyc.demo3;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:56
 * @Description:
 */

import com.dyc.demo3.model.producer.Producer;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:56
 * @Description:
 */
public class PlayerEventMain implements Runnable{
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static Integer countNum = 2000;
    public static CountDownLatch beginCountDownLatch = new CountDownLatch(1);
    public static  CountDownLatch countDownLatch = new CountDownLatch(countNum);
    private int i;

    public PlayerEventMain(int i) {
        this.i = i;
    }

    public static void main(String[] args) throws InterruptedException {
        for( int i = 0; i < countNum; i++){
            PlayerEventMain playerEventMain = new PlayerEventMain(i);
            Thread thread = new Thread(playerEventMain);
            thread.start();
        }
        System.out.println("并发数据准备中");
        System.out.println("================================");
        Thread.sleep(2000);
        beginCountDownLatch.countDown();
        Date beginDate = new Date();
        System.out.println("开始冲刺，计时开始：" + beginDate);
        System.out.println("================================");
        countDownLatch.await();
        System.out.println("================================");
        System.out.println("总共运行的线程请求 = " + atomicInteger);
        Date endDate = new Date();
        System.out.println("结束计时 = +" + endDate);
        System.out.println("总共耗时 = " + (endDate.getTime() - beginDate.getTime()) + "ms");
    }


    @Override
    public void run() {
        try {
         //System.out.println("休眠开始 : " + "i的序号为 = " + i + ";线程名称 = " + Thread.currentThread().getName());
         beginCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Producer producer = Producer.getNewinstance();
        producer.producerOrderMsg(Long.valueOf(i),1);

    }


    public void setI(int i) {
        this.i = i;
    }
    public int getI() {
        return i;
    }
}
