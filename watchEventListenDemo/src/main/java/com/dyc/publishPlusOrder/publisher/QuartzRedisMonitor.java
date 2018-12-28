package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.util.ConstantParam;

import java.util.concurrent.Callable;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzRedisMonitor implements Runnable {
    @Override
    public void run() {
        System.out.println("QuartzRedisMonitor");
        WatchParentService abstactWatchListen = ConstantParam.concurrentHashMap.get(RedisWatchHandle.class.getSimpleName());
        RedisWatchHandle redisWatchHandle = (RedisWatchHandle) abstactWatchListen;
        redisWatchHandle.connectExcessWarnning(new RedisMonitorDTO());
        redisWatchHandle.connectReject(new RedisMonitorDTO());
    }
}
