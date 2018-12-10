package com.dyc.ThreadPool.ThreadPoolExcetureDemo.baseTest;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 19:14
 * @Description:
 */

import com.dyc.model.UserDTO;

import java.util.concurrent.*;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 19:14
 * @Description:ThreadPoolExecutor+Runnable的使用
 */
public class ThreadPoolExcetureRunnableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ThreadPoolExcetureRunnableTest().startMain();
    }



    public void startMain() throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 10, 200,TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        FutureTask<UserDTO> futureTask = new FutureTask(new MyCallable(this,"tony_jaa"));
        executorService.submit(futureTask);
        UserDTO userDTO = futureTask.get();
        System.out.println("userDTO=="+userDTO);
    }

    class MyCallable implements Callable<UserDTO> {

        ThreadPoolExcetureRunnableTest threadPoolExcetureBaseTest;
        String name;

        public MyCallable(ThreadPoolExcetureRunnableTest threadPoolExcetureBaseTest, String name) {
            this.threadPoolExcetureBaseTest = threadPoolExcetureBaseTest;
            this.name = name;
        }

        @Override
        public UserDTO call() throws Exception {
            UserDTO userDTO = new UserDTO(threadPoolExcetureBaseTest.test(name));
            System.out.println("休眠中");
            Thread.sleep(3000);
            System.out.println("休眠结束");
            return userDTO;
        }


    }

    public String test( String str){
    //    System.out.println("test"+ str);
        return str + "test";
    }
}
