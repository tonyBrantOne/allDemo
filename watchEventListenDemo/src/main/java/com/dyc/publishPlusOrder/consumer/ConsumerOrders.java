package com.dyc.publishPlusOrder.consumer;

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.service.WatchService;
import com.dyc.publishPlusOrder.util.ConstantParam;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/27
 */
public class ConsumerOrders {

    public static void blindListen(WatchService watchService){

     //       ConstantParam.blockingDeque.offer(watchListen);
           ConstantParam.concurrentHashMap.put(watchService.getClass().getSuperclass().getName(),watchService);
    }

    public static void blindListen(String key){

        //       ConstantParam.blockingDeque.offer(watchListen);
        ConstantParam.concurrentHashMap.put(key, (WatchParentService) ConstantParam.applicationContext.get(key));
    }
}
