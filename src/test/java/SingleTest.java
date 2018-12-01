import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.miaxis.entity.Single;
import com.miaxis.mapper.SingleMapper;
import com.miaxis.util.MybatisSqlSessionUtil;

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

    /**
     * 使用注解而不是xml文件的方式
     * 注意，已经在mybatis-config.xml文件中引入了SingleMapper
     * @throws IOException
     */
    @Test
    public void annotation() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);
        System.out.println(singleMapper.totalCount());
    }


    /**
     * 参数：单个基本类型，单个返回值
     * @throws IOException
     */
    @Test
    public void selectById() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);
        System.out.println(singleMapper.getById((long) 1));
    }

    /**
     * 参数：多基本类型，单个返回值
     * @throws IOException
     */
    @Test
    public void getByNameAge() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);
        System.out.println(singleMapper.getByNameAge("aaa", 10));
    }

    /**
     * 参数：多基本类型，多个返回值
     * @throws IOException
     */
    @Test
    public void getByName() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);
        System.out.println(singleMapper.getByName("aaa"));
    }

    @Test
    public void getByObj() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Single single = new Single();
        single.setId((long) 1);

        // 获取mapper接口
        SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);
        System.out.println(singleMapper.getByObj(single));
    }

    /**
     * 最简单的分页使用1：// 只需要在分页方法前调用PageHelper.startPage设置page与pageSize即可
     * @throws IOException
     */
    @Test
    public void usePage1() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        final SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);

        int page = 1;
        int pageSize = 2;

        // 只需要在分页方法前调用PageHelper.startPage设置page与pageSize即可
        PageHelper.startPage(page, pageSize);

        // 1. 这里的list真正类型为Page，因为被拦截了；2. 如果没有上句，则这里会查出所有的数据
        List<Single> list = singleMapper.getByName("aaa");
        for (Single single : list) {
            System.out.println(single);
        }

        // 用这种方式没法获取到page，pageSize，pages,total等数据，不建议用；
    }

    /**
     * 最简单的分页使用2，使用Page<T>对象
     * @throws IOException
     */
    @Test
    public void usePage2() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        final SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);

        int page = 1;
        int pageSize = 3;
        // 注意，这里是doSelectPage，返回的是Page<Single>，重点：Page继承自ArrayList
        Page<Single> list = PageHelper.startPage(page, pageSize).doSelectPage(new ISelect() {
            public void doSelect() {
                singleMapper.getByName("aaa");
            }
        });
        // 使用lambda表达式
        /*Page<Single> list = PageHelper.startPage(page, pageSize).doSelectPage(() -> singleMapper.getByName("aaa"););*/

        // 重点：Page继承自ArrayList，Page就是一个ArrayList,所以可通过遍历list来获取查询出的分页数据
        for (Single single : list) {
            System.out.println(single);
        }

        // 可以用Page中获取到pageNum(page)，pageSize,total,pages(有多少页)等等
        System.out.println(list.getPageNum());
        System.out.println(list.getPageSize());
        System.out.println(list.getTotal());
        System.out.println(list.getPages());
    }

    /**
     * 最简单的分页使用2，使用PageInfo<T>对象
     * @throws IOException
     */
    @Test
    public void usePage3() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        final SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);

        int page = 1;
        int pageSize = 4;

        PageHelper.startPage(page, pageSize);
        // 注意：其实此时list是Page类型
        List<Single> list = singleMapper.getByName("aaa");
        // 包装成PageInfo对象，作用，可以获取page,pageSize,total,pages等参数
        PageInfo<Single> pageInfo = new PageInfo<Single>(list);
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());

        // 因为list实际上是Page类型(继承自ArrayList)，用遍历
        for (Single single : list) {
            System.out.println(single);
        }
    }

    /**
     * 最简单的分页使用2，使用PageInfo<T>对象
     * @throws IOException
     */
    @Test
    public void usePage4() throws IOException {
        SqlSessionFactory sqlSessionFactory = MybatisSqlSessionUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper接口
        final SingleMapper singleMapper = sqlSession.getMapper(SingleMapper.class);

        int page = 1;
        int pageSize = 3;

        PageHelper.startPage(page, pageSize);
        // 注意，这里是doSelectPageInfo，返回的是PageInfo<Single>，重点：PageInfo有个list字段存放了分页的数据
        PageInfo<Single> pageInfo = PageHelper.startPage(page, pageSize).doSelectPageInfo(new ISelect() {
            public void doSelect() {
                singleMapper.getByName("aaa");
            }
        });
        System.out.println(pageInfo.getPageNum());
        System.out.println(pageInfo.getPageSize());
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());

        // pageInfo.getList()返回的list真正类型为Page
        for (Single single : pageInfo.getList()) {
            System.out.println(single);
        }
    }




}
