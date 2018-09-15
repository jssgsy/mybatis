package com.miaxis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * mapper接口就是一个普普通通的接口而已，不用附加任何条件
 */
public interface SingleMapper {

    @Select("select count(id) from single")
    Integer totalCount();
}
