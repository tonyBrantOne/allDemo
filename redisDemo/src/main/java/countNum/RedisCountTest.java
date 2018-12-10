package countNum;

import countNum.service.OrderService;
import countNum.service.impl.OrderServiceImpl;
import countNum.util.JedisUtil;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

/**
 * title:Redis计数器
 * create by tony_jaa
 * date 2018/11/18
 */
public class RedisCountTest {

    private static Integer num = 10;
    private CountDownLatch countDownLatch = new CountDownLatch(1);
    public static CountDownLatch endCountDownLatch = new CountDownLatch(num);

    public static void main(String[] args) throws InterruptedException {
        new RedisCountTest().startTest();
    }


    public void startTest() throws InterruptedException {
        for( int i = 0; i < num; i++){
           new Thread( new MyRunnable(i) ).start();
        }
        System.out.println("准备扣钱=====");
        Thread.sleep(1000);
        countDownLatch.countDown();
        endCountDownLatch.await();
        System.out.println("最终剩余金钱："+OrderServiceImpl.allMoney);
    }


    public class MyRunnable implements Runnable{

        private Integer i;

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
            new OrderServiceImpl().purchaseProduct();
        }
    }


}
