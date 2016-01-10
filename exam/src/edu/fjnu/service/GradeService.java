package edu.fjnu.service;

import java.util.List;

import edu.fjnu.dao.GradeDao;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Sscore;

/**
 * 获取学生成绩相关数据
 * @author vengeance
 *
 */
public class GradeService {
	GradeDao gradeDao = new GradeDao();//操作数据库对象
	
	/**
	 * @param scourse
	 * @return 返回平均分走势
	 */
	public List<Sscore> getAvgScoreList(Scourse scourse){
		return gradeDao.getAvgScoreList(scourse);
	}
	
	/**
	 * @param scourse
	 * @return 返回最高分走势
	 */
	public List<Sscore> getMaxScoreList(Scourse scourse){
		return gradeDao.getMaxScoreList(scourse);
	}
	
	/**
	 * 
	 * @param scourse
	 * @return 返回最低分走势
	 */
	public List<Sscore> getMinScoreList(Scourse scourse){
		return gradeDao.getMinScoreList(scourse);
	}
}
