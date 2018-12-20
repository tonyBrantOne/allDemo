package com.dyc.numersThread;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:56
 * @Description:对线程池遍历
 */
public class NumersThread2 {
    ExecutorService executorService = new ThreadPoolExecutor(5, 5, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3000));
    List<UserDTO> list = new ArrayList<>();
    public static void main(String[] args) {
        new NumersThread2().startMain();
    }
    public void startMain(){
        Integer count = 0;
        while (true){
//        for( int i = 0; i < 1000; i++){
            executorService.execute(new MyRunnable(count++));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    class MyRunnable implements Runnable{

        Integer i;

        public MyRunnable(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            test();
        }

        public void test(){
                UserDTO userDTO = new UserDTO();
                list.add(userDTO);
                System.out.println(Thread.currentThread().getName()+",  i="+i);
        }
    }
}
