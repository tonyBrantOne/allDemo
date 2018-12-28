package com.dyc.publishPlusOrder;

import com.dyc.publishPlusOrder.consumer.ConsumerOrders;
import com.dyc.publishPlusOrder.handle.EsWatchHandle;
import com.dyc.publishPlusOrder.handle.PostgresqlWatchHandle;
import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.publisher.QuartzEsMonitor;
import com.dyc.publishPlusOrder.publisher.QuartzPostgresqlMonitor;
import com.dyc.publishPlusOrder.publisher.QuartzRedisMonitor;

import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:24
 * @Description:
 */
public class TestMain {
    private RedisWatchHandle redisWatchHandle = new RedisWatchHandle();
    private EsWatchHandle esWatchHandle = new EsWatchHandle();
    private PostgresqlWatchHandle postgresqlWatchHandle = new PostgresqlWatchHandle();
    ExecutorService executorService = new ThreadPoolExecutor(5, 10, 1000,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(20));

    public static void main(String[] args) {
        new TestMain().startMain();
    }

    public void startMain(){
        blindConsumer();
        startExecutors();
    }
    
    public void blindConsumer(){
        ConsumerOrders.blindListen(redisWatchHandle);
        ConsumerOrders.blindListen(esWatchHandle);
        ConsumerOrders.blindListen(postgresqlWatchHandle);
        startExecutors();
    }

    public void startExecutors(){
        while ( true ){
            executorService.execute( new QuartzRedisMonitor());
            executorService.execute( new QuartzEsMonitor());
            executorService.execute( new QuartzPostgresqlMonitor());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }


}
