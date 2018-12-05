package com.dyc.demo2.Listen;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */


import com.dyc.demo2.model.LongEvent;
import com.lmax.disruptor.WorkHandler;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */
public class LongEventHandler implements WorkHandler<LongEvent> {


    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        System.out.println("获取当前线程号："+Thread.currentThread().getId() +"====name:"+Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println( "onEvent的方法：" + longEvent.getValue());
    }
}
