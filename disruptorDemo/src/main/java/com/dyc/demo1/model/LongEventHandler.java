package com.dyc.demo1.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */


import com.lmax.disruptor.EventHandler;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent longEvent, long l, boolean b) throws Exception {
        Thread.sleep(20000);
        System.out.println( "onEvent的方法：" + longEvent.getValue());
    }
}
