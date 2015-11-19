package com.fjnu.servlet;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fjnu.dao.impl.UserDaoImpl;
import com.fjnu.dao.inter.UserDao;
import com.fjnu.entity.User;
import com.fjnu.utils.ConnectionFactory;
import com.mysql.jdbc.Connection;

/**
 * 验证用户输入的信息与数据库的用户信息匹配
 * 
 * @author vengeance
 *
 */
public class CheckUser {
	private UserDao userDao = new UserDaoImpl();

	public boolean check(User user) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);

			ResultSet resultset = userDao.get(conn, user); // 验证用户信息

			while (resultset.next()) {
				return true;
			}
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e2){
				e2.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		return false;
	}
}
