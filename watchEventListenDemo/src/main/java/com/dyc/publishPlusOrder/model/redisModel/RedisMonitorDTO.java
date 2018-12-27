package com.dyc.publishPlusOrder.model.redisModel;

import com.dyc.publishPlusOrder.model.AbstractMonitorDTO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 20:51
 * @Description:
 */
public class RedisMonitorDTO extends AbstractMonitorDTO {
    private RedisConnectDTO connectDTO = new RedisConnectDTO();
    private RedisDataSources dataSources = new RedisDataSources();


}
