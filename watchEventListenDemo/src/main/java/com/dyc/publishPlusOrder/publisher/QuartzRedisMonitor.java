package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.RedisWatchDoHandle;
import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.util.ConstantParam;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzRedisMonitor extends AbstractQuartzMonitor {
    private RedisWatchHandle<RedisMonitorDTO> redisWatchHandle;

    public QuartzRedisMonitor(RedisWatchHandle<RedisMonitorDTO> redisWatchHandle) {
        this.redisWatchHandle = redisWatchHandle;
    }

    public QuartzRedisMonitor() {

    }

    @Override
    protected void checkHeartJump() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("检查redis心跳=========================================================");
        redisWatchHandle = (RedisWatchHandle<RedisMonitorDTO>) ConstantParam.concurrentHashMap.get(RedisWatchHandle.class.getName());
        redisWatchHandle.connectExcessWarnning(new RedisMonitorDTO());
        redisWatchHandle.connectReject(new RedisMonitorDTO());
    }
}
