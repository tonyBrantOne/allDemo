package calcurlatorProduct.util;

import java.util.concurrent.CountDownLatch;

/**
 * title:
 * create by tony_jaa
 * date 2018/11/18
 */
public class ConstantMap {
    public static Integer num = 200;
    public static Integer allMoney = 1000;
    public static final String MONEY_KEY = "money_key";
    public static CountDownLatch countDownLatchEnd = new CountDownLatch(num);
}
