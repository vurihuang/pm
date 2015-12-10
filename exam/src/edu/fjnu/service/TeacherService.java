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
	
	public Teacher teacherInfo(Teacher teacher){
		return teacherImpl.teacherInfo(teacher);
	}
}
