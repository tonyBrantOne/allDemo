package com.dyc.Demo1;/**
 * @Auther: tony_jaa
 * @Date: 2018/7/17 10:59
 * @Description:
 */

import com.dyc.Demo1.util.ShiroUtil;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/17 10:59
 * @Description:
 */
public class StartMain {
    public static void main(String[] args) {
        ShiroUtil shiroUtil = new ShiroUtil();
        shiroUtil.isLogin();
    }
}
