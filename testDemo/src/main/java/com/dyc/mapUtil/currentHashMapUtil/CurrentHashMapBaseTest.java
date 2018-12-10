package com.dyc.mapUtil.currentHashMapUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/5 19:17
 * @Description:基本的使用方法
 */
public class CurrentHashMapBaseTest {

    Integer num = 10000;
    static HashMap<Integer,Integer> map = new HashMap();
    static ConcurrentHashMap<Integer,Integer> concurrentHashMap = new ConcurrentHashMap();
    CountDownLatch countDownLatch = new CountDownLatch(1);
    CountDownLatch countDownLatchEnd = new CountDownLatch(num);
    public static void main(String[] args) throws InterruptedException {
        new CurrentHashMapBaseTest().startMain();
    //    concurrentHashMap.put(1,1);
    }

    public void startMain() throws InterruptedException {
        for( int i = 0; i < num; i++ ){
             new Thread( new MyRunnable(i) ).start();
        }
        Thread.sleep(2000);
        System.out.println("开始时间"+new Date());
        countDownLatch.countDown();
        countDownLatchEnd.await();
        System.out.println("结束时间"+new Date());
        System.out.println("concurrentHashMap最终的数量:"+concurrentHashMap.size());
    }

    class MyRunnable implements Runnable{
        Integer i;

        public MyRunnable(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            concurrentHashMap.put(i,i);
       //     concurrentHashMap.putIfAbsent()
            countDownLatchEnd.countDown();
        }
    }

}
