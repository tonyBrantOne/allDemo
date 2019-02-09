package com.dyc.ThreadPool.baseTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/25 16:34
 * @Description:手动模拟线程池
 */
public class ThreadPoolManaulSimulate {
    private ArrayBlockingQueue<Task> arrayBlockingQueue = new ArrayBlockingQueue<Task>(5);
    private CountDownLatch countDownLatch;
    private int num;

    public static void main(String[] args) throws InterruptedException {
        new ThreadPoolManaulSimulate().startMain();
    }



    public void startMain(){
        for( int i = 0; i < 5; i++ ){
            arrayBlockingQueue.add( new Task(i));
        }
        new Thread( new Walker() ).start();
    }

    class Walker implements Runnable{

        @Override
        public void run() {
            try {
                cycleThreadRun();
            }catch ( RuntimeException e ){
                System.out.println(e);
            }finally {
            }
        }
    }

    public void cycleThreadRun(){
        try {

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Task task = arrayBlockingQueue.poll();
            System.out.println("当前任务： " + task);
            if (task == null) throw new RuntimeException("当前无任务");
            try {
                countDownLatch = new CountDownLatch(1);
                task.run();
                countDownLatch.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }finally {
            if( num++ == 5000) return;
            cycleThreadRun();
        }
    }

    class Task implements Runnable{

        private Integer i;

        public Task(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("当前线程："+ Thread.currentThread().getName() + ",休眠中。执行的任务编号：" + i);
           //     Thread.sleep(3000);
                System.out.println("当前线程："+ Thread.currentThread().getName() + "休眠结束。执行任务编号："+i);
                System.out.println("");
                countDownLatch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
