package com.dyc.test;/**
 * @Auther: tony_jaa
 * @Date: 2018/12/8 11:18
 * @Description:
 */

import com.dyc.model.UserDTO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * @Auther: tony_jaa
 * @Date: 2018/12/8 11:18
 * @Description:
 */
public class ReflectTest2 {



    public static void main(String[] args) throws Exception {
   //     testInteger();
//        String str = "2";
//        String str1 = "1";
//        Integer object = Integer.valueOf("0");
//        Object result = object.getClass().getMethod("valueOf",String.class).invoke(object,str);
//        System.out.println(result.getClass());
//        System.out.println(result);
//
//        Object r = object.getClass().getMethod("parseInt",String.class).invoke(object,str1);
//        System.out.println(r.getClass());
//        System.out.println(r);

        test2();

    }

    public static void test1(){
        Object userDTO = new UserDTO();
        Field[] fields = userDTO.getClass().getDeclaredFields();
        for( Field field :fields ){
            String str = field.getGenericType().getTypeName();
            String  name = field.getName();
            System.out.println(str + " : " + name);
        }
    }

    public static void test2() throws Exception {
        Integer integer = Integer.valueOf("3");
        System.out.println(integer.getClass().getSimpleName());


        Object object = integer.getClass().newInstance();
        Object result = object.getClass().getMethod("valueOf",String.class).invoke(object,"4");
        System.out.println(result);
    }





}
