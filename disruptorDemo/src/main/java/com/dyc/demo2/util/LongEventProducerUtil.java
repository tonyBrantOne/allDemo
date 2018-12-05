package com.dyc.demo2.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 19:30
 * @Description:
 */

import com.dyc.demo2.model.LongEvent;
import com.lmax.disruptor.RingBuffer;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 19:30
 * @Description:
 */
public class LongEventProducerUtil {
    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerUtil(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }


    public void setLongEventInRinBuffer( LongEvent longEvent){
        Long sequence = null;
        try {
             sequence = ringBuffer.next();//获取未绑定的空序列
            LongEvent event = ringBuffer.get(sequence);
            event.setValue( longEvent.getValue() );//设置到队列对象中。
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            ringBuffer.publish(sequence);//触发绑定的事件
        }
    }

}
