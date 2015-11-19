package com.fjnu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fjnu.dao.inter.UserDao;
import com.fjnu.dto.User;
import com.mysql.jdbc.Connection;

/**
 * 实现实体类User的方法
 * 
 * @author vengeance
 *
 */
public class UserDaoImpl implements UserDao {

	/**
	 * 保存用户信息
	 */
	@Override
	public void save(Connection conn, User user) throws SQLException {
		String insertSql = "INSERT INTO t_user(name, password) VALUES(?, ?)";
		PreparedStatement ps = conn.prepareCall(insertSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		
		ps.execute();
	}

	/**
	 * 修改指定用户信息
	 */
	@Override
	public void update(Connection conn, Long id, User user) throws SQLException {
		String updateSql = "UPDATE t_user SET name=? ,password=? WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(updateSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());
		ps.setLong(3, id);

		ps.execute();
	}

	/**
	 * 删除指定用户
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		String deleteSql = "DELETE FROM t_user WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(deleteSql);
		ps.setLong(1, user.getId());

		ps.execute();
	}

	/**
	 * 验证用户信息
	 */
	@Override
	public ResultSet get(Connection conn, User user) throws SQLException {
		String checkSql = "SELECT * FROM t_user WHERE name=? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(checkSql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPassword());

		return ps.executeQuery();
	}

}
