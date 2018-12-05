package com.dyc.genericDemo1.util;

import java.math.BigDecimal;
import java.nio.ByteBuffer;

/**
 * @Auther: tony_jaa
 * @Date: 2018/7/23 14:02
 * @Description:
 */
public class BigDecimalUtil {


    public static void main(String[] args) {
        Double a = addBigdecimal(Double.class, 2,3);
        String b = addBigdecimal(String.class,"5", "6");
        BigDecimal c = addBigdecimal(BigDecimal.class, new BigDecimal(3),new BigDecimal(5));
        System.out.println("a=="+a);
        System.out.println("b=="+b);
        System.out.println("c=="+c);
        String d = addBigdecimal( null , 2,3);

    }


    /**
     * 通过方法的class<T>来确定泛型的值。
     * @param clazz
     * @param obj
     * @param obj2
     * @param <T>
     * @return
     */
        public static  <T>T addBigdecimal(Class<T> clazz , Object obj, Object obj2 ){
            Object result = null;
            BigDecimal bigDecimal = new BigDecimal(obj.toString());
            BigDecimal bigDecimal2 = new BigDecimal(obj2.toString());
            BigDecimal bigDecimal3 = bigDecimal.add(bigDecimal2);
            if( clazz == null){
            //    clazz = BigDecimal.class;
            }
            if( clazz == Double.class){
                result = Double.valueOf(bigDecimal3.toString());
            }else if( clazz == String.class){
                result = bigDecimal3.toString();
            }else{
                result = bigDecimal3;
            }
            return (T) result;
        }























}
