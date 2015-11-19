package com.fjnu.test.dao;

import com.fjnu.dao.impl.UserDaoImpl;
import com.fjnu.dao.inter.UserDao;
import com.fjnu.entity.User;
import com.fjnu.utils.ConnectionFactory;
import com.mysql.jdbc.Connection;

/**
 * 测试UserDao类是否能够正常执行
 * @author vengeance
 *
 */
public class UserDaoTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().getConnection();
			conn.setAutoCommit(false);
			
			UserDao userDao = new UserDaoImpl();
			User admin = new User();
			//测试插入
//			admin.setName("admin");
//			admin.setPassword("aa123");
//			userDao.save(conn, admin);
			//测试修改
//			admin.setName("admin2");
//			admin.setPassword("aa1234");
//			userDao.update(conn, 13L, admin);
			//测试删除
//			admin.setName("admin2");
//			admin.setId(13L);
//			userDao.delete(conn, admin);
			//测试验证
//			admin.setName("yasuo");
//			admin.setPassword("aa123");
//			userDao.get(conn, admin);
			//提交事务
			conn.commit();
		} catch (Exception e) {
			try {
				//事务回滚
				conn.rollback();
				System.out.println("===事务处理异常===");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("===事务处理完成===");
	}
}
