package com.dyc;

import com.dyc.model.User;
import com.dyc.util.base.AssembUtil;
import com.dyc.util.base.BaseUtil;
import com.dyc.util.UserUtil;
import com.dyc.util.base.ProxyUtil;

/**
 * Hello world!
 *
 */
public class ProxyStart
{
    public static void main( String[] args )
    {
        String str = AssembUtil.getObjectByUser(new User("dyc","tony",18));
        System.out.println(str);

        String str2 = AssembUtil.getObject2ByUser(new User("dyc2","tony2",19));
        System.out.println(str2);

        String str3 = AssembUtil.getEventByUser(new User("dyc3","tony3",21));
        System.out.println(str3);
    }
}
