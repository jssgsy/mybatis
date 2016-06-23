package com.miaxis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.miaxis.entity.Blog;

public class HelloWorld {

	@Test
	public void get() throws IOException{
		String resource = "config/mybatis-config.xml";//config在src目录下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
		//根据id获得单条blog记录
		Blog blog = session.selectOne("BlogMapper.selectBlogById", new Blog((long)2));
		System.out.println(blog.getTitle());
		System.out.println(blog.getContent());
		
		//根据某个blog获取其所属的author
		/*Blog blog = session.selectOne("BlogMapper.selectBlogAuthorById", 1);
		Author author = blog.getAuthor();
		System.out.println(author.getName());*/
		
		//根据id获得获取单条作者的信息
	/*	Author author = session.selectOne("AuthorMapper.selectAuthorById", 2);
		System.out.println(author.getName());*/
		
		//根据某个author找出其所有的blog
		/*Author author = session.selectOne("AuthorMapper.selectAuthor", 2);
		System.out.println(author.getName());
		List<Blog> blogList = author.getBlogList();
		Iterator<Blog> iterator = blogList.iterator();
		while (iterator.hasNext()) {
			Blog blog = (Blog) iterator.next();
			System.out.println(blog.getTitle());
			System.out.println(blog.getContent());
		}*/		
	}	
	
	
	/**
	 * 根据id删blog
	 * @throws IOException 
	 */
	@Test
	public void deleteBlogById() throws IOException{
		String resource = "config/mybatis-config.xml";//config在src目录下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("BlogMapper.deleteById", 2);
		sqlSession.commit();		
	}
	
	/**
	 * 更新单条blog
	 * @throws IOException 
	 */
	@Test
	public void updateBlog() throws IOException{
		String resource = "config/mybatis-config.xml";//config在src目录下
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("BlogMapper.update", new Blog((long)3,"new blog title"));
		sqlSession.commit();		
	}
	
	/**
	 * 新增单条blog
	 * @throws IOException 
	 */
	@Test
	public void addBlog() throws IOException{
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("BlogMapper.add", new Blog("blogTitle3","blogContent3"));
		sqlSession.commit();		
	}
	
	
	
	
}
