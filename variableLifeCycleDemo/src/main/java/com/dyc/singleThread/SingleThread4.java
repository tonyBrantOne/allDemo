package com.dyc.singleThread;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:对线程池里的单个线程一个方法进行死循环
 */
public class SingleThread4 {

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    List<UserDTO> list = new ArrayList<>();


    public static void main(String[] args) {
        new SingleThread3().startMain();
    }
    public void startMain(){
        Integer count = 0;
        executorService.execute(new MyRunnable(count++));
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
            while ( true ){
                UserDTO userDTO = new UserDTO();
                list.add(userDTO);
                System.out.println(Thread.currentThread().getName() + count);
            }
        }
    }
}
