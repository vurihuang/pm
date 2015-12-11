package edu.fjnu.service;

import java.util.List;

import edu.fjnu.dao.impl.GradeDaoImpl;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Sscore;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;

/**
 * 获取学生成绩相关数据
 * @author vengeance
 *
 */
public class GradeService {
	GradeDaoImpl gradeImpl = new GradeDaoImpl();//操作数据库对象
	
	/**
	 * @param scourse
	 * @return 返回平均分走势
	 */
	public List<Sscore> getAvgScoreList(Scourse scourse){
		return gradeImpl.getAvgScoreList(scourse);
	}
	
	/**
	 * @param scourse
	 * @return 返回最高分走势
	 */
	public List<Sscore> getMaxScoreList(Scourse scourse){
		return gradeImpl.getMaxScoreList(scourse);
	}
	
	/**
	 * 
	 * @param scourse
	 * @return 返回最低分走势
	 */
	public List<Sscore> getMinScoreList(Scourse scourse){
		return gradeImpl.getMinScoreList(scourse);
	}
}
