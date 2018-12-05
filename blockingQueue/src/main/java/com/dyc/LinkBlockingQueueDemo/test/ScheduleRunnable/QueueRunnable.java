package com.dyc.LinkBlockingQueueDemo.test.ScheduleRunnable;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 12:46
 * @Description:
 */

import com.dyc.LinkBlockingQueueDemo.model.Player;
import com.dyc.LinkBlockingQueueDemo.test.LinkBolckingQueueRunnableQuavaTest;
import com.google.common.collect.Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 12:46
 * @Description:
 */
public class QueueRunnable implements Runnable {

    public static AtomicInteger atomicInteger = new AtomicInteger(1);

    @Override
    public void run() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        while( true ){
            List<Player> list = new ArrayList<>();
            try {
                System.out.println("");
                System.out.println("========================"+atomicInteger.getAndIncrement()+"============================================" );
                Queues.drain(LinkBolckingQueueRunnableQuavaTest.linkedBlockingQueue, list, 500, 1000, TimeUnit.MILLISECONDS);
       //         System.out.println("LinkBolckingQueueRunnableQuavaTest.linkedBlockingQueue: "+LinkBolckingQueueRunnableQuavaTest.linkedBlockingQueue);
                System.out.println("                                                  list: "+list);
                if( !list.isEmpty() ){
                    executorService.execute( new PlayerDaoRunnable(list));
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class PlayerDaoRunnable implements Runnable{

        private List<Player> list;

        public PlayerDaoRunnable(List<Player> list) {
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("批量修改状态中：" + list + ",Thread.currentThread().getName()=" + Thread.currentThread().getName());
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
