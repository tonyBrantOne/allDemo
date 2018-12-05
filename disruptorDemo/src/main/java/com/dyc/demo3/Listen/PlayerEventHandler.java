package com.dyc.demo3.Listen;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */


import com.dyc.demo3.PlayerEventMain;
import com.dyc.demo3.model.Player;
import com.dyc.demo3.model.producer.Producer;
import com.dyc.demo3.util.ParamMapUtil;
import com.dyc.demo3.util.PlayerEventExceptionUtil;
import com.lmax.disruptor.WorkHandler;

import java.util.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/18 16:37
 * @Description:
 */
public class PlayerEventHandler implements WorkHandler<Player> {
    public static List<Long> list = new ArrayList<Long>();
    @Override
    public void onEvent(Player longEvent) throws Exception {
        try {
            Thread.sleep(1000);
            System.out.println("休眠结束 : " + "i的序号为 = " + longEvent.getId() + ";线程名称 = " + Thread.currentThread().getName());
        }catch (RuntimeException e){
            PlayerEventExceptionUtil.handleEventException(e,longEvent);
        }finally {
            PlayerEventMain.atomicInteger.getAndIncrement();
            PlayerEventMain.countDownLatch.countDown();
        }
    }
}
