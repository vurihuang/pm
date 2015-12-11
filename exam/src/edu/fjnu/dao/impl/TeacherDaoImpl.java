package edu.fjnu.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.dao.TeacherDao;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Stcourse;
import edu.fjnu.domain.Student;
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
			
			return qr.query(sql, new BeanHandler<Teacher>(Teacher.class), params);//验证信息
		} catch (SQLException e) {
			System.err.println("验证老师表信息异常");
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据老师登录的ID查询老师的基本信息，并返回给service
	 * @param teacher
	 * @return 老师信息
	 */
	public Teacher teacherInfo(Teacher teacher){
		try {
			String sql = "SELECT distinct tname, classyear, tclass,course ,scourse.courseid "
					+ "FROM teacher,scourse,stcourse where  "
					+ "teacher.teacherID=stcourse.teacherID AND "
					+ "stcourse.courseID=scourse.courseID AND  "
					+ "teacher.teacherID=?";
			Object[] params = {teacher.getTeacherID()};
			String teacherID = teacher.getTeacherID();
			
//			return qr.query(sql, new BeanHandler<Teacher>(Teacher.class), params);//执行查询方法
			Scourse scourse = new Scourse();
			Stcourse stcourse = new Stcourse();
			Map map = qr.query(sql, new MapHandler(), params);
			teacher = CommonUtils.toBean(map, Teacher.class);
			scourse = CommonUtils.toBean(map, Scourse.class);
			stcourse = CommonUtils.toBean(map, Stcourse.class);
			teacher.setScourse(scourse);
			teacher.setStcourse(stcourse);
			teacher.setTeacherID(teacherID);
			
			return teacher;
		} catch (SQLException e) {
			System.err.println("查询老师表信息异常");
			throw new RuntimeException();
		}
	}
	
	/**
	 * 查询老师所教的学生列表
	 * @param teacher
	 * @return
	 */
	public List<Student> getStuList(Teacher teacher){
		String sql = "select distinct sname,student.studentid from student ,teacher,stcourse where student.studentID=stcourse.studentID " 
				+ "and teacher.teacherID=stcourse.teacherID and teacher.teacherID= ?";
		Object[] params = {teacher.getTeacherID()};
		List<Student> stuList = null;
		
		try {
			stuList = qr.query(sql, new BeanListHandler<Student>(Student.class), params);//得到学生列表
		} catch (SQLException e) {
			System.err.println("查询学生列表异常");
			e.printStackTrace();
		}
		
		return stuList;
	}
	
}
