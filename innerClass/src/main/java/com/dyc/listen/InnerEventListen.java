package com.dyc.listen;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 18:50
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 18:50
 * @Description:
 */
public class InnerEventListen implements BaseEventListen {
    @Override
    public String doHandle(String string) {
        System.out.println("doHandle的实现类");
        return string;
    }
}
