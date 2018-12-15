package com.dyc.callablePlusReflect.service;

import com.dyc.callablePlusReflect.model.RoleDTO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/10 20:28
 * @Description:
 */
public interface RoleService {

    /**
     * 把角色对象添加到redis中。
     * @param roleDTO
     * @return
     */
    public String addRoleToRedis(RoleDTO roleDTO);
}
