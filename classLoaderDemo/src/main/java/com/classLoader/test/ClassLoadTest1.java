package com.classLoader.test;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/24 16:43
 * @Description:测试jdk的classLoad
 */
public class ClassLoadTest1 {

    public static void main(String[] args) {
       new ClassLoadTest1().startMain();
    }

    public void startMain(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader);
        while ( classLoader != null ){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
