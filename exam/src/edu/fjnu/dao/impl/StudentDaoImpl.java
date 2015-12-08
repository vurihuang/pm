package edu.fjnu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.dao.StudentDao;
import edu.fjnu.domain.Student;

/**
 * 实现StudentDao接口
 * 操作数据库的学生表
 * @author vengeance
 *
 */
public class StudentDaoImpl implements StudentDao{
	private QueryRunner qr = new TxQueryRunner();
	
	public List<Student> query(Student student){
		try {
			String sql = "select * from student where sname=?";
			Object[] params = {student.getSname()};
			
			return qr.query(sql, new BeanListHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 验证登陆页面输入的学生信息是否正确
	 */
	public Student checkInfo(Student student){
		try {
			String sql = "select * from student where studentID=? and spassword =?";
			Object[] params = {student.getStudentID(), student.getSpassword()};
			
			return qr.query(sql, new BeanHandler<Student>(Student.class), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
