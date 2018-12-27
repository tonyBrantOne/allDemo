package com.dyc.publishPlusOrder.handle;
/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.redisModel.RedisMonitorDTO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */
public class RedisWatchHandle extends AbstactWatchListen<RedisMonitorDTO> {


    @Override
    public void connectExcessWarnning(RedisMonitorDTO redisMonitorDTO) {

    }

    @Override
    public void connectReject(RedisMonitorDTO redisMonitorDTO) {

    }
}
