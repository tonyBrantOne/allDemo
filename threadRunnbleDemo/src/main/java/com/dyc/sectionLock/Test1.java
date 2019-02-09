package com.dyc.sectionLock;

import com.dyc.model.UserDTO;

/**
 * title:
 * create by tony_jaa
 * date 2019/2/7
 */
public class Test1 {
    private UserDTO[] arr = new UserDTO[4];
    public static void main(String[] args) {
        new Test1().startMain();
    }

    public void startMain(){
        arr[0] = new UserDTO(3,"tony");
        arr[1] = new UserDTO(3,"tony");
        arr[2] = new UserDTO(3,"tony2");
        arr[3] = new UserDTO(4,"tony2");
        for( int i = 0; i < 4; i++ ){
            UserDTO userDTO = arr[i];
            System.out.println("hashcode:" + userDTO.hashCode());
            Thread thread = new Thread( new MyRunnable(userDTO));
            thread.setName("" + i);
            thread.start();
        }
    }

    public class MyRunnable implements Runnable{

        private UserDTO userDTO;

        public MyRunnable(UserDTO userDTO) {
            this.userDTO = userDTO;
        }

        @Override
        public void run() {
            synchronized (userDTO.getName()){
                System.out.println("当前线程："+Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"结束");
            }
        }
    }



}
