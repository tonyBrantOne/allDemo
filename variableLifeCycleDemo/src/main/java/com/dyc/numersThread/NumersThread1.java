package com.dyc.numersThread;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:对线程进行遍历
 */
public class NumersThread1 {
    List<UserDTO> list = new ArrayList<>();
    public static void main(String[] args) {
        new NumersThread1().startMain();
    }
    public void startMain(){
        Integer count = 0;
        while ( true ){
            Thread thread = new Thread(new MyRunnable());
            thread.setName("tony"+ count++);
            thread.start();
        }
    }



    class MyRunnable implements Runnable{

        @Override
        public void run() {
            test();
        }

        public void test(){
                UserDTO userDTO = new UserDTO();
                list.add(userDTO);
                System.out.println(Thread.currentThread().getName());
        }
    }
}
