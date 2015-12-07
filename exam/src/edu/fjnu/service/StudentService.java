package edu.fjnu.service;

import edu.fjnu.dao.impl.StudentDaoImpl;
import edu.fjnu.domain.Student;

/**
 * 对得到的学生数据进行操作
 * @author vengeance
 *
 */
public class StudentService {
	private StudentDaoImpl studentImpl = new StudentDaoImpl(); 
	
	public void checkInfo(Student student){
		System.out.println(studentImpl.checkInfo(student).getClass().getName());
	}
	
	
}
