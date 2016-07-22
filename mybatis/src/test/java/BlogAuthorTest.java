import com.miaxis.entity.Author;
import com.miaxis.entity.Blog;
import com.miaxis.util.MybatisSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Univ
 * 16/7/22 09:16
 */

/**
 * Blog和Author的关联测试
 */
public class BlogAuthorTest {

    /**
     * 根据某个blog获取其所属的author
     * @throws IOException
     */
    @Test
    public void getBlogAuthor() throws IOException {

        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
		Blog blog = sqlSession.selectOne("BlogMapper.selectBlogAuthorById", 3);
		Author author = blog.getAuthor();
		System.out.println(author.getName());
    }

    /**
     * 根据某个author找出其所有的blog
     * @throws IOException
     */
    @Test
    public void getAuthorBlogs() throws IOException {

        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
		Author author = sqlSession.selectOne("AuthorMapper.selectAuthor", 3);
		System.out.println("此作者的名字为: " + author.getName());
		List<Blog> blogList = author.getBlogList();
		Iterator<Blog> iterator = blogList.iterator();
		while (iterator.hasNext()) {
			Blog blog = (Blog) iterator.next();
			System.out.println(blog.getTitle());
			System.out.println(blog.getContent());
		}
    }
}
