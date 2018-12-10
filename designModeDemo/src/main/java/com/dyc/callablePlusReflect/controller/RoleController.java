package com.dyc.callablePlusReflect.controller;

import com.dyc.callablePlusReflect.model.BaseDTO;
import com.dyc.callablePlusReflect.model.RoleDTO;
import com.dyc.callablePlusReflect.util.ThreadPoolUtil;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
        applicationContaxt.get(RoleController.class.getName()).startMain();
    }

    public void startMain() throws Exception {
        BaseDTO baseDTO = ThreadPoolUtil.execute(this,"addRole",new RoleDTO());
        System.out.println(baseDTO);
    }

    public RoleDTO addRole( RoleDTO roleDTO ){
        roleDTO.setId(Integer.valueOf(1));
        roleDTO.setName("tonyu_iaa");
        return roleDTO;
    }


}
