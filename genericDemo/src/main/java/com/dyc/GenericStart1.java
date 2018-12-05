package com.dyc;

import com.dyc.genericDemo1.model.UserPO;
import com.dyc.genericDemo1.util.HandleUtil;

/**
 * Hello world!
 *
 */
public class GenericStart1
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        /**
         * 通过构造方式对泛型进行确定 模仿 List<UserPO> list = new ArrayList<UserPO>
         */
        HandleUtil<UserPO> handleUtil = new HandleUtil<UserPO>(new UserPO());
        UserPO userPO  = handleUtil.getT();
    }
}
