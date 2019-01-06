package com.dyc.sqlSession;

import com.dyc.config.Configuration;
import com.dyc.config.MappedStatement;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * title:
 * create by tony_jaa
 * date 2019/1/6
 */
public class SqlSessionFactory {
    private static final String MAPPER_CONFIG = "mappers";
    private Configuration configuration = new Configuration();

    public SqlSessionFactory() {
        readXmlFile();
    }

    public void readXmlFile(){
        URL url = SqlSessionFactory.class.getClassLoader().getResource(MAPPER_CONFIG);
        String packagesUrl = url.getFile();
        File scanFile = new File(packagesUrl);
        if( scanFile.isDirectory() ){
            //    String[] fileStr =scanFile.list();
            File[] files = scanFile.listFiles();
            for( File file : files ){
                Map<String,String> map = this.praseXml(file);
                this.loadMapperInfo(map);
            }
        }
    }

    private Map<String,String> praseXml( File file ){
        Map<String,String> map = new HashMap<>();
        return map;
    }

    private void loadMapperInfo( Map<String,String> map ){
        Map<String, MappedStatement> mappedStatements = new HashMap<>();
        MappedStatement mappedStatement = new MappedStatement();
        String sql = "select id,name from user where name = #{name}";
        mappedStatement.setHandelType("select");
        mappedStatement.setSourceId("com.dyc.dao.UserDao.selectList");
        mappedStatement.setNamespace("com.dyc.dao.UserDao");
        mappedStatement.setSql("select id,name from user where name = ? and id = ?");
        mappedStatement.setResultType("map");
        mappedStatement.setParamSortMap( getParamSort(sql));
        mappedStatements.put(mappedStatement.getSourceId(),mappedStatement);
        configuration.setMappedStatements(mappedStatements);
    }


    private Map<String,String>  getParamSort( String sql ){
        Map<String,String> map = new LinkedHashMap<>();
        map.put("1","name");
        map.put("2","id");
        return map;
    }

    public SqlSession openSession(){
        return new DefaultSqlSession(configuration);
    }
}
