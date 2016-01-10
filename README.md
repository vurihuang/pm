# pm
##The Porject Management's Work

###环境
- jdk 1.8.0.65
- mysql
- Tomcat 8.0

###导入包说明
- commons-dbcp-1.4.jar			连接连接池包
- commons-pool-1.3.jar			生成连接池包
- commons-io-1.4					IO包
- junit-4.7.jar		  			单元测试包
- mysql-connector-java-5.1.37-bin.jar	连接mysql数据库包
- c3p0-0.9.2-pre1.jar			jdbc连接池包
- mchange-commons-0.2.jar		c3p0连接池依赖包
- commons-dbutils-1.4.jar		JDBC操作封装包
- commons-beanutils-1.8.3.jar	提供Java反射和自省API的包装包
- commons-collections-3.2.1.jar 集合工具类包
- commons-logging-1.1.1.jar		应用程序日志记录包
- commons-lang-2.5.jar 		处理Java基本对象方法的工具类包
- itcast-tools-1.4.2.jar		jdbc小工具包
- jstl.jar							jsp的标签支持包
- standard.jar						jstl包的依赖包
- Rengine.jar 						R语言包
- Rserve.jar 						R语言服务包
- ezmorph-1.0.6.jar 			对象转换包，把对象转换成json
- json-lib-2.4-jdk15.jar 		json依赖包
- xom-1.1.jar 						json依赖包，用于json与xml转换
- iText-2.1.7.jar 				java操作PDA文件开发包
- iTextAsian.jar 					iText中文支持,亚洲编码
- iTextAdianCmaps.jar			PDF亚洲字体包

###Attention
- 数据库配置文件在src/c3p0-config.xml  
  *修改jdbcUrl，driverClass，user，password即可*。
- 相关参数与说明在src/readme.txt中

