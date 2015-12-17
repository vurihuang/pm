1.数据库名为pmtest，配置文件在src/c3p0-config.xml
  把src/data下的创建项目数据.sql里的数据添加到学立方的数据库中

2.老师可使用测试数据为1441，2005，2784
  学生可使用测试数据为2560，2563，2564
  密码均为123 
  
3.数据库无法读取学立方数据问题，修改C3P0的配置文件(参见第一条)
  jdbc:mysql://localhost:3306/pmtest?characterEncoding=gb2312