package com.dyc.demo3.Listen;
/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 12:46
 * @Description:
 */

import com.dyc.mqOnline.controller.TestController;
import com.dyc.mqOnline.model.Player;
import com.dyc.mqOnline.service.TestService;
import com.google.common.collect.Queues;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 12:46
 * @Description:
 */
public class QueueRunnable implements Runnable {

    public static AtomicInteger atomicInteger = new AtomicInteger(1);
    private static TestService testService;
    public static Integer initNum = 5;
    public static ExecutorService executorService = Executors.newFixedThreadPool(initNum);

    @Override
    public void run() {
        while( true ){
            List<Player> list = new ArrayList<>();
            try {
                System.out.println("");
                System.out.println("===========a============="+atomicInteger.get()+"============================================" );
                Queues.drain(PlayerEventHandler.linkedBlockingQueue, list, 1000, 100000, TimeUnit.MILLISECONDS);
                System.out.println("===========b============="+atomicInteger.get()+"============================================" );
                if( !list.isEmpty() ){
                    System.out.println("==========c=============="+atomicInteger.getAndIncrement()+"============================================" );
            //        System.out.println("                                                  list: "+list);
                    executorService.execute( new PlayerDaoRunnable(list));
                    System.out.println("==========D=============="+atomicInteger.get()+"============================================" );
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   public class PlayerDaoRunnable implements Runnable{

        private List<Player> list;

        public PlayerDaoRunnable(List<Player> list) {
            this.list = list;
        }

        @Override
        public void run() {
             if( list.isEmpty() ){
                 return;
             }
             System.out.println("批量修改状态中： Thread.currentThread().getName()=" + Thread.currentThread().getName());
            try {
                Player player = new Player();
                player.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
                player.setLastTime(new Timestamp(System.currentTimeMillis()));
                player.setListPlayer(list);
                testService.updateMqCapabilityByPath(player);
                System.out.println("批量修改结束： Thread.currentThread().getName()=" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                TestController.atomicInteger.getAndIncrement();
                TestController.countDownLatch.countDown();
            }
        }
    }


    public static TestService getTestService() {
        return testService;
    }

    public static void setTestService(TestService testService) {
        QueueRunnable.testService = testService;
    }
}
