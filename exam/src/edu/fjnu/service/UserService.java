package edu.fjnu.service;

import java.util.List;

import edu.fjnu.dao.impl.UserDaoImpl;
import edu.fjnu.domain.User;

/**
 * 业务层，对数据的操作
 * @author vengeance
 *
 */
public class UserService {
	private UserDaoImpl userDao = new UserDaoImpl();//数据库操作对象
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user){
		userDao.add(user);
	}
	
	public List<User> queryAll(){
		return userDao.queryAll();
	}
}
