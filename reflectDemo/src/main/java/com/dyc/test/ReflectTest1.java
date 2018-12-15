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
public class ReflectTest1 {



    public static void main(String[] args) throws Exception {
        testInteger();

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


    public static void testInteger() throws Exception {
        Object userDTO = new UserDTO();
        Field field = userDTO.getClass().getSuperclass().getDeclaredField("parentId");
        Type type = field.getGenericType();
        String typeName = type.getTypeName();
        System.out.println(typeName);
        Class<?> clazz = Class.forName(typeName);
        Integer b = 1;
        String str = "";
        System.out.println( b.getClass() == clazz);
        System.out.println( str.getClass() == clazz);
        System.out.println( int.class == clazz);


//        reflectSetEntity("id",b,userDTO,clazz);
//
//        System.out.println(type);
//        System.out.println(typeName);
//        System.out.println(clazz);

    }

    public static void testInt() throws Exception {
        UserDTO userDTO = new UserDTO();
        Field field = userDTO.getClass().getDeclaredField("card");
        Type type = field.getGenericType();
        String typeName = type.getTypeName();
        int b = Integer.valueOf(2);
        reflectSetEntity("card",b,userDTO);
        System.out.println(userDTO);
    }



    public static void reflectSetEntity( String methodName,Object param, Object iEntity) {
        try {
            methodName = methodName.substring(0,1).toUpperCase() + methodName.substring(1,methodName.length());
            Method method = iEntity.getClass().getMethod("set"+methodName,int.class);
            method.invoke(iEntity,param);
        }catch (Exception e){
          e.printStackTrace();
        }
    }

    public static void reflectSetEntity( String methodName,Object param,Object iEntity,Class clazz) {
        try {
            methodName = methodName.substring(0,1).toUpperCase() + methodName.substring(1,methodName.length());
            Method method = iEntity.getClass().getMethod("set"+methodName,clazz);
            method.invoke(iEntity,param);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
