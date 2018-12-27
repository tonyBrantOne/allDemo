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
public class EsWatchHandle extends AbstactWatchListen<EsMonitorDTO> {

    @Override
    public void connectExcessWarnning(EsMonitorDTO esMonitorDTO) {

    }

    @Override
    public void connectReject(EsMonitorDTO esMonitorDTO) {

    }
}
