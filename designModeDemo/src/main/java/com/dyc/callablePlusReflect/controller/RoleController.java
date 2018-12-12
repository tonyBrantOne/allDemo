package com.dyc.callablePlusReflect.controller;

import com.dyc.callablePlusReflect.model.BaseDTO;
import com.dyc.callablePlusReflect.model.RoleDTO;
import com.dyc.callablePlusReflect.util.ThreadPoolUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:27
 * @Description:
 */
public class RoleController extends BaseController{

    private static Map<String,RoleController> applicationContaxt = new ConcurrentHashMap();

    static {
        RoleController roleController = new RoleController();
        applicationContaxt.put(roleController.getClass().getName(),roleController);
    }

    public static void main(String[] args) throws Exception {
    //    applicationContaxt.get(RoleController.class.getName()).startMain();
        applicationContaxt.get(RoleController.class.getName()).startMainUnWaitting();
    }

    /**
     * 有返回值，如果需要用到返回值，则调用futureTask.get()获取，要注意这个方法有阻塞。
     * @throws Exception
     */
    public void startMain() throws Exception {
        FutureTask<RoleDTO> futureTask = ThreadPoolUtil.execute(this,"addRole",new RoleDTO(),RoleDTO.class);
        System.out.println("开始阻塞");
        System.out.println(futureTask.get());
        System.out.println("结束阻塞");
    }

    /**
     * 无返回值，适合直接把数据异步保存到redis中
     * @throws Exception
     */
    public void startMainUnWaitting() throws Exception {
        FutureTask<RoleDTO> futureTask = ThreadPoolUtil.execute(this,"addRole",new RoleDTO(),RoleDTO.class);
        System.out.println("开始阻塞");
        System.out.println("结束阻塞");
    }

    public RoleDTO addRole( RoleDTO roleDTO ){
        roleDTO.setId(Integer.valueOf(1));
        roleDTO.setName("tonyu_iaa");
        return roleDTO;
    }


}
