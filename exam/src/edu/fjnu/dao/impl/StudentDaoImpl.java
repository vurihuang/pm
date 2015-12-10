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
	private QueryRunner qr = new TxQueryRunner();//执行数据库操作并存储返回的结果
	
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
			
			return qr.query(sql, new BeanHandler<Student>(Student.class), params);//验证信息
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据学生登录的ID查询学生的基本信息，并返回给service
	 * @param student
	 * @return 学生信息
	 */
	public Student studentInfo(Student student) {
		try {
			String sql = "select sname, sclass, ssex from student where studentID=?";
			Object[] params = {student.getStudentID()};
			
			return qr.query(sql, new BeanHandler<Student>(Student.class), params);//执行查询方法
		} catch (Exception e) {
			System.err.println("查询学生表信息异常");
			throw new RuntimeException();
		}	
	}
}
