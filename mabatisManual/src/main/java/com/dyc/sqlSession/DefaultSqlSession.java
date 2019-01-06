package com.dyc.sqlSession;

import com.dyc.config.Configuration;
import com.dyc.config.MappedStatement;
import com.dyc.excutor.DefaultExcutor;
import com.dyc.excutor.Excutor;
import com.dyc.util.ProxyUtil;

import java.util.List;

/**
 * title:
 * create by tony_jaa
 * date 2019/1/6
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Excutor excutor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        this.excutor = new DefaultExcutor();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T selectOne(String statement, Object parametre) {
        List<Object> list = this.selectList(statement,parametre);
        if( null == list || 0 == list.size() ) {
            return null;
        }
        if( list.size() > 1 ) {
            throw new RuntimeException("");
        }
        return (T) list.get(0);
    }

    @Override
    public <T> List<T> selectList(String statement, Object parametre) {
        MappedStatement ms =  configuration.getMappedStatements().get(statement);
        return excutor.query(ms,parametre);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return ProxyUtil.getInstance(type,this);
    }
}
