package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.EsWatchHandle;
import com.dyc.publishPlusOrder.handle.PostgresqlWatchHandle;
import com.dyc.publishPlusOrder.model.esModel.EsMonitorDTO;
import com.dyc.publishPlusOrder.model.postgresqlModel.PostgresqlMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.util.ConstantParam;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzPostgresqlMonitor implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("QuartzPostgresqlMonitor");
        WatchParentService abstactWatchListen = ConstantParam.concurrentHashMap.get(PostgresqlWatchHandle.class.getSimpleName());
        PostgresqlWatchHandle esWatchHandle = (PostgresqlWatchHandle) abstactWatchListen;
        esWatchHandle.connectExcessWarnning(new PostgresqlMonitorDTO());
        esWatchHandle.connectReject(new PostgresqlMonitorDTO());
    }
}
