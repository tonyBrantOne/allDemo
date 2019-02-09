package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/18 13:57
 * @Description:
 */

import java.awt.*;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/18 13:57
 * @Description:
 */
public class InnerCallOuter {

    public static void main(String[] args) {
       new InnerCallOuter().startMain();
    }

    public void startMain(){
        System.out.println("this " + this);
        new Thread( this.new MyRunnable() ).start();
    }

    public void test(){
        System.out.println(this);
    }





    /**
     *
     */
    public class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(InnerCallOuter.this);
            InnerCallOuter.this.test();
        }
    }


}
