package com.dyc.boundlessCycle;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:41
 * @Description:
 */
public class ParamBoundless {

    public static void main(String[] args) {
        List<UserDTO> list = new ArrayList<>();
        Integer count = 0;
        while (true){
            list.add(new UserDTO());
            System.out.println("创建实例个数："+count++);
        }
    }


}
