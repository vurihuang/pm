package edu.fjnu.service;

import edu.fjnu.dao.impl.StudentDaoImpl;
import edu.fjnu.domain.Student;

/**
 * 处理学生业务信息
 * @author vengeance
 *
 */
public class StudentService {
	private StudentDaoImpl studentImpl = new StudentDaoImpl(); 
	
	/**
	 * 判断学生登录信息是否正确
	 * @param student
	 * @return
	 */
	public boolean checkInfo(Student student){
		if(studentImpl.checkInfo(student) != null){
			return true;
		}
		return false;
	}
	
	/**
	 * 得到学生基本信息
	 * @param student
	 * @return 学生基本信息
	 */
	public Student studentInfo(Student student) {
		return studentImpl.studentInfo(student);
	}
}
