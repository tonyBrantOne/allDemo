package com.dyc;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/26 15:43
 * @Description:
 */

import java.net.URL;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/26 15:43
 * @Description:
 */
public class ClassLoadPath {

    public static void main(String[] args) {
        URL url = ClassLoadPath.class.getClassLoader().getResource("/");
        System.out.println(url);
    }

}
