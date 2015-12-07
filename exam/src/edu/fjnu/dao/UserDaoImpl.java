package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.User;

public class UserDaoImpl implements UserDao{
	private QueryRunner qr = new TxQueryRunner();//带事务的数据库操作方法对象
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user){
		try {
			String sql = "insert into t_user value(?,?)";
			Object[] params = {user.getUsername(), user.getPassword()};
			
			qr.update(sql, params);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public List<User> queryAll(){
		try {
			String sql = "select * from t_user";
			return qr.query(sql, new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
