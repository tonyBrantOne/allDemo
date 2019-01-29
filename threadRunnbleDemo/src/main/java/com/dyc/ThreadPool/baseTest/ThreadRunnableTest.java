package com.dyc.ThreadPool.baseTest;

/**
 * title:
 * create by tony_jaa
 * date 2018/12/16
 */
public class ThreadRunnableTest {

    public static void main(String[] args) {
        new ThreadRunnableTest().startMain();
    }

    public void startMain(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                while (true){
//                    System.out.println("kkk");
//                }
            }
        });
        thread.start();
    }
}
