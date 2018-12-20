package com.dyc.singleThread;
import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:对一个线程里的方法进行遍历
 */
public class SingleThread2 {

    public static void main(String[] args) {
        new SingleThread2().startMain();
    }
    public void startMain(){
        Thread thread = new Thread(new MyRunnable());
        thread.setName("tony");
        thread.start();
    }



    class MyRunnable implements Runnable{

        @Override
        public void run() {
            test();
        }

        public void test(){
            List<UserDTO> list = new ArrayList<>();
            while ( true ){
                UserDTO userDTO = new UserDTO();
                list.add(userDTO);
                System.out.println(Thread.currentThread().getName());
            }
        }
    }
}
