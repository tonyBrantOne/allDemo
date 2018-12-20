package com.dyc.boundlessCycle;

import com.dyc.model.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/17 12:41
 * @Description:
 */
public class ParamBoundless3 {

    public static void main(String[] args) {
        new ParamBoundless3().startMain();
    }

    public void startMain(){
        test2();
    }



    public void test(){
        System.out.println("递归啦");
        test();
    }

    public void test2(){
        while ( true ){
            System.out.println("死循环啦");
        }
    }


}
