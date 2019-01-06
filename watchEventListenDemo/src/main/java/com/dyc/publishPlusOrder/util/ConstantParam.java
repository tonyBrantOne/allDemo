package com.dyc.publishPlusOrder.util;

import com.dyc.publishPlusOrder.model.MonitorDTO;
import com.dyc.publishPlusOrder.service.WatchParentService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/27
 */
public class ConstantParam {

    public static final LinkedBlockingDeque<WatchParentService> blockingDeque = new LinkedBlockingDeque<>(3);
    public static final ConcurrentHashMap<String,WatchParentService> concurrentHashMap = new ConcurrentHashMap<String, WatchParentService>(3);
    public static final Map<String,Object> applicationContext = new LinkedHashMap<String, Object>(6);


    public LinkedBlockingDeque<WatchParentService> getBlockingDeque() {
        return blockingDeque;
    }

}
