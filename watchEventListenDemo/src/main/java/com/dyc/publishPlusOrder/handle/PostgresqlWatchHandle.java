package com.dyc.publishPlusOrder.handle;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */

import com.dyc.publishPlusOrder.listen.AbstactWatchListen;
import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.model.postgresqlModel.PostgresqlMonitorDTO;
import com.dyc.publishPlusOrder.service.WatchService;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:36
 * @Description:
 */
public interface PostgresqlWatchHandle < T extends MonitorDTO> extends WatchService<T> {


}
