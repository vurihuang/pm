package edu.fjnu.test;

import org.junit.Test;

import edu.fjnu.dao.UserDaoImpl;

/**
 * 测试数据库连接
 * @author vengeance
 *
 */
public class TestJdbc {
	@Test
	public void testUserDao(){
		UserDaoImpl udi = new UserDaoImpl();
//		udi.query();//测试查询是否成功
		udi.update();//测试添加是否成功
	}
}
