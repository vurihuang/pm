1.配置文件在src/c3p0-config.xml
  把src/data下的灵凡数据.sql里的数据添加到学立方的数据库中

2.老师可使用测试数据为1441，2005，2784（1441老师试卷分析模块没有任何年级，是数据问题，请注意）
  学生可使用测试数据为2560，2563，2564
  密码均为123 
  
3.数据库无法读取学立方数据问题，修改C3P0的配置文件(参见第一条)
  jdbc:mysql://localhost:3306/你的数据库名?characterEncoding=gb2312
  
4.
//		qr.query(sql, new ScalarHandler<Javabean>(Javabean.class));//从数据库中查询出来的结果是单行单列
//		qr.query(sql, new BeanHandler<Javabean>(Javabean.class));//单行多列
//		qr.query(sql, new BeanListHandler<Javabean>(Javabean.class));//多行多列
//		qr.query(sql, new MapHandler());//数据库使用多表关联，用Map，得到多表的单行多列
//		qr.query(sql, new MapListHandler());//数据库使用多表关联，用Map，得到多表的多行多列

//		用到Map的时候，就要再加个手动反射的步骤
//		Javabean1 jb1 = CommonUtils.toBean(map, Javabean1.class);
//		Javabean2 jb2 = CommonUtils.toBean(map, Javabean2.class);