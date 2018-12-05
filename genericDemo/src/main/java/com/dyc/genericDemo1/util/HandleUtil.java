package com.dyc.genericDemo1.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:51
 * @Description:
 */

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:51
 * @Description:
 */
public class HandleUtil<T> {
    private T t;

    public HandleUtil(T t) {
        this.t = t;
    }


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
