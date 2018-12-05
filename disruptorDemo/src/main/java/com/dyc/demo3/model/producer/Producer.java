package com.dyc.demo3.model.producer;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 13:08
 * @Description:
 */

import com.dyc.demo3.Listen.PlayerEventHandler;
import com.dyc.demo3.controller.PlayerEventExceptionHandler;
import com.dyc.demo3.model.Player;
import com.dyc.demo3.model.PlayerEventFactory;
import com.dyc.demo3.util.PlayerEventProducerUtil;
import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/19 13:08
 * @Description:
 */
public class Producer {
    private static Producer producer;//单例对象
    private static final Integer ringBufferSize = 1024 * 1024; //配置队列的长度
    private static final Integer CONSUM_NUM = 8;//默认开8个消费者消费异步队列
    private static final WaitStrategy WAIT_STRATEGY = new SleepingWaitStrategy();
    PlayerEventFactory playerEventFactory = new PlayerEventFactory();//工厂类
    final ExecutorService executorService = Executors.newCachedThreadPool();//创建线程池
    RingBuffer<Player> ringBuffer;//异步队列对象

//    static {
//        producer = new Producer();
//    }

    private Producer() {
        init();
    }

    public static Producer getNewinstance() {
        if( null == producer ){
            synchronized ( Producer.class ){
                if( producer == null){
                    producer = new Producer();
                }
            }
        }
        return producer;
    }

    /**
     * 初始化异步队列对象并绑定游戏玩家更新通知事件
     */
    private void init(){
        /**
         * 定义CONSUM_NUM个消费者。
         */
        PlayerEventHandler[] playerEventHandlers = new PlayerEventHandler[CONSUM_NUM];
        for(int i = 0; i < CONSUM_NUM; i++){
            playerEventHandlers[i] = new PlayerEventHandler();
        }

        /**
         * 获取异步队列
         */
        ringBuffer = RingBuffer.create(ProducerType.MULTI, playerEventFactory, ringBufferSize, WAIT_STRATEGY);
        SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();


        /**
         * 观察者模式绑定消息者监听对象最终回调到onEvent的事件方法。
         */
        WorkerPool<Player> workerPool =  new WorkerPool<Player>(ringBuffer,sequenceBarrier,new PlayerEventExceptionHandler(),playerEventHandlers);
        ringBuffer.addGatingSequences(workerPool.getWorkerSequences());
        workerPool.start(executorService);//这里的启动不知道要做什么？
    }

    /**
     * 游戏玩家订阅更新状态的消息
     * @param id
     */
    public void producerOrderMsg(Long id ){
        PlayerEventProducerUtil longEventProducerUtil = new PlayerEventProducerUtil(ringBuffer);//最终都是要在异步队列中订阅消息
        Player player = new Player(id);
        longEventProducerUtil.setLongEventInRinBuffer( player );//克隆玩家id
    }



}
