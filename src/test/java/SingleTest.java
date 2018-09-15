import com.miaxis.entity.Single;
import com.miaxis.util.MybatisSqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * mybatis-测试单个实体类
 */
public class SingleTest {

    //------------------------------------------------------------
    @Test
    public void getById() throws IOException {
        getByIdTemplate("SingleMapper.getById");
    }

    @Test
    public void getById2() throws IOException {
        getByIdTemplate("SingleMapper.getById2");
    }

    @Test
    public void getById3() throws IOException {
        getByIdTemplate("SingleMapper.getById3");
    }

    /**
     * 只是为了方便测试抽象的一个方法
     * @param s
     * @throws IOException
     */
    private void getByIdTemplate(String s) throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = sqlSession.selectOne(s, 1);
        if (single == null) {
            System.out.println("没有id为2的Single");
        }
        System.out.println(single);
    }
    //------------------------------------------------------------


    @Test
    public void totalCount() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer totalCount = sqlSession.selectOne("SingleMapper.totalCount");
        System.out.println(totalCount);
    }
    
    @Test
    public void insert() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = new Single();
        single.setAddress("hubie");
        single.setAge(10);
        single.setName("aaa");
        Integer affected = sqlSession.insert("SingleMapper.insert", single);
        System.out.println(affected);
        // 增、删、改记得要手动commit
        sqlSession.commit();
    }

    @Test
    public void update() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = new Single();
        single.setId((long) 3);
        single.setAddress("wu");
        single.setAge(100);
        single.setName("bbb");
        Integer affected = sqlSession.update("SingleMapper.update", single);
        System.out.println(affected);
        // 增、删、改记得要手动commit
        sqlSession.commit();
    }

    @Test
    public void deleteById() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Integer affected = sqlSession.delete("SingleMapper.deleteById", 3);
        System.out.println(affected);
        // 增、删、改记得要手动commit
        sqlSession.commit();
    }

    /**
     * 动态sql，set与if标签
     */
    @Test
    public void update2() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = new Single();
        single.setId((long) 4);
        single.setAge(10);
        single.setAddress("yyyyy");
        Integer affected = sqlSession.update("SingleMapper.update2", single);
        System.out.println(affected);
        // 增、删、改记得要手动commit
        sqlSession.commit();
    }

    /**
     * 动态sql，where、trim标签
     * @throws IOException
     */
    @Test
    public void getByWhere()  throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = new Single();
        single.setAge(10);
        single.setAddress("yyyyy");
        List<Single> list = sqlSession.selectList("SingleMapper.getByWhere", single);
        System.out.println(list);

    }

}
