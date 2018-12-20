package com.dyc;

import com.dyc.annotation.AutoRecord;
import com.dyc.annotation.UserAnnotion;
import com.dyc.model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Object object = new User();

        Method[] methods = object.getClass().getSuperclass().getDeclaredMethods();
//        getOneMethod(methods);
//        System.out.println("=============");
        Method[] methods2 = object.getClass().getDeclaredMethods();
//        getOneMethod(methods2);

        getOneMethod(methods2);

    }

    public static Method getOneMethod(  Method[] methods){
        for( Method method : methods ){
            AutoRecord autoRecord = method.getAnnotation(AutoRecord.class);
            UserAnnotion userAnnotion = method.getAnnotation(UserAnnotion.class);
            System.out.println("autoRecord"+autoRecord);
            System.out.println("userAnnotion:"+userAnnotion);
        }
        return null;
    }

    public static Method getOneMethod2(  Method[] methods){
        for( Method method : methods ){
            AutoRecord autoRecord = method.getAnnotation(AutoRecord.class);
            Annotation[] annotations = method.getDeclaredAnnotations();
            for( Annotation annotation :annotations  ){
                System.out.println(annotation);
            }

        }
        return null;
    }
}
