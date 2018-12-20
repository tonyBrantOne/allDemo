package com.dyc.singleThread;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:对线程里的一个方法进行递归
 */
public class SingleThread1 {

    public static void main(String[] args) {
        new SingleThread1().startMain();
    }
    public void startMain(){
        Thread thread = new Thread(new MyRunnable());
        thread.setName("tony");
        thread.start();
    }



    class MyRunnable implements Runnable{
        List<UserDTO> list = new ArrayList<>();
        @Override
        public void run() {
            test();
        }

        public void test(){
            try {
                if ( true ){
                    UserDTO userDTO = new UserDTO();
                    list.add(userDTO);
                    System.out.println(Thread.currentThread().getName());
                }
            }finally {
                test();
            }

        }
    }
}
