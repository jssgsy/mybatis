package com.miaxis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Univ
 * 16/7/22 09:35
 */
public class MybatisSqlSessionUtil {

    public static final String resource = "config/mybatis-config.xml";

    private static SqlSessionFactory sqlSessionFactory;

    static{
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        return sqlSessionFactory;
    }

}
