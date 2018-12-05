package com.dyc.demo2;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/12 17:59
 * @Description:
 */

import com.dyc.demo2.Model.WatcherPO;
import com.dyc.demo2.Util.ZookeeperUtil;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/12 17:59
 * @Description:
 */
public class StartMain {
    private static final String CONNECT_URL = "192.168.150.131:2181";
    private static final Integer SESSIONOUT_TIME = 5000;
    static ZooKeeper zk;
    static {
        try {
           zk = ZookeeperUtil.connection(CONNECT_URL,SESSIONOUT_TIME,new WatcherPO(ZookeeperUtil.getCountDownLatch()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String creUrl = "/dyc12";
            String updUrl = "/dyc8";
            String delUrl = "/dyc7";
            ZookeeperUtil.createNode(zk,creUrl,creUrl.substring(1,creUrl.length()));
            ZookeeperUtil.updateNode(zk,updUrl,updUrl.substring(1,creUrl.length() - 1));
            ZookeeperUtil.delNode( zk,delUrl );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
