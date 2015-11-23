package com.fjnu.test.dao;

import java.sql.SQLException;

import com.fjnu.dao.impl.UserImpl;
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
//		Connection conn = null;
//		try {
//			conn = ConnectionFactory.getInstance().getConnection();
//			conn.setAutoCommit(false);
			
//			UserInter userDao = new UserImpl();
//			User admin = new User();
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
//			User checkUser = new User();
//			checkUser.setName("yasuo");
//			checkUser.setPassword("aa123");
//			UserImpl ui = new UserImpl();
//			boolean isRight = ui.check(checkUser);
//			
//			if(isRight){
//				System.out.println("登录成功");
//			}else{
//				System.out.println("登录失败");
//			}
//			conn.commit();
//		} catch (Exception e) {
//			try {
//				//事务回滚
//				conn.rollback();
//				System.out.println("===事务处理异常===");
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
		
//		System.out.println("===事务处理完成===");
		
		UserImpl ud = new UserImpl();
		User checkUser = new User();
		checkUser.setName("admin");
		checkUser.setPassword("admin");
		try {
			boolean isRight = ud.checkInfo(checkUser);
			if(isRight){
				System.out.println("登录成功");
			}else{
				System.out.println("登录失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
