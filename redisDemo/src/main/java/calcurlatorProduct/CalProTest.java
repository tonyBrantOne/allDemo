package calcurlatorProduct;

import calcurlatorProduct.service.AwardService;
import calcurlatorProduct.service.impl.AwardServiceImpl;
import calcurlatorProduct.util.ConstantMap;
import countNum.util.JedisUtil;

import java.util.concurrent.CountDownLatch;

/**
 * title:计算抽奖额度是否超出库存。
 * create by tony_jaa
 * date 2018/11/18
 */
public class CalProTest {
    private CountDownLatch countDownLatchBegin = new CountDownLatch(1);
    private AwardService awardService = new AwardServiceImpl();


    public static void main(String[] args) throws InterruptedException {
        new CalProTest().startTest();
    }

    public void startTest() throws InterruptedException {
        for(int i = 0; i < ConstantMap.num; i++ ){
            new Thread( new CommonRunnable(i) ).start();
        }
        System.out.println("开始准备并发数据=============");
        Thread.sleep(2000);
        System.out.println("准备完成=============");
        countDownLatchBegin.countDown();
        ConstantMap.countDownLatchEnd.await();
        System.out.println("执行结束剩余金额：" + JedisUtil.getJedis().get(ConstantMap.MONEY_KEY));
        JedisUtil.getJedis().del(ConstantMap.MONEY_KEY);
    }

    class CommonRunnable implements Runnable{
        private Integer i;

        public CommonRunnable(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                countDownLatchBegin.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            awardService.calSubAward();
        }
    }


}
