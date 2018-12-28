package com.dyc.publishPlusOrder.consumer;

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.util.ConstantParam;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/27
 */
public class ConsumerOrders {

    public static void blindListen(AbstactWatchListen watchListen){
     //       ConstantParam.blockingDeque.offer(watchListen);
           ConstantParam.concurrentHashMap.put(watchListen.getClass().getSimpleName(),watchListen);
    }
}
