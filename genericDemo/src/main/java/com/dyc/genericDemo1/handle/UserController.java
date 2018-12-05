package com.dyc.genericDemo1.handle;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:34
 * @Description:
 */

import com.dyc.genericDemo1.model.UserPO;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 13:34
 * @Description: 通过继承的方式对泛型进行确认，然后重写父类方法返回值就可以确定了。
 */
public class UserController extends AbstractBaseController<UserPO> {

    public void test1(){
       UserPO userPO =  registerUser(new UserPO());
    }


    @Override
    protected UserPO getPOLoginSuccess(UserPO userPO) {
        return null;
    }
}
