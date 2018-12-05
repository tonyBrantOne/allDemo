package com.dyc.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:49
 * @Description:
 */

import com.dyc.model.User;
import com.dyc.util.base.AbstractBaseUtil;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 20:49
 * @Description:
 */
public class EventUtil extends AbstractBaseUtil {

    @Override
    public String getPassByUser(User user) {
        return user.getPasswaord();
    }
}
