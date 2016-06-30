# mybatis
这是最原生的mybatis小示例，不包含任何其他框架与插件。

# 备忘知识点
1. 涉及到事务操作如增、删、改等时一定要手动提交SqlSession；
2. 实体类是实体类，配置文件也只需要配置crud语句，要操作的表都是在sql语句中指定，如**select * from author**
3. 并不需要配置实体类和数据库中表的对应关系(见第2点)；
4. **表需要先存在**,表之间的关系也需要在数据库中已经建立好（见第2点）；
5. 和数据库打交道的是`SqlSession`实例，SqlSession可从SqlSessionFactory中得到
