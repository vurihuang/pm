package com.fjnu.test.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.entity.User;
import com.fjnu.utils.ConnectionDB;
import com.fjnu.utils.SqlTool;
import com.mysql.jdbc.Connection;

/**
 * 实现类UserDao的方法
 * 
 * @author vengeance
 *
 */
public class UserImpl implements UserInter {

	/*
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

	/*
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

	/*
	 * 删除指定用户
	 */
	@Override
	public void delete(Connection conn, User user) throws SQLException {
		String deleteSql = "DELETE FROM t_user WHERE id=?";
		PreparedStatement ps = conn.prepareStatement(deleteSql);
		ps.setLong(1, user.getId());

		ps.execute();
	}

	/*
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
	
	public boolean check(User user){
		SqlTool tool = new SqlTool();
		String sql = "select * from t_user where name=? and password =?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getName());
		params.add(user.getPassword());
		tool.setSql(sql);
		tool.setParams(params);
		
		try {
			ResultSet rs = tool.getInfo();
			
			while(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
