package com.dyc.util.base;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:30
 * @Description:
 */

import com.dyc.model.User;
import com.dyc.util.EventUtil;
import com.dyc.util.UserUtil;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:30
 * @Description:
 */
public class AssembUtil {
    public static String getObjectByUser(User user){
        return  ProxyUtil.getInstance(BaseUtil.class, new UserUtil()).getObjectByUser(user);
    }

    public static String getObject2ByUser(User user){
        return  ProxyUtil.getInstance(BaseUtil.class, new UserUtil()).getObject2ByUser(user);
    }

    public static String getEventByUser(User user){
        return  ProxyUtil.getInstance(BaseUtil.class, new EventUtil()).getPassByUser(user);
    }

}
