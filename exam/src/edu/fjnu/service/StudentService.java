package edu.fjnu.service;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import edu.fjnu.dao.SscoreDao;
import edu.fjnu.dao.StudentDao;
import edu.fjnu.domain.Sscore;
import edu.fjnu.domain.Student;
import edu.fjnu.test.dao.Score;

/**
 * 处理学生业务信息
 * @author vengeance
 *
 */
public class StudentService {
	private StudentDao studentDao = new StudentDao(); 
	private SscoreDao sscoreDao = new SscoreDao();
	/**
	 * 判断学生登录信息是否正确
	 * @param student
	 * @return
	 */
	public boolean checkInfo(Student student){
		if(studentDao.checkInfo(student) != null){
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
		return studentDao.studentInfo(student);
	}
/**
 * courseID查找该课程下历次学生最高分
 */
	public List<Sscore> maxScores(String courseID) {
		return sscoreDao.maxScores(courseID);
	}
	
    /**
     * courseID查找该课程下历次学生最低分
     */
	public List<Sscore> minScores(String courseID) {
		return sscoreDao.minScores(courseID);
	}
	/**
	 * courseID查找该课程下历次学生平均分
	 */
	public List<Sscore> avgScores(String courseID) {
		return sscoreDao.avgScores(courseID);
	}
	/**
	 * courseID、studentID查找该课程该学生历次分数
	 */
	public List<Sscore> stuScores(String courseID, String studentID) {
		return sscoreDao.stuScores(courseID, studentID);
	}
	/**
	 * studentID 、testID查找该学生每一次考试三门course的分数
	 */
//	public List<Sscore>stuthreeScores(String studentID){
//		return sscoreDao.stuthreeScores(studentID);
//	}

	


	
	
}
