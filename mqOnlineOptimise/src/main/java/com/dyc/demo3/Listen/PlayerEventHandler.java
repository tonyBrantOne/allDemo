package com.dyc.demo3.Listen;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */


import com.dyc.demo3.PlayerEventMain;
import com.dyc.demo3.util.ParamMapUtil;
import com.dyc.demo3.util.PlayerEventExceptionUtil;
import com.dyc.mqOnline.controller.TestController;
import com.dyc.mqOnline.model.Player;
import com.dyc.mqOnline.service.TestService;
import com.lmax.disruptor.WorkHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */
public class PlayerEventHandler implements WorkHandler<Player> {
    public static List<Long> list = new ArrayList<Long>();
    public static LinkedBlockingQueue<Player> linkedBlockingQueue = new LinkedBlockingQueue<>();
    private static TestService testService;

    @Override
    public void onEvent(Player longEvent) throws Exception {
        try {
            longEvent.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
            longEvent.setLastTime(new Timestamp(System.currentTimeMillis()));
            linkedBlockingQueue.put(longEvent);
    //        longEvent.getListPlayer().add(longEvent);
     //       testService.updateMqCapabilityByPath(longEvent);
    //        System.out.println("mq在线状态修改结束 : " + "i的序号为 = " + longEvent.getId() + ";线程名称 = " + Thread.currentThread().getName());
        }catch (RuntimeException e){
            PlayerEventExceptionUtil.handleEventException(e,longEvent);
        }finally {
//            TestController.atomicInteger.getAndIncrement();
//            TestController.countDownLatch.countDown();
        }
    }

    public static TestService getTestService() {
        return testService;
    }

    public static void setTestService(TestService testService) {
        PlayerEventHandler.testService = testService;
    }
}
