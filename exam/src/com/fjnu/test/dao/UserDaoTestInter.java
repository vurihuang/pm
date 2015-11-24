package com.fjnu.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.impl.RelationToolImpl;

/**
 * 测试SqlTool、ConnectionDB、ReadProp类是否正常运作
 * @author vengeance
 *
 */
public class UserDaoTestInter {
	public static void main(String[] args) throws SQLException {
		RelationToolImpl rt = new RelationToolImpl();
		String[][] array = {
				{"ID","A","B","C","D","E"},
				{"1","A","C","D"},
				{"2","B","C","E"},
				{"3","A","B","C","E"},
				{"4","B","E"}
		};
//		2015/11/24 20:00 测试知识点包装是否能正常返回一个List
		rt.relationTool(array);
		List<List<String>> list = rt.getList();
		System.out.println(list);
		
		
//		RelationTool.getRecord(array);
//		rt.relationTool(array);
//		List<List<String>> tempList = new ArrayList<List<String>>();
//		for(int i=0; i<array.length; i++){
//			List<String> temp = new ArrayList<String>();
//			for(int j=0; j<array[i].length; j++){
//				temp.add(array[i][j]);
//			}
//			tempList.add(temp);
//		}
		
//		for(int i=0; i<tempList.size(); i++){
//			for(int j=0; j<tempList.get(i).size(); j++){
//				System.out.print(tempList.get(i).get(j));
//			}
//			System.out.println();
//		}
//		List<String> list = new ArrayList<String>();
//		List<List<String>> list = new ArrayList<List<String>>();
//		List<String> temp = new ArrayList<String>();
//		temp.add("aaa");
//		temp.add("bbb");
//		for(int i=0; i<temp.size(); i++){
//			System.out.println(temp.get(i));
//			List<String> tmp = new ArrayList<String>();
//			tmp.add(temp.get(i));
//			list.add(tmp);
//		}
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
//		SqlTool tool = new SqlTool();
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
//		User user = new User();
//		user.setName("admin");
//		user.setPassword("123");
//		tool.setSql(sql);
//		List<Object> li = new ArrayList<Object>();
//		li.add(user);
//		tool.setParams(li);
//		ResultSet rs  = tool.checkInfo();
//		UserDao ud = new UserDao();
//		boolean isRight = ud.checkInfo(user);
//		if(isRight){
//			System.out.println("登录成功");
//		}else{
//			System.out.println("登录失败");
//		}
	}	
	
	
}
