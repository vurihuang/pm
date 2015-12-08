package edu.fjnu.dao;

import java.util.List;

import edu.fjnu.domain.Student;

/**
 * 操作数据库的学生student表的接口
 * @author vengeance
 *
 */
public interface StudentDao {
	/**
	 * 查询学生信息
	 * @param stu
	 */
	List<Student>query(Student stu);
	
	/**
	 * 验证学生登录信息
	 * @param stu
	 */
	Student checkInfo(Student stu);
}
