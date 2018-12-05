package com.dyc.demo2.model;

import com.lmax.disruptor.EventFactory;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:34
 * @Description:
 */
public class LongEventFactory implements EventFactory<LongEvent> {


    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
