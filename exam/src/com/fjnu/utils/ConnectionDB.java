package com.fjnu.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接数据库
 * @author vengeance
 *
 */
public class ConnectionDB {
	/*
	 * 数据库连接对象
	 */
	private Connection conn;
	private static String driver;
	private static String dburl;
	private static String user;
	private static String password;
	public static final ConnectionDB factory = new ConnectionDB();
	
	private ConnectionDB(){
	}
	
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
	
	
	/*
	 * 获取数据库连接
	 */
	public Connection getConnection(){
		try {
			//加载数据库驱动
			Class.forName(driver);
			conn = DriverManager.getConnection(dburl, user, password);
		} 	catch (ClassNotFoundException e){
			System.out.println("===未找到mysql-driver驱动!===");
		}
			catch (SQLException e) {
			System.out.println("===数据库连接异常!===");
		}
		return conn;
	}
	
	public static ConnectionDB getInstance(){
		return factory;
	}
	
	/*
	 * 关闭数据库连接
	 */
	public static void closeAll(PreparedStatement ps, ResultSet rs, Connection conn){
		if(ps != null){
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
