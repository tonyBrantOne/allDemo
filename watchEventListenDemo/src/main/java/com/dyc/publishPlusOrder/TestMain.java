package com.dyc.publishPlusOrder;

import com.dyc.publishPlusOrder.consumer.ConsumerOrders;
import com.dyc.publishPlusOrder.handle.*;
import com.dyc.publishPlusOrder.model.esModel.EsMonitorDTO;
import com.dyc.publishPlusOrder.model.postgresqlModel.PostgresqlMonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.publisher.AbstractQuartzMonitor;
import com.dyc.publishPlusOrder.publisher.QuartzEsMonitor;
import com.dyc.publishPlusOrder.publisher.QuartzPostgresqlMonitor;
import com.dyc.publishPlusOrder.publisher.QuartzRedisMonitor;
import com.dyc.publishPlusOrder.service.WatchService;
import com.dyc.publishPlusOrder.util.ConstantParam;
import com.dyc.publishPlusOrder.util.ProxyUtil;
import com.dyc.publishPlusOrder.util.ThreadPoolUtil;

import java.util.Map;
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
    ExecutorService executorService = ThreadPoolUtil.executorService;
    public static void main(String[] args) {
        new TestMain().startMain();
    }

    public void startMain(){
        createBean();
        blindConsumer();
        startExecutors();
    }
    
    public void blindConsumer(){
        for ( String key : ConstantParam.applicationContext.keySet() ) {
            if( ConstantParam.applicationContext.get(key) instanceof WatchService ) ConsumerOrders.blindListen( key );
        }
    }

    public void startExecutors(){
        while ( true ){
            for ( String key : ConstantParam.applicationContext.keySet() ) {
                Object abstractQuartzMonitor = ConstantParam.applicationContext.get(key);
                if( ConstantParam.applicationContext.get(key) instanceof AbstractQuartzMonitor) executorService.execute((AbstractQuartzMonitor) abstractQuartzMonitor);
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("");
        }
    }

    public void createBean(){

        ConstantParam.applicationContext.put( RedisWatchHandle.class.getName(),ProxyUtil.getInstance(RedisWatchHandle.class,new RedisWatchDoHandle()));
        ConstantParam.applicationContext.put( EsWatchHandle.class.getName(),ProxyUtil.getInstance(EsWatchHandle.class,new EsWatchDoHandle()));
        ConstantParam.applicationContext.put( PostgresqlWatchHandle.class.getName(), ProxyUtil.getInstance(PostgresqlWatchHandle.class,new PostgresqlWatchDoHandle()));

        QuartzRedisMonitor quartzRedisMonitor = new QuartzRedisMonitor((RedisWatchHandle<RedisMonitorDTO>) ConstantParam.applicationContext.get( RedisWatchHandle.class.getName()));
        QuartzEsMonitor esMonitor = new QuartzEsMonitor((EsWatchHandle<EsMonitorDTO>) ConstantParam.applicationContext.get( EsWatchHandle.class.getName()));
        QuartzPostgresqlMonitor postgresqlMonitor = new QuartzPostgresqlMonitor((PostgresqlWatchHandle<PostgresqlMonitorDTO>) ConstantParam.applicationContext.get( PostgresqlWatchHandle.class.getName()));

        ConstantParam.applicationContext.put( new QuartzRedisMonitor().getClass().getName(), quartzRedisMonitor);
        ConstantParam.applicationContext.put( new QuartzEsMonitor().getClass().getName(), esMonitor);
        ConstantParam.applicationContext.put( new QuartzPostgresqlMonitor().getClass().getName(), postgresqlMonitor);
    }


}
