package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.handle.PostgresqlWatchDoHandle;
import com.dyc.publishPlusOrder.handle.PostgresqlWatchHandle;
import com.dyc.publishPlusOrder.handle.RedisWatchHandle;
import com.dyc.publishPlusOrder.model.postgresqlModel.PostgresqlMonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/28
 */
public class QuartzPostgresqlMonitor extends AbstractQuartzMonitor {

    private PostgresqlWatchHandle<PostgresqlMonitorDTO> postgresqlWatchHandle;

    public QuartzPostgresqlMonitor(PostgresqlWatchHandle<PostgresqlMonitorDTO> postgresqlWatchHandle) {
        this.postgresqlWatchHandle = postgresqlWatchHandle;
    }


    public QuartzPostgresqlMonitor() {
    }

    @Override
    protected void checkHeartJump() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("检查数据库心跳=========================================================");
        postgresqlWatchHandle.connectExcessWarnning(new PostgresqlMonitorDTO());
        postgresqlWatchHandle.connectReject(new PostgresqlMonitorDTO());
    }
}
