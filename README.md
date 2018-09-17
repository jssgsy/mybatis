# mybatis
这是最原生的mybatis小示例，不包含任何其他框架与插件。

# 备忘知识点
1. 涉及到事务操作如增、删、改等时一定要手动提交SqlSession；
2. 实体类是实体类，配置文件也只需要配置crud语句，要操作的表都是在sql语句中指定，如**select * from author**
3. 并不需要配置实体类和数据库中表的对应关系(见第2点)；
4. **表需要先存在**,表之间的关系也需要在数据库中已经建立好（见第2点）；
5. 和数据库打交道的是`SqlSession`实例，SqlSession可从SqlSessionFactory中得到;
6. static语句块在制作util包中可能很有用；


# 使用xml方式与接口注解方式
## 使用xml方式
* 引入相应xml文件；
* 写好相应的statement并在程序中使用即可(参考SingleMapper.xml文件)；

## 使用接口注解方式
与使用xml方式一样
* 引入相应的mapper接口；
* 写好相应的statement并在程序中使用即可(参考SingleMapper接口)；

# 功能说明
* mybatis的insert,update,delete方法返回值的意义；

# maven中使用MBG插件
很简单,只需要引入插件依赖以及配置generatorConfig.xml即可。

## 在pom.xml中引入插件
```xml
<!--mybatis MBG-->
<plugin>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.3.0</version>
	<configuration>
		<!--这样每次运行此插件时都会覆盖掉之前生成的java类-->
		<overwrite>true</overwrite>
	</configuration>
</plugin>
```

## 配置generatorConfig.xml
generatorConfig.xml是MBG的核心配置文件,放在classpath下。

## maven运行方法

**mvn mybatis-generator:generate**