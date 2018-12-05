package com.classLoader.util;/**
 * @Auther: tony_jaa
 * @Date: 2018/8/21 13:17
 * @Description:
 */

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/21 13:17
 * @Description:
 */
public class MyURLClassLoader extends URLClassLoader {
    public MyURLClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

//    public void addJar(URL url) {
//        super.addURL(url);
//    }

    @Override
    protected void addURL(URL url) {
        super.addURL(url);
    }
}
