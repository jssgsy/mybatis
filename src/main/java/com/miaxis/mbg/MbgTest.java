package com.miaxis.mbg;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.miaxis.util.MybatisSqlSessionUtil;

import model.Blog;
import model.BlogExample;

/**
 * @author univ
 * @datetime 2018/12/17 5:05 PM
 * @description 演示mbg的基本用法
 */
public class MbgTest {

    @Test
    public void basic() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 注意，使用全路径，xml文件中之所以不用全路径是因为已经利用mapper标签指定了namespace
        Blog blog = sqlSession.selectOne("mapper.BlogMapper.selectByPrimaryKey", 1l);
        System.out.print(blog.getId() + "  " + blog.getContent());
    }

    /**
     * 使用XxxExample对象
     */
    @Test
    public void useExample() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        /*
        使用XxxExample的方式：
            使用BlogExample创建Criteria对象，然后为此Criteria对象设置各种查询条件即可
         */
        BlogExample blogExample = new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        // 这里可链式调用
        criteria.andTitleEqualTo("blogTitle3");


        List<Blog> list = sqlSession.selectList("mapper.BlogMapper.selectByExample", blogExample);
        for (Blog b : list) {
            System.out.print(b.getId() + "  " + b.getContent());
            System.out.println();
        }
    }

}
