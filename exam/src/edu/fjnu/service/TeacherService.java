package edu.fjnu.service;

import java.util.List;

import edu.fjnu.dao.impl.TeacherDaoImpl;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;

/**
 * 处理老师业务信息
 * @author vengeance
 *
 */
public class TeacherService {
	private TeacherDaoImpl teacherImpl = new TeacherDaoImpl();
	
	/**
	 * 判断老师登录信息是否正确
	 * @param teacher
	 * @return
	 */
	public boolean checkInfo(Teacher teacher){
		if(teacherImpl.checkInfo(teacher) != null){
			return true;
		}
		return false;
	}
	/**
	 * 获取老师基本信息
	 * @param teacher
	 * @return 老师基本信息
	 */
	public Teacher teacherInfo(Teacher teacher){
		return teacherImpl.teacherInfo(teacher);
	}
	
	/**
	 * 得到学生列表
	 * @param teacher
	 * @return 这个老师所教的学生
	 */
	public List<Student> getStuList(Teacher teacher){
		return teacherImpl.getStuList(teacher);
	}
}
