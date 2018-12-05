package com.dyc.demo2.Util;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/12 12:50
 * @Description:
 */
public class ZookeeperUtil {

    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public static ZooKeeper connection(String CONNECT_URL, Integer SESSIONOUT_TIME, Watcher watcher) throws Exception {
        ZooKeeper zk = new ZooKeeper(CONNECT_URL, SESSIONOUT_TIME,watcher);
        countDownLatch.await();
        return zk;
    }

    /**
     * 创建节点
     * @param zk
     */
    public static void createNode( ZooKeeper zk,final String creUrl,Object value ) throws KeeperException, InterruptedException {
        System.out.println("createNode方法开始");
        Thread.sleep(3000);
        zk.exists(creUrl,true);//绑定创建节点监听事件设置为true 观察对象为初始化时传入的watcher。
        zk.create(creUrl,String.valueOf(value).getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println("createNode方法结束");
    }

    public static void updateNode( ZooKeeper zk,final String updUrl,Object value ) throws KeeperException, InterruptedException {
        System.out.println("updateNode方法开始");
        Thread.sleep(3000);
        zk.exists(updUrl,true);//绑定修改节点监听事件。
        zk.setData(updUrl,String.valueOf(value).getBytes(), -1);
        System.out.println("updateNode方法结束");
    }


    public static void delNode( ZooKeeper zk,final String delUrl ) throws KeeperException, InterruptedException {
        System.out.println("delNode方法开始");
        Thread.sleep(3000);
        zk.exists(delUrl,true);//绑定修改节点监听事件。
        zk.delete(delUrl,-1);
        System.out.println("delNode方法结束");
    }
}
