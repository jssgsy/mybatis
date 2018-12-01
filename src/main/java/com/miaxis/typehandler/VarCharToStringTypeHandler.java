package com.miaxis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author univ
 * @datetime 2018/12/1 3:48 PM
 * @description 重写varchar ---> String的类型处理器
 */
/*
1. 定义或者覆盖已有的TypeHandler，只需要继承自BaseTypeHandler<E>即可(或者实现org.apache.ibatis.type.TypeHandler接口)；
2. @MappedJdbcTypes(JdbcType.VARCHAR)表示要映射的数据库的varchar类型；
3. BaseTypeHandler<String>表示要映射的是java中String类型；
4. 综上2和3，这里的VarCharToStringTypeHandler就是varchar和String互转的TypeHandler;
5. 逻辑很简单，加上基本的jdbc知识(PreparedStatement,ResultSet)就比较明了了。
 */

/*
1. 这里比较绕，如果没有@MappedJdbcTypes和@MappedTypes，则resultType与resultMap中都能起作用；
2. 如果使用了@MappedJdbcTypes，则使用resultType时类型转换器不起作用；且在resultMap需要对相应属性显示指定typeHandler，否则不生效；
3. 经验：返回结果集时均使用resultMap不要使用resultType;
 */

// @MappedJdbcTypes(JdbcType.VARCHAR)
// @MappedTypes({String.class})
public class VarCharToStringTypeHandler extends BaseTypeHandler<String>{

    /**
     * String ---> varchar的逻辑
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("VarCharToStringTypeHandler::getNullableResult(ResultSet rs, String columnName)方法被调用了");
        ps.setString(i, parameter);
        // ps.setString(i, parameter + "_typeHandlerPostfix");
    }

    /**
     * varchar ---> String的逻辑，假设有n行数据返回，则这里会被调用n次
     * @param rs 某一行对应的结果集
     * @param columnName 对应的表中的列
     * @return 要映射成的Java中String类型对应的值
     * @throws SQLException
     */
    public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("VarCharToStringTypeHandler::getNullableResult(ResultSet rs, String columnName)方法被调用了");
        return rs.getString(columnName);
        // return rs.getString(columnName + "prefix");
    }

    /**
     * varchar ---> String的逻辑
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("VarCharToStringTypeHandler::getNullableResult(ResultSet rs, int columnIndex)方法被调用了");
        return rs.getString(columnIndex);
        // return rs.getString(columnIndex) + "prefix";
    }

    /**
     * varchar ---> String的逻辑
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("VarCharToStringTypeHandler::getNullableResult(CallableStatement cs, int columnIndex)方法被调用了");
        return cs.getString(columnIndex);
        // return rs.getString(columnIndex) + "prefix";
    }
}
