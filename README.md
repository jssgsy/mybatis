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

## MBG默认生成文件
MBG默认会生成四个文件
* Xxx.java，即和数据库表对应的JavaBean；
* XxxMapper.java，即Xxx对应的Dao层的接口；（Mapper后缀可配置）
* XxxExample.java，供XxxMapper.java使用的查询对象；（Example后缀可配置）
* XxxMapper.xml文件，即对应的xml配置文件；

# mybatis中使用pagehelper分页
[github地址](https://github.com/pagehelper/Mybatis-PageHelper)
## 使用前步骤
maven依赖
```
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.1.2</version>
</dependency>
```

mybatis的配置文件(mybatis-config.xml)中配置拦截器
```
<!--注意，plugins标签的位置顺序很有讲究，必须在environments标签之前-->
<plugins>
    <!--引入mybatis的分页拦截器-->
    <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
</plugins>
```

## 使用
* Page继承自ArrayList，所以Page就是一个ArrayList，分页的结果集就在这里面；
* 查询方法必须紧跟在PageHelper.startPage(page, pageSize)之后，否则可能不安全；
如下是不安全的：
```
PageHelper.startPage(1, 10);
List<Country> list;
if(param1 != null){
    list = countryMapper.selectIf(param1);
} else {
    list = new ArrayList<Country>();
}
```
> 这种情况下由于 param1 存在 null 的情况，就会导致 PageHelper 生产了一个分页参数，但是没有被消费，这个参数就会一直保留在这个线程上。当这个线程再次被使用时，就可能导致不该分页的方法去消费这个分页参数，这就产生了莫名其妙的分页。


如下是安全的：
```
List<Country> list;
if(param1 != null){
    PageHelper.startPage(1, 10);
    list = countryMapper.selectIf(param1);
} else {
    list = new ArrayList<Country>();
}
```
* 使用ISelect的方式是安全的，参见SingleTest::usePage4测试用例，推荐使用ISelect；