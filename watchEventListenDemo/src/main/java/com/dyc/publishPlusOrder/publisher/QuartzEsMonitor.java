package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.EsWatchHandle;
import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.model.esModel.EsMonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.util.ConstantParam;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzEsMonitor implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("QuartzEsMonitor");
        WatchParentService abstactWatchListen = ConstantParam.concurrentHashMap.get(EsWatchHandle.class.getSimpleName());
        EsWatchHandle esWatchHandle = (EsWatchHandle) abstactWatchListen;
        esWatchHandle.connectExcessWarnning(new EsMonitorDTO());
        esWatchHandle.connectReject(new EsMonitorDTO());
    }
}
