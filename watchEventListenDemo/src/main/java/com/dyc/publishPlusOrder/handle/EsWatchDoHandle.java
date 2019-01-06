package com.dyc.publishPlusOrder.handle;
/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.esModel.EsMonitorDTO;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */
public class EsWatchDoHandle implements EsWatchHandle<EsMonitorDTO> {

    @Override
    public void connectExcessWarnning(EsMonitorDTO esMonitorDTO) {
        System.out.println("EsRedis连接数超时");
    }

    @Override
    public void connectReject(EsMonitorDTO esMonitorDTO) {
        System.out.println("Es连接数超时");
    }
}
