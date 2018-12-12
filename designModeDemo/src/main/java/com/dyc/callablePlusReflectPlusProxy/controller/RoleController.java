package com.dyc.callablePlusReflectPlusProxy.controller;

import com.dyc.callablePlusReflectPlusProxy.handle.RedisDoHandler;
import com.dyc.callablePlusReflectPlusProxy.handle.RedisHandler;
import com.dyc.callablePlusReflectPlusProxy.model.RoleDTO;
import com.dyc.callablePlusReflectPlusProxy.util.ProxyUtil;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:27
 * @Description:
 */
public class RoleController extends BaseController {

    private static Map<String,RoleController> applicationContaxt = new ConcurrentHashMap();

    static {
        RoleController roleController = new RoleController();
        applicationContaxt.put(roleController.getClass().getName(),roleController);
    }

    public static void main(String[] args) throws Exception {
        applicationContaxt.get(RoleController.class.getName()).startMain();
    }

    /**
     * 有返回值，如果需要用到返回值，则调用futureTask.get()获取，要注意这个方法有阻塞。
     * @throws Exception
     */
    public void startMain() throws Exception {
        System.out.println("startMain");
        RedisHandler redisHandleInterface = ProxyUtil.getInstance(RedisHandler.class,new RedisDoHandler());
        FutureTask<RoleDTO> futureTask = redisHandleInterface.pushDataToRedis(new RoleDTO());
        System.out.println("开始阻塞");
        System.out.println(futureTask.get());
        System.out.println("结束阻塞");
    }



}
