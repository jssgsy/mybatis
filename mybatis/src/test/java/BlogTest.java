import com.miaxis.entity.Blog;
import com.miaxis.util.MybatisSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

/**
 * Univ
 * 16/7/22 09:16
 */

/**
 * 对单表的测试,这里以Blog为例,Author类似。
 */
public class BlogTest {

    /**
     * 新增单条blog
     * @throws IOException
     */
    @Test
    public void addBlog() throws IOException{

        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("BlogMapper.add", new Blog("blogTitle3","blogContent6"));
        sqlSession.commit();
    }

    /**
     * 更新单条blog
     * @throws IOException
     */
    @Test
    public void updateBlog() throws IOException{

        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.update("BlogMapper.update", new Blog((long)7,"xxxx"));
        sqlSession.commit();

    }

    /**
     * 获取单条blog
     * @throws IOException
     */
    @Test
    public void getBlogById() throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Blog blog = sqlSession.selectOne("BlogMapper.selectBlogById", 7);
        System.out.println(blog.getTitle());
        System.out.println(blog.getContent());
        sqlSession.commit();
    }

    /**
     * 根据id删blog
     * @throws IOException
     */
    @Test
    public void deleteBlogById() throws IOException{
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("BlogMapper.deleteById", 7);
        sqlSession.commit();
    }

}
