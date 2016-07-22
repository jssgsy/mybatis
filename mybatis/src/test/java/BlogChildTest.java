import com.miaxis.entity.BlogChild;
import com.miaxis.util.MybatisSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Univ
 * 16/7/22 10:38
 */

/**
 * 具有继承关系实体类的测试
 */
public class BlogChildTest {

    /**
     * @throws IOException
     */
    @Test
    public void getBlogChild() throws IOException {

        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<BlogChild> bcList = sqlSession.selectList("BlogChildMapper.selectBlogChild");
        for (BlogChild bc : bcList) {
            System.out.println("继承的title: " + bc.getTitle());
            System.out.println("继承的content: " + bc.getContent());
            System.out.println("继承的author的id: " + bc.getAuthor().getId());
            System.out.println("继承的author的name: " + bc.getAuthor().getName());
            System.out.println("新增的authorName: " + bc.getAuhtorName());
            System.out.println("-------------------------------------------");
        }

    }

}
