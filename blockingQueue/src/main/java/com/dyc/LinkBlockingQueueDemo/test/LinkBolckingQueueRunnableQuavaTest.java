package com.dyc.LinkBlockingQueueDemo.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 10:32
 * @Description:
 */

import com.dyc.LinkBlockingQueueDemo.model.Player;
import com.dyc.LinkBlockingQueueDemo.test.ScheduleRunnable.QueueRunnable;
import com.google.common.collect.Queues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/12 10:32
 * @Description:
 */
public class LinkBolckingQueueRunnableQuavaTest {
    private static Integer countNum = 20000;
    public static LinkedBlockingQueue<Player> linkedBlockingQueue = new LinkedBlockingQueue<>(1000);
    private static CountDownLatch countDownLatch = new CountDownLatch(countNum);
    public static void main(String[] args) throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(new QueueRunnable());
        new LinkBolckingQueueRunnableQuavaTest().test();
    }




    public void test() throws InterruptedException {
        List<Player> list = new ArrayList<>();
        for( int i = 1; i <= countNum; i++){
            new Thread(new LinkBolckingQueueRunnable(new Player(i))).start();
         //   Thread.sleep(1000);
        }

    }



    class LinkBolckingQueueRunnable implements Runnable{

        private Player player;

        public LinkBolckingQueueRunnable(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            try {
                linkedBlockingQueue.put(player);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
              //  countDownLatch.countDown();
            }
        }
    }


}
