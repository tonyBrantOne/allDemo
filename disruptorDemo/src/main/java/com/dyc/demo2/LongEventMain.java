package com.dyc.demo2;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:56
 * @Description:
 */

import com.dyc.demo2.Listen.LongEventHandler;
import com.dyc.demo2.controller.IntEventExceptionHandler;
import com.dyc.demo2.model.LongEvent;
import com.dyc.demo2.model.LongEventFactory;
import com.dyc.demo2.util.LongEventProducerUtil;
import com.lmax.disruptor.*;
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


        /**
         * 定义10个消费者。
         */
        LongEventHandler[] longEventHandlers = new LongEventHandler[5];
        for(int i = 0; i < 5; i++){
            longEventHandlers[i] = new LongEventHandler();
        }

        /**
         * 获取异步队列
         */
        RingBuffer<LongEvent> ringBuffer = RingBuffer.create(ProducerType.MULTI, longEventFactory, ringBufferSize,new SleepingWaitStrategy());
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();


        /**
         * 观察者模式绑定消息者监听对象最终回调到onEvent的事件方法。
         */
        WorkerPool<LongEvent> workerPool =  new WorkerPool<LongEvent>(ringBuffer,sequenceBarrier,new IntEventExceptionHandler(),longEventHandlers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(executorService);//这里的启动不知道要做什么？



        LongEventProducerUtil longEventProducerUtil = new LongEventProducerUtil(ringBuffer);//最终都是要在异步队列中订阅消息

        for( int i = 0; i < 10; i++ ){
            LongEvent longEvent = new LongEvent(Long.valueOf(i));
            System.out.println("sleep前");
            longEventProducerUtil.setLongEventInRinBuffer( longEvent);
            System.out.println("sleep后");
        }
    }

}
