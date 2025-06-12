package com.miaxis.mapper;

import com.miaxis.entity.Single;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * mapper接口就是一个普普通通的接口而已，不用附加任何条件
 */
public interface SingleMapper {

    // mapper文件中已经有此id了，不能重复
    // @Select("select count(id) from single")
    Integer totalCount();

    /**
     * 基本类型，单个参数
     * @param id 注意，这里不用@Param
     * @return 会自动映射成返回值类型Single
     */
    // @Select("select * from single where id = #{id}")
    Single getById(Long id);


    /**
     * 基本类型，多个参数
     * 注意当有多个参数时，必须使用@Param注解
     * 关于@Param（始终使用@Param指定参数）
     * 如果你的映射方法的形参有多个，这个注解使用在映射方法的参数上就能为它们取自定义名字。若不给出自定义名字，多参数（不包括 RowBounds 参数）则先以 "param" 作前缀，再加上它们的参数位置作为参数别名。例如 #{param1}, #{param2}，这个是默认值。如果注解是 @Param("person")，那么参数就会被命名为 #{person}
     * 由上可知，等价于
     *  @Select("select * from single where name = #{0} and age = #{1}")
     *  @Select("select * from single where name = #{param1} and age = #{param2}")
     * 由此可知，一个是从0(#{0},#{1})开始，一个是从1(#{param1},#{param2})开始，始终使用@Param指定参数
     * @param name
     * @param age
     * @return
     */
    @Select("select * from single where name = #{name} and age = #{age}")
    Single getByNameAge(@Param("name") String name, @Param("age") Integer age);


    @Select("select * from single where name = #{name}")
    List<Single> getByName(@Param("name") String name);

    /**
     * 方法参数为对象类型
     * 与如下等价:
     *  @Select("select * from single where id = #{single.id}")
     *  Single getByObj(@Param("single") Single single);
     * @param single
     * @return
     */
    @Select("select * from single where id = #{id}")
    Single getByObj(Single single);

    /**
     * SingleMapper.xml文件中已经定义了totalCount，所以这里不能再定义
     * @param single
     * @return
     */
    /*@Select("select count(*) from single")
    Single totalCount(Single single);*/
}
