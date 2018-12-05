package com.dyc;

import com.dyc.model.UserDTO;

import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
//        System.out.println( "Hello World!" );
//        Integer id = 1;
//        Object object = new UserDTO();
//        Method method = object.getClass().getMethod("setId",id.getClass());
//        method.invoke(object,id);
//        System.out.println(object);
        test();
    }

    public static void test(){
        String str = "3";
        System.out.println(str.getClass().getName());
    }
}
