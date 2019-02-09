package com.dyc.test;/**
 * @Auther: tony_jaa
 * @Date: 2019/1/23 14:53
 * @Description:
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Auther: tony_jaa
 * @Date: 2019/1/23 14:53
 * @Description:
 */
public class GenericDAO {
    private Class entityClass;
    protected GenericDAO() {
        Type type = getClass().getGenericSuperclass();
        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
        this.entityClass = (Class) trueType;
        System.out.println(this.entityClass);
    }


}
