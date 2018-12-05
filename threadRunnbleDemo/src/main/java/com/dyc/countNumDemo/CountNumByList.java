package com.dyc.countNumDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/11/16 13:04
 * @Description:高并发下通过集合来计数。
 */
public class CountNumByList {
    private static Integer num = 6;
    private CountDownLatch countDownLatchNum = new CountDownLatch(1);
    private static CountNumByList countNumByList;
    private List<Integer> vector = new Vector<>();
    static {
        countNumByList = new CountNumByList();
    }

    public static void main(String[] args) throws InterruptedException {
       countNumByList.startCountNumThread();
    }

    public void startCountNumThread() throws InterruptedException {
        for( int i = 0; i < num; i++ ){
            new Thread(new CommonRunnable(i)).start();
        }
        Thread.sleep(1000);
        countDownLatchNum.countDown();

    }



    public class CommonRunnable implements Runnable{
        private Integer i;

        public CommonRunnable(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("i========="+i );
                countDownLatchNum.await();
                vector.add(i);
                if( vector.size() == 5 ){
                    Thread.sleep(5000);
                }
                Integer n = vector.size();
                System.out.println("第"+ n  + "次打卡;size===="+ vector.size() );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
