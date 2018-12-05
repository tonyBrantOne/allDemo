package com.dyc.demo2.Model;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/12 18:02
 * @Description:观察对象
 */
public class WatcherPO implements Watcher {
   private  CountDownLatch countDownLatch;




    public WatcherPO(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    /**
     * 绑定事件（事物操作）的回调方法
     * @param watchedEvent
     */
    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("");
        System.out.println("进入事件回调方法,查看当前zookeeper状态");
        Event.KeeperState keeperState = watchedEvent.getState();
        Event.EventType eventType = watchedEvent.getType();
        System.out.println("keeperState==="+keeperState + "  eventType===" + eventType);
        if(Event.KeeperState.SyncConnected == keeperState){ //
            if(Event.EventType.None == eventType){//连接建立成功
                System.out.println("回调通知：连接创建成功，可以开始API操作了");
                countDownLatch.countDown();
            }
            if(Event.EventType.NodeDataChanged == eventType){
                System.out.println("回调通知：节点修改成功");
            }
            if(Event.EventType.NodeCreated == eventType){
                System.out.println("回调通知：节点创建成功");
            }
            if(Event.EventType.NodeDeleted == eventType){
                System.out.println("回调通知：节点删除成功");
            }
        }
    }




















}
