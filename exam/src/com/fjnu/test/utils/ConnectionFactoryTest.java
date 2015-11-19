package com.fjnu.test.utils;

import java.sql.SQLException;

import com.fjnu.utils.ConnectionFactory;
import com.mysql.jdbc.Connection;

/**
 * 测试抽象工厂ConnectionFactory的数据库连接是否成功
 * 连接成功返回true
 * 连接失败返回false
 * @author vengeance
 *
 */
public class ConnectionFactoryTest {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance();
		Connection conn = factory.getConnection();
		
		System.out.println(conn.getAutoCommit());
	}
}
