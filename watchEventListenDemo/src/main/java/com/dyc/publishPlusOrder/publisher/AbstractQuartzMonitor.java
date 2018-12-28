package com.dyc.publishPlusOrder.publisher;

import com.dyc.publishPlusOrder.service.WatchParentService;
import com.dyc.publishPlusOrder.util.ConstantParam;
import com.dyc.publishPlusOrder.util.ThreadPoolUtil;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/28 11:24
 * @Description:
 */
public abstract class AbstractQuartzMonitor implements Runnable {


    @Override
    public void run() {
        this.checkHeartJump();
    }

    /**
     * 检查服务器心跳
     */
    protected abstract void checkHeartJump();



}
