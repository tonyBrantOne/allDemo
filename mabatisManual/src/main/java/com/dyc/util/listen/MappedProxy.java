package com.dyc.util.listen;

import com.dyc.config.Configuration;
import com.dyc.config.MappedStatement;
import com.dyc.sqlSession.DefaultSqlSession;
import com.dyc.sqlSession.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MappedProxy implements InvocationHandler {
    public SqlSession sqlSession;

    public MappedProxy(SqlSession target) {
        this.sqlSession = target;
    }

    /**
     * 代理类调用任何方法都会到invoke这个方法里，从mehtod这个方法里就可以知道应该调用被代理类的哪个方法了。
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println("代理执行：=="+method.getDeclaringClass().getName()+"类=====执行："+method.getName());
//        System.out.println("传入的参数："+args[0]);
        String sourceId = method.getDeclaringClass().getName() + "." + method.getName();
        DefaultSqlSession defaultSqlSession = (DefaultSqlSession) sqlSession;
        Configuration configuration = defaultSqlSession.getConfiguration();
        Map<String, MappedStatement> mappedStatements = configuration.getMappedStatements();
        MappedStatement mappedStatement = mappedStatements.get(sourceId);
        String handelType = mappedStatement.getHandelType();
        Class<?> aClass = method.getReturnType();
        if( "select".equals(handelType) ){
           if( Collection.class.isAssignableFrom(aClass)){
               return defaultSqlSession.selectList(sourceId,args[0]);
           }
           return defaultSqlSession.selectOne(sourceId,args[0]);
        }
        return null;

    //    Object result =  method.invoke(target,args);
   //     System.out.println("执行后返回值:" + result);
    }
}
