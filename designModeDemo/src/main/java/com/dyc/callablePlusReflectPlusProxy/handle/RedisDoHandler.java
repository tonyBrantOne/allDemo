package com.dyc.callablePlusReflectPlusProxy.handle;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 17:50
 * @Description:
 */

import com.dyc.callablePlusReflectPlusProxy.annotion.AutoMapping;
import com.dyc.callablePlusReflectPlusProxy.model.BaseDTO;
import com.dyc.callablePlusReflectPlusProxy.model.RoleDTO;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/12 17:50
 * @Description:
 */
public class RedisDoHandler implements RedisHandler {

    @Override
    public FutureTask<RoleDTO> pushDataToRedis(RoleDTO roleDTO) {
        return new FutureTask<RoleDTO>(new Callable<RoleDTO>() {
            @Override
            public RoleDTO call() throws Exception {
                return new RoleDTO();
            }
        });
    }

    public RoleDTO addRedis(RoleDTO roleDTO) {
        roleDTO.setId(2);
        roleDTO.setName("addRedis");
        return roleDTO;
    }
}
