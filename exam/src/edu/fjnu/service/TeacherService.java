package edu.fjnu.service;

import edu.fjnu.dao.impl.TeacherDaoImpl;
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
}
