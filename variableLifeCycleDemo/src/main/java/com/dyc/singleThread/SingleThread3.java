package com.dyc.singleThread;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:循环线程池里的单个线程
 */
public class SingleThread3 {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<UserDTO> list = new ArrayList<>();


    public static void main(String[] args) {
        new SingleThread3().startMain();
    }
    public void startMain(){
        Integer count = 0;
        while ( true ){
            executorService.execute(new MyRunnable(count++));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }



    class MyRunnable implements Runnable{
        Integer count;

        public MyRunnable(Integer count) {
            this.count = count;
        }

        @Override
        public void run() {
            test();
        }

        public void test(){
                UserDTO userDTO = new UserDTO();
                list.add(userDTO);
                System.out.println(Thread.currentThread().getName() + count);
        }
    }
}
