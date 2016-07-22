package com.miaxis.entity;

/**
 * Univ
 * 16/7/22 09:11
 */

/**
 * 演示mybatis如何映射具有继承关系的实体类
 */
public class BlogChild extends Blog {

    private String auhtorName; //与Blog关联的Author的名字,author的id存放在Blog类中

    public String getAuhtorName() {
        return auhtorName;
    }

    public void setAuhtorName(String auhtorName) {
        this.auhtorName = auhtorName;
    }
}
