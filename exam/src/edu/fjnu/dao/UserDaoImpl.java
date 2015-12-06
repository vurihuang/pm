package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import edu.fjnu.domain.User;
import edu.fjnu.utils.JdbcUtils;

/**
 * User实体类的修改和查询
 * @author vengeance
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void update() {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into t_user values(?,?)";
		Object[] params = {"test","test"};
		
		try {
			qr.update(sql, params);//执行update操作
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void query() {
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from t_user";
		List<User> userList = null;
		try {
			userList = qr.query(sql, new BeanListHandler<User>(User.class));//返回数据库结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(userList);
	}

}
