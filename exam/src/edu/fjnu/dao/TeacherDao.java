package edu.fjnu.dao;

import edu.fjnu.domain.Teacher;

/**
 * 操作数据库的老师表teacher的接口
 * @author vengeance
 *
 */
public interface TeacherDao {
	Teacher checkInfo(Teacher teacher);
}
