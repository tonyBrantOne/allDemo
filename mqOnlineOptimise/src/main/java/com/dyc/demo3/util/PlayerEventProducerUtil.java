package com.dyc.demo3.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 19:30
 * @Description:
 */

import com.dyc.mqOnline.model.Player;
import com.lmax.disruptor.RingBuffer;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 19:30
 * @Description:
 */
public class PlayerEventProducerUtil {
    private final RingBuffer<Player> ringBuffer;

    public PlayerEventProducerUtil(RingBuffer<Player> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }


    public void setLongEventInRinBuffer( Player player){
        Long sequence = null;
        try {
             sequence = ringBuffer.next();//获取未绑定的空序列
             Player event = ringBuffer.get(sequence);
             event.setId(player.getId());//设置到队列对象中。
             event.setOnline(player.getOnline());
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            ringBuffer.publish(sequence);//触发绑定的事件
        }
    }

}
