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
