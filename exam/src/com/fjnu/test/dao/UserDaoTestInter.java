package com.fjnu.test.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.dao.impl.UserDao;
import com.fjnu.entity.User;
import com.fjnu.utils.ConnectionDB;
import com.fjnu.utils.SqlTool;

/**
 * 测试SqlTool、ConnectionDB、ReadProp类是否正常运作
 * @author vengeance
 *
 */
public class UserDaoTestInter {
	public static void main(String[] args) throws SQLException {
		
		SqlTool tool = new SqlTool();
//		List<String> username = new ArrayList<String>();
//		List<String> password = new ArrayList<String>();
//		String sql = "select * from t_user";
//		tool.setSql(sql);
//		ResultSet rs = tool.executeQuery();
//		
//		while(rs.next()){
//			User user = new User();
//			user.setName(rs.getString(2));
//			user.setPassword(rs.getString(3));
//			username.add(user.getName());
//			password.add(user.getPassword());
//		}
//		for(int i=0; i<username.size(); i++){
//			System.out.println(username.get(i));
//		}
//		for(int i=0; i<password.size(); i++){
//			System.out.println(password.get(i));
//		}
		
//		String sql = "select * from t_user where name=?,password=?";
		User user = new User();
		user.setName("admin");
		user.setPassword("123");
//		tool.setSql(sql);
//		List<Object> li = new ArrayList<Object>();
//		li.add(user);
//		tool.setParams(li);
//		ResultSet rs  = tool.checkInfo();
		UserDao ud = new UserDao();
		boolean isRight = ud.checkInfo(user);
		if(isRight){
			System.out.println("登录成功");
		}else{
			System.out.println("登录失败");
		}
	}	
	
	
}
