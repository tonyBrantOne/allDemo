package com.classLoader.util;

import com.dyc.pub.model.User;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Auther: tony_jaa
 * @Date: 2018/8/21 11:25
 * @Description:
 */
public class SimpleClassLoaderUtil {
//    public static final String PATH_REPLACEED = "D:\\folder\\b\\";
    public static final String PATH_REPLACEED = "D:\\mavenSet\\test\\repository\\com\\dyc\\basePub\\1.0-SNAPSHOT\\";
    MyURLClassLoader myURLClassLoader = null;


    public static void main(String[] args) throws Exception {
//        while ( true ){
//            loaderClass();
//            Thread.sleep(1000);
//        }
        test1();
    }


    public static void test1() throws Exception {
     //   User user = new User();
        while (true){
            User user = new User();
            System.out.println("user=="+user + ",当前class对象为："+ User.class.hashCode());
            String str = user.getName();
            loaderClass();
        //    reloader();
            Thread.sleep(1000);
        }
    }

    /**
     * 原先的类加载器更改里边的URL
     * @throws Exception
     */
    public static void reloader() throws Exception {
        URL url =  new File(PATH_REPLACEED+"basePub-1.0-SNAPSHOT.jar").toURI().toURL();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Method addURL_method = classLoader.getClass().getDeclaredMethod("addURL", URL.class);
        addURL_method.invoke(classLoader,url);
        Class<?> clasz = classLoader.loadClass("com.dyc.pub.model.User");
        Method method = clasz.getDeclaredMethod("getName",null);
        Object object = method.invoke(clasz.newInstance(),null);
        System.out.println(object + ",当前class对象为："+ clasz.hashCode());
    }


    /**
     * 重新创建一个新的类加载器
     * @throws Exception
     */
    public static void loaderClass() throws Exception {
        URL url =  new File(PATH_REPLACEED+"basePub-1.0-SNAPSHOT.jar").toURI().toURL();
        MyURLClassLoader myURLClassLoader = new MyURLClassLoader(new URL[]{},null);
        myURLClassLoader.addURL(url);
        Class<?> clasz = myURLClassLoader.loadClass("com.dyc.pub.model.User");
        Object object = clasz.newInstance();
//        User user = (User) object;
        System.out.println(object+",clasz"+clasz.hashCode());
//        Thread.currentThread().setContextClassLoader(myURLClassLoader);
//        System.out.println("object" + object.toString() + ",当前class对象为："+ clasz.hashCode());
        //Method method = clasz.getDeclaredMethod("getName",null);
        //Object object = method.invoke(clasz.newInstance(),null);
    }




    public MyURLClassLoader getMyURLClassLoader() throws MalformedURLException {
        return myURLClassLoader;
    }

    public void setMyURLClassLoader(MyURLClassLoader myURLClassLoader) {
        this.myURLClassLoader = myURLClassLoader;
    }
}
