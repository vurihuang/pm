package com.fjnu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.fjnu.dto.User;
import com.mysql.jdbc.Connection;

/**
 * data access object(数据访问对象模型) DAO将非对象数据（如关系数据库中的数据）以对象的方式操纵。
 * 
 * @author vengeance
 *
 */
public interface UserDao {

	// 验证用户信息
	public ResultSet get(Connection conn, User user) throws SQLException;

	// 保存用户信息
	public void save(Connection conn, User user) throws SQLException;

	// 更新指定用户信息
	public void update(Connection conn, Long id, User user) throws SQLException;

	// 删除指定用户
	public void delete(Connection conn, User user) throws SQLException;

}
