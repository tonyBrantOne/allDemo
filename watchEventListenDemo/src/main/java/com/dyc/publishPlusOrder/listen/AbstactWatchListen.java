package com.dyc.publishPlusOrder.listen;

import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.service.WatchService;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/27 19:34
 * @Description:
 */
public abstract class AbstactWatchListen< T extends MonitorDTO > implements WatchService<T> {

}
