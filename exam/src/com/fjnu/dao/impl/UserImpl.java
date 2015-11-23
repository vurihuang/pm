package com.fjnu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.entity.User;
import com.fjnu.utils.SqlTool;
/**
 * 对User类的操作，表t_user
 * 对t_user表的增删改查，以及账号密码数据库核对
 * @author vengeance
 *
 */
public class UserImpl extends SqlTool{
	public boolean checkInfo(User user) throws SQLException{
		String sql = "select * from t_user where name=? and password = ?";
		List<Object> params = new ArrayList<Object>();
		
		String username = user.getName();
		String password = user.getPassword();
		params.add(username);
		params.add(password);
		
		setSql(sql);
		setParams(params);
		
		ResultSet rs = executeQuery();
		
		while(rs.next()){
			return true;
		}
		return false;
	}
}
