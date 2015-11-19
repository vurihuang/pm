package com.fjnu.jdbc;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.jdbc.Connection;

/**
 * 编写数据库连接的连接抽象工厂
 * 需要导入mysql-connector-java驱动到lib文件夹下
 * 同时配置java-build-path-libraries
 * @author vengeance
 *
 */
public class ConnectionFactory {
		/**
		 * 定义字段保存mysql的驱动、数据库主机地址、用户名、密码
		 */
		private static String driver;
		private static String dburl;
		private static String user;
		private static String password;
		private static Connection conn;
		private static final ConnectionFactory factory = new ConnectionFactory();
		
		static{
			//用来保存Properties文件中的键值对
			Properties prop = new Properties();
			
			try {
				//获取当前类的类加载器，将文件中的内容读取到流中
				InputStream in = ConnectionFactory.class.getClassLoader()
						.getResourceAsStream("dbconfig.properties");
				//获取流中的键值对
				prop.load(in);
			} catch (Exception e) {
				System.out.println("===读取配置文件出错!===");
			}
			
			//初始化字段
			driver = prop.getProperty("driver");
			dburl = prop.getProperty("dburl");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
		}
		
		private ConnectionFactory(){
		}
		
		/**
		 * 返回通过抽象工厂产生得到的对象
		 * 使用单例模式，保障程序运行期间，只有一个ConnectionFactory实例
		 * @return
		 */
		public static ConnectionFactory getInstance(){
			return factory;
		}
		
		/**
		 * 数据库的连接方法
		 * @return
		 */
		public Connection getConnection(){
			try {
				//加载数据库驱动
				Class.forName(driver);
				conn = (Connection) DriverManager.getConnection(dburl, user, password);
			} 	catch (ClassNotFoundException e){
				System.out.println("===未找到mysql-driver驱动!===");
			}
				catch (SQLException e) {
				System.out.println("===数据库连接异常!===");
			}
			return conn;
		}
}
