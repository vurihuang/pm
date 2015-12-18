package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Sscore;
import edu.fjnu.domain.Teacher;
import edu.fjnu.test.dao.Score;

/**
 * 处理成绩分析模块
 * @author vengeance
 *
 */
public class GradeDao {
	QueryRunner qr = new TxQueryRunner();
	
	/**
	 * 根据学科获得学生最高分走势
	 * @param scourse
	 * @return 最高分走势情况
	 */
	public List<Sscore> getMaxScoreList(Scourse scourse){
		String sql = "select max(score) as score,testid from sscore where courseid = ? group by testid";
		Object[] params = {scourse.getCourseID()};
		List<Sscore> maxList = null;
		try {
			maxList = qr.query(sql, new BeanListHandler<Sscore>(Sscore.class), params);
		} catch (SQLException e) {
			System.err.println("查询测试最高分异常");
			e.printStackTrace();
		}
		
		return maxList;
	}
	
	/**
	 * 根据学科获得学生最低分走势
	 * @param scourse
	 * @return 最低分走势情况
	 */
	public List<Sscore> getMinScoreList(Scourse scourse){
		String sql = "select min(score) as score,testid from sscore where courseid = ? group by testid";
		Object[] params = {scourse.getCourseID()};
		List<Sscore> minList = null;
		try {
			minList = qr.query(sql, new BeanListHandler<Sscore>(Sscore.class), params);
		} catch (SQLException e) {
			System.err.println("查询测试最高分异常");
			e.printStackTrace();
		}
		
		return minList;
	}
	
	/**
	 * 根据学科获得学生平均分走势
	 * @param scourse
	 * @return 平均分走势情况
	 */
	public List<Sscore> getAvgScoreList(Scourse scourse){
		String sql = "select avg(score) as score,testid from sscore where courseid = ? group by testid";
		Object[] params = {scourse.getCourseID()};
		List<Sscore> avgList = null;
		try {
			avgList = qr.query(sql, new BeanListHandler<Sscore>(Sscore.class), params);
		} catch (SQLException e) {
			System.err.println("查询测试最高分异常");
			e.printStackTrace();
		}
		
		return avgList;
	}
	
	/**
	 * 获取学生成绩分布情况
	 * @param teacher
	 * @return
	 */
	public List<List<Double>> getRange(Teacher teacher){
		return null;
	}
	
	/**
	 * 返回学生成绩及格率情况
	 * @param teacher
	 * @return
	 */
	public List<Score> getPassRate(Teacher teacher, String course){
		return null;
	}
	
	/**
	 * 返回学生成绩优秀率情况
	 * @param teacher
	 * @return
	 */
	public List<Score> getExcellRate(Teacher teacher, String course){
		return null;
	}
	
//	public List<Score> getChinesePR(Student student, Scourse scourse){
//		String sql = "select PR from student,scourse,sscore where student.studentID=sscore.studentID "
//				+ " and scourse.courseID=sscore.courseID "
//				+ " and subject = '?'"
//				+ " and student.studentID=?";
//		Object[] params = {scourse.getSubject(), student.getStudentID()};
//		List<Score> list = null;
//		try {
//			list = qr.query(sql, new BeanListHandler<Score>(Score.class), params);
//			System.out.println("sql" + list);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
}
