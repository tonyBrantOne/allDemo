package com.dyc.Demo1.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/17 11:00
 * @Description:
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/17 11:00
 * @Description:
 */
public class ShiroUtil {

    public AuthorizingRealm createAccoutRealm(){
        SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();
        simpleAccountRealm.addAccount("dyc","tony");
        return simpleAccountRealm;
    }

    public void isLogin(){
        DefaultSecurityManager defaultSecurityManager =new DefaultSecurityManager();
        //设置realm
        defaultSecurityManager.setRealm(createAccoutRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        //设置token
        AuthenticationToken usernamePasswordToken = new UsernamePasswordToken("dyc","tony");


        subject.login(usernamePasswordToken);
    }
}
