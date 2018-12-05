package com.dyc.demo1;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:56
 * @Description:
 */

import com.dyc.demo1.model.LongEvent;
import com.dyc.demo1.model.LongEventFactory;
import com.dyc.demo1.model.LongEventHandler;
import com.dyc.demo1.util.LongEventProducerUtil;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:56
 * @Description:
 */
public class LongEventMain  {


    static {

    }
    public static void main(String[] args) throws InterruptedException {
        test();
        System.out.println("test结束测试");
    }

    public static void test() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();//创建线程池
        LongEventFactory longEventFactory = new LongEventFactory();//
        int ringBufferSize = 1024 * 1024; //配置队列的长度
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventFactory,ringBufferSize,executorService,ProducerType.SINGLE,new YieldingWaitStrategy());

        disruptor.handleEventsWith( new LongEventHandler() );//观察者模式绑定消息者监听对象最终回调到onEvent的事件方法。

        disruptor.start();//这里的启动不知道要做什么？

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();//获取异步队列。


        LongEventProducerUtil longEventProducerUtil = new LongEventProducerUtil(ringBuffer);

        for( int i = 0; i < 10; i++ ){
            LongEvent longEvent = new LongEvent(Long.valueOf(i));
            System.out.println("sleep前");
            longEventProducerUtil.setLongEventInRinBuffer( longEvent);
            System.out.println("sleep后");
        }
    }
}
