package com.dyc.util.base;

import com.dyc.model.User;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:21
 * @Description:
 */
public interface BaseUtil {
    public abstract String getObjectByUser(User user);

    public abstract String getObject2ByUser(User user);

    public abstract String getPassByUser(User user);
}
