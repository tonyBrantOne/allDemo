package com.dyc.newFixedThreadPoolDemo;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 16:40
 * @Description:
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 16:40
 * @Description:
 */
public class NewFixedThreadPoolTest {
    ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        new NewFixedThreadPoolTest().test();
    }

    void test(){
        for( int i = 0; i < 100; i++ ){
            executorService.execute( new MyRunnable(i) );
        }
    }


    class MyRunnable implements Runnable{

        int id;

        public MyRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Thread.currentThread().getName()" + Thread.currentThread().getName() + "id:" +id);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
