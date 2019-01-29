package com.dyc.dateDemo;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/11 17:44
 * @Description:
 */

import java.util.Date;
import java.util.TimeZone;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/11 17:44
 * @Description:
 */
public class ZoneTimeTest {

    public static void main(String[] args) throws InterruptedException {
        new ZoneTimeTest().startMain();
    }

    public void startMain() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            Thread.sleep(2000);
            new Thread(new MyRunnable(i)).start();
        }
    }

    public static void test() {
        System.out.println("startMain" + new Date());
    }

    public class MyRunnable implements Runnable{

        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            if( i == 0 ){
                TimeZone.setDefault(TimeZone.getTimeZone("GMT-04:00"));
            }
            System.out.println(new Date());
        }
    }

}
