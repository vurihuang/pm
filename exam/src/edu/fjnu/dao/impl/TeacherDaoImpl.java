package edu.fjnu.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.dao.TeacherDao;
import edu.fjnu.domain.Teacher;

/**
 * 实现TeacherDao接口
 * 操作数据库的老师表
 * @author vengeance
 *
 */
public class TeacherDaoImpl implements TeacherDao{

	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 验证登陆页面输入的老师信息是否正确
	 */
	public Teacher checkInfo(Teacher teacher) {
		try {
			String sql = "select * from teacher where teacherID =? and tpassword=?";
			Object[] params = {teacher.getTeacherID(), teacher.getTpassword()};
			
			return qr.query(sql, new BeanHandler<Teacher>(Teacher.class), params);
		} catch (SQLException e) {
			System.out.println("查询老师表异常");
			throw new RuntimeException(e);
		}
	}
	
}
