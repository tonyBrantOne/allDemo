package com.dyc.model;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/14 16:56
 * @Description:
 */

import com.dyc.annotation.UserAnnotion;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/14 16:56
 * @Description:
 */
public class User extends BaseDTO {

    @Override
    @UserAnnotion
    public void list() {
        System.out.println("list");
    }
}
