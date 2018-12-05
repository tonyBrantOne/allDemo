package com.dyc.util;

import com.dyc.model.User;
import com.dyc.util.base.AbstractBaseUtil;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:17
 * @Description:
 */
public class UserUtil extends AbstractBaseUtil {
    @Override
    public String getObjectByUser(User user) {
        return user.getName();
    }

    @Override
    public String getObject2ByUser(User user) {
        return user.getName();
    }
}
