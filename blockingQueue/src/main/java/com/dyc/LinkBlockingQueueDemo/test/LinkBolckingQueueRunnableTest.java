package com.dyc.LinkBlockingQueueDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 10:32
 * @Description:
 */

import com.dyc.LinkBlockingQueueDemo.model.Player;
import com.google.common.collect.Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 10:32
 * @Description:
 */
public class LinkBolckingQueueRunnableTest {
    private static Integer countNum = 4;
    private static LinkedBlockingQueue<Player> linkedBlockingQueue = new LinkedBlockingQueue<>(5);
    private static CountDownLatch countDownLatch = new CountDownLatch(countNum);
    public static void main(String[] args) throws InterruptedException {
        new LinkBolckingQueueRunnableTest().test();
    }




    public void test() throws InterruptedException {
        List<Player> list = new ArrayList<>();
        for( int i = 1; i <= countNum; i++){
            new Thread(new LinkBolckingQueueRunnable(new Player(i))).start();
        }

        countDownLatch.await();
        Queues.drain(linkedBlockingQueue, list, 5, 10000, TimeUnit.MILLISECONDS);
        System.out.println("list=="+list);
        Thread thread = new Thread(new LinkBolckingQueueRunnable(new Player(6)));
        thread.start();
    }



    class LinkBolckingQueueRunnable implements Runnable{

        private Player player;

        public LinkBolckingQueueRunnable(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            try {
                System.out.println("等待放入中+"+player.toString());
                linkedBlockingQueue.put(player);
                System.out.println("成功放入linkedBlockingQueue："+linkedBlockingQueue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                countDownLatch.countDown();
            }
        }
    }


}
