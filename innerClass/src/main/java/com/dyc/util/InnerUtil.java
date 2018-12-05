package com.dyc.util;

import com.dyc.listen.BaseEventListen;
import com.dyc.listen.InnerEventListen;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 17:56
 * @Description:
 */
public class InnerUtil {

    /**
     * 创建内部类
     */
    public static void createInnerClass(){
        BaseEventListen baseEventListen = new InnerEventListen(){
            @Override
            public String doHandle(String string) {
                System.out.println("代理了父类的doHandle");
                return super.doHandle(string);
            }
        };
        String s = baseEventListen.doHandle("返回值");
        System.out.println(s);
    }

    /**
     * 创建匿名内部类
     */
    public static void createNoNameInnerClass(){
        BaseEventListen baseEventListen = new BaseEventListen() {
            @Override
            public String doHandle(String string) {
                System.out.println("进入到了匿名内部类里边去了");
                return string;
            }
        };
        baseEventListen.doHandle("我来了");
    }

    /**
     * 匿名内部类直接调用，不用再用引用去接收一下，然后再调用
     */
    public static void createNoNameInnerClass2(){
        new BaseEventListen() {
            public String doHandle(String string) {
                System.out.println("进入到了匿名内部类里边去了2");
                return string;
            }
        }.doHandle("我来到了");
    }



}
