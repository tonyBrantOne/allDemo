package com.dyc.mqOnline.controller;
/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 19:32
 * @Description:
 */

import com.dyc.demo3.Listen.PlayerEventHandler;
import com.dyc.demo3.Listen.QueueRunnable;
import com.dyc.demo3.model.producer.Producer;
import com.dyc.demo3.util.ParamMapUtil;
import com.dyc.mqOnline.model.Player;
import com.dyc.mqOnline.service.TestService;
import com.dyc.mqOnline.test.MqRunnableTest;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: tony_jaa
 * @Date: 2018/10/9 19:32
 * @Description:
 */
@Controller
public class TestController implements ApplicationContextAware,InitializingBean {

    private static final String PREFIX = "/views/";
    private static final String SUFFIX_JSP = ".jsp";
    private static final String SUFFIX_HTML = ".html";
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    private AtomicInteger atomicOnlne = new AtomicInteger(0);


    public static Integer countNum ;
    public static CountDownLatch beginCountDownLatch ;
    public static  CountDownLatch countDownLatch ;

    @Autowired
    private TestService testService;


    @RequestMapping("/hall")
    public String hall( HttpServletRequest request, HttpServletResponse response, Model model ){

        System.out.println("测试页面");
        model.addAttribute("countNum",2000);
        model.addAttribute("num","第"+ atomicInteger + "次请求");
        return PREFIX +"index" + SUFFIX_JSP;
    }




    @RequestMapping("/testUpdate")
    public String testUpdate(@RequestParam Integer id,@RequestParam Integer num, HttpServletRequest request, HttpServletResponse response, Model model ) throws InterruptedException {
        int onlineNum = atomicOnlne.incrementAndGet() % 2;
        this.setCountNum(num);
        for( int i = 0; i < countNum; i++){
        //    MyRunnable playerEventMain = new MyRunnable(i);
            MqRunnableTest playerEventMain = new MqRunnableTest(id == null?i:id,onlineNum);
            Thread thread = new Thread(playerEventMain);
            thread.start();
        }
        System.out.println("");
        System.out.println("");
        System.out.println("并发数据准备中，onlineNum = " + onlineNum);
        System.out.println("================================");
        Thread.sleep(2000);
        beginCountDownLatch.countDown();
        Date beginDate = new Date();
        System.out.println("开始冲刺，计时开始：" + beginDate);
        System.out.println("================================");
        countDownLatch.await();
        System.out.println("================================");
        System.out.println("总共运行的线程请求 = " + atomicInteger);
        Date endDate = new Date();
        System.out.println("结束计时 = +" + endDate);
        System.out.println("总共耗时 = " + (endDate.getTime() - beginDate.getTime()) + "ms");

        model.addAttribute("num","第"+ atomicInteger + "次请求");
        model.addAttribute("countNum",countNum);
        return PREFIX +"index" + SUFFIX_JSP;
    }








    public void setCountNum( Integer num){
        countNum = num;
        QueueRunnable.atomicInteger.set(0);
        atomicInteger =  new AtomicInteger(0);
        beginCountDownLatch = new CountDownLatch(1);
        countDownLatch = new CountDownLatch(countNum/1000);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ParamMapUtil.CONTEXT_MAP.put(ApplicationContext.class,applicationContext);
        Object object = applicationContext.getBean("testServiceImpl");
        if( object instanceof TestService){
            testService = (TestService) object;
        }
        PlayerEventHandler.setTestService(testService);
        QueueRunnable.setTestService(testService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Producer.getNewinstance();
    }


    class MyRunnable implements Runnable{
        private int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                Player player = new Player(i,1);
                player.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
                player.setLastTime(new Timestamp(System.currentTimeMillis()));
                beginCountDownLatch.await();
                testService.updateMqCapability(player);
                System.out.println("在线状态更新结束 : " + "i的序号为 = " + i + ";线程名称 = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                atomicInteger.getAndIncrement();
                countDownLatch.countDown();
            }
        }
    }
}
