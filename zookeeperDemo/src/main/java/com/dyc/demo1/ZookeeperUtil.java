package com.dyc.demo1;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/12 12:50
 * @Description:
 */
public class ZookeeperUtil {
    private static final String CONNECT_URL = "192.168.150.131:2181";
    private static final Integer SESSIONOUT_TIME = 5000;
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws KeeperException, InterruptedException {
        try {
                ZooKeeper zk = new ZooKeeper(CONNECT_URL, SESSIONOUT_TIME, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("");
                    System.out.println("进入事件回调方法,查看当前zookeeper状态");
                    Event.KeeperState keeperState = watchedEvent.getState();
                    Event.EventType eventType = watchedEvent.getType();
                    System.out.println("keeperState==="+keeperState);
                    System.out.println("eventType==="+eventType);
                    if(Event.KeeperState.SyncConnected == keeperState){ //如果是建立连接
                        if(Event.EventType.None == eventType){//连接建立成功
                            System.out.println("回调通知：连接创建成功，可以开始API操作了");
                            countDownLatch.countDown();
                        }
                        if(Event.EventType.NodeCreated == eventType){
                            System.out.println("回调通知：节点创建成功");
                        }
                        if(Event.EventType.NodeDataChanged == eventType){
                            System.out.println("回调通知：节点修改成功");
                        }
                        if(Event.EventType.NodeDeleted == eventType){
                            System.out.println("回调通知：节点删除成功");
                        }
                    }
                }
            });
            countDownLatch.await();
            createNode(zk);
            updateNode(zk);
            delNode(zk);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建节点
     * @param zk
     */
    public static void createNode( ZooKeeper zk ) throws KeeperException, InterruptedException {
        System.out.println("createNode节点创建开始");
        String creUrl = "/dyc8";
        Thread.sleep(3000);
        zk.exists(creUrl,true);//绑定创建节点监听事件。
        zk.create(creUrl,"tony6".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,CreateMode.PERSISTENT);
        System.out.println("createNode节点创建结束");
    }

    public static void updateNode( ZooKeeper zk ) throws KeeperException, InterruptedException {
        System.out.println("updateNode节点修改开始");
        String updUrl = "/dyc4";
        Thread.sleep(3000);
        zk.exists(updUrl,true);//绑定修改节点监听事件。
        zk.setData(updUrl,"tony4443".getBytes(), -1);
        System.out.println("updateNode节点修改结束");
    }

    public static void delNode( ZooKeeper zk ) throws KeeperException, InterruptedException {
        System.out.println("delNode节点删除开始");
        String delUrl = "/dyc3";
        Thread.sleep(3000);
        zk.exists(delUrl,true);//绑定修改节点监听事件。
        zk.delete(delUrl,-1);
        System.out.println("delNode节点删除结束");
    }
}
