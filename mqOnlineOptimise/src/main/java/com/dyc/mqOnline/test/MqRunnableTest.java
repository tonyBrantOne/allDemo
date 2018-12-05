package com.dyc.mqOnline.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/10/11 12:02
 * @Description:
 */

import com.dyc.demo3.model.producer.Producer;
import com.dyc.mqOnline.controller.TestController;
import com.dyc.mqOnline.service.TestService;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/11 12:02
 * @Description:
 */
public class MqRunnableTest implements Runnable {
    private int i;
    private Integer online;

    public MqRunnableTest( int i,Integer online) {
        this.i = i;
        this.online = online;
    }





    @Override
    public void run() {
        try {
            TestController.beginCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Producer producer = Producer.getNewinstance();
        producer.producerOrderMsg(Long.valueOf(i),this.online);
    }
}
