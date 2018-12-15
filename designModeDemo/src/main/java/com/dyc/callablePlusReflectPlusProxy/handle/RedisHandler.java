package com.dyc.callablePlusReflectPlusProxy.handle;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 15:20
 * @Description:
 */


import com.dyc.callablePlusReflectPlusProxy.annotion.AutoMapping;
import com.dyc.callablePlusReflectPlusProxy.model.BaseDTO;
import com.dyc.callablePlusReflectPlusProxy.model.RoleDTO;

import java.util.concurrent.FutureTask;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 15:20
 * @Description:
 */
public interface RedisHandler {

    @AutoMapping("addRedis")
    public FutureTask<RoleDTO> pushDataToRedis(RoleDTO roleDTO);

}
