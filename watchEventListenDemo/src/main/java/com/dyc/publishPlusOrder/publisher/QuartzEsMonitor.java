package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.EsWatchDoHandle;
import com.dyc.publishPlusOrder.handle.EsWatchHandle;
import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.model.esModel.EsMonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzEsMonitor extends AbstractQuartzMonitor {

    private EsWatchHandle esWatchHandle;

    public QuartzEsMonitor(EsWatchHandle esWatchHandle) {
        this.esWatchHandle = esWatchHandle;
    }

    public QuartzEsMonitor() {
    }

    @Override
    protected void checkHeartJump() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("检查es心跳:=========================================================");
        esWatchHandle.connectExcessWarnning(new EsMonitorDTO());
        esWatchHandle.connectReject(new EsMonitorDTO());
    }
}
