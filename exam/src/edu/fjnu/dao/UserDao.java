package edu.fjnu.dao;

import edu.fjnu.domain.User;

/**
 * 持久层，对数据库进行操作
 * @author vengeance
 *
 */
public interface UserDao {
	public static void update(User user){};
	public static void query(User user){};
}
