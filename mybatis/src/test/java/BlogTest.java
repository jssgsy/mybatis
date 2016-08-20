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
 *
 * 1. insert,update,delete方法的返回值均是相应sql语句执行后受影响的记录数。
 *      insert:返回新增成功的记录数;
 *      update:返回更新成功的记录数;
 *      delete:返回删除成功的记录数;
 *
 * 2. 关于in操作(删除，查询，更新等):即使in后面的括号中有不匹配的值,in查询也能成功。
 *      假设数据库中只存在id为1的记录,则delete from blog where id in (1,2,3);也能执行成功。
 *      结果是成功删除id为1的记录并返回1。即使数据库中没有记录为1,2,3的记录,上述sql语句也能正确执行,返回0.
 *
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
        Blog blog = new Blog("blogTitle3", "blogContent6");

        /**
         * insert返回成功插入的记录数。
         * 单条记录插入成功返回   1;
         * 批量插入成功过返回    n;
         */
        int affectedRows = sqlSession.insert("BlogMapper.insert", blog);
        System.out.println("此次insert被影响的记录数为: " + affectedRows);
        System.out.println("插入时自动产生的id值(需要在sql语句中配置): " + blog.getId());
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
        int affectedRows = sqlSession.update("BlogMapper.update", new Blog((long)7,"xxxx"));
        System.out.println("此次update被影响的记录数为: " + affectedRows);
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
        int affectedRows = sqlSession.delete("BlogMapper.deleteById", 7);
        System.out.println("此次delete被影响的记录数为: " + affectedRows);
        sqlSession.commit();
    }

}
