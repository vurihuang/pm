package edu.fjnu.service;

import java.util.ArrayList;


import java.util.List;

import org.apache.catalina.tribes.util.Arrays;

import edu.fjnu.dao.SscoreDao;
import edu.fjnu.dao.TeacherDao;
import edu.fjnu.domain.Sscore;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;

/**
 * 处理老师业务信息
 * @author vengeance
 *
 */
public class TeacherGradeService {
	private TeacherDao teacherDao = new TeacherDao();
	private SscoreDao sscoreDao = new SscoreDao();
	
	/**
	 * 判断老师登录信息是否正确
	 * @param teacher
	 * @return
	 */
	public boolean checkInfo(Teacher teacher){
		if(teacherDao.checkInfo(teacher) != null){
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
		return teacherDao.teacherInfo(teacher);
	}
	
	/**
	 * 通过teacherID得到courseID
	 * @param courseID
	 * @return
	 */
	public String getCourseIDByTeacherID(String teacherID){
		return sscoreDao.getCourseIDByTeacherID(teacherID);
	}
	
	/**
	 * 得到学生列表
	 * @param teacherID
	 * @return 这个老师所教的学生
	 */
	public List<Student> getStuList(String teacherID){
		return teacherDao.getStuList(teacherID);
	}
	
	/**
	 * 通过teacherID查找在总分各个分数段的个数以数组返回
	 * @param teacherID
	 * @return
	 */
	public int[] sumcountByteacherID(String teacherID){
		List<Student> studentList = teacherDao.getStuList(teacherID);
		int a=0,b=0,c=0,d=0,e=0;
		for(int i = 0;i < studentList.size();i++){
			Student student = studentList.get(i);
			Sscore sscore = sscoreDao.findSumOfStudent(student.getStudentID());
			double sum = sscore.getScore();
			if(sum<180){
				a++;
			}else if(sum>=180 && sum<210){
				b++;
			}else if(sum>=210 && sum<240){
				c++;
			}else if(sum>=240 && sum<270){
				d++;
			}else{
				e++;
			}
		}
		int[] sumcount = {e,d,c,b,a};
		return sumcount;
	}
	
	/**
	 * 及格率
	 * @param courseID
	 * @return
	 */
	public double getPassRate(String courseID) {
		List<Sscore> sscoreList = sscoreDao.lastScores(courseID);
		int passCount = 0;
		
		for(int i=0; i<sscoreList.size(); i++){
			Sscore sscore = sscoreList.get(i);
			
			if(sscore.getScore() >= 60){
				passCount++;
			}
		}
		
		double passRate = (double)passCount/sscoreList.size();
		return passRate;
	}
	
	/**
	 * 优秀率
	 * @param courseID
	 * @return
	 */
	public double getExcellentRate(String courseID){
		List<Sscore> sscoreList = sscoreDao.lastScores(courseID);
		int excellentCount = 0;
		for(int i = 0;i<sscoreList.size();i++){
			Sscore sscore  = sscoreList.get(i);
			if(sscore.getScore() >= 85){
				excellentCount++;
			}
		}
		double excellentRate = (double)excellentCount/sscoreList.size();
		return excellentRate;
	}
	
	/**
	 * 如果还没选择学生或者查不到学生ID，则将该学生历次成绩设为0，表示不显示。
	 * @return 学生历次成绩
	 */
	public List<Sscore> lackOfStudent(){
		List<Sscore> sscorList = new ArrayList<Sscore>();
		Sscore sscore = new Sscore();
		
		for(int i =0;i < 5;i++){
			sscore.setScore(0);
			sscorList.add(sscore);
		}
		
		return sscorList;
	}
	
	/**
	 * 通过courseID查找该课程下历次学生的最高分（按试卷ID排序）（后期还需根据班级）
	 * @param courseID
	 * @return
	 */
	public List<Sscore> maxScores(String courseID) {
		return sscoreDao.maxScores(courseID);
	}
	
	/**
	 * 通过指定教师ID查询所教科目下历次学生的最低分（按试卷ID排序）
	 * @param teacherID
	 * @return
	 */
	public List<Sscore> minScores(String courseID) {
		return sscoreDao.minScores(courseID);
	}
	
	/**
	 * 通过courseID查找该课程下历次学生的平均分（按试卷ID排序）（后期还需根据班级）
	 * @param courseID
	 * @return
	 */
	public List<Sscore> avgScores(String courseID) {
		return sscoreDao.avgScores(courseID);
	}
	
	/**
	 * 通过courseID和studentID查找指定学生历次分数（按试卷ID排序）（后期还需根据班级）
	 * @param courseID
	 * @param stidentID
	 * @return
	 */
	public List<Sscore> stuScores(String courseID, String studentID) {
		return sscoreDao.stuScores(courseID, studentID);
	}
	
	/**
	 * 通过三科courseID得到历次学生最高分总分（伪总分！）
	 * @param cCourseID
	 * @param mCourseID
	 * @param eCourseID
	 * @return
	 */
	public List<Sscore> sumMaxScores(String cCourseID,String mCourseID,String eCourseID){
		List<Sscore> sList = new ArrayList<Sscore>();
		List<Sscore> cList = maxScores(cCourseID);
		List<Sscore> mList = maxScores(mCourseID);
		List<Sscore> eList = maxScores(eCourseID);
		
		for(int i = 0 ;i < cList.size(); i++){
			Sscore cSscore = cList.get(i);
			Sscore mSscore = mList.get(i);
			Sscore eSscore = eList.get(i);
			Sscore sSscore = new Sscore();
			sSscore.setStudentID(cSscore.getStudentID());
			sSscore.setCourseID("00000");
			sSscore.setTestID(cSscore.getTestID());
			sSscore.setPr(cSscore.getPr());
			sSscore.setScore(cSscore.getScore() + mSscore.getScore() + eSscore.getScore());
			sList.add(sSscore);
		}
		return sList;
	}
	
	/**
	 * 通过三科courseID得到历次学生最低分总分（伪总分！）
	 * @param cCourseID
	 * @param mCourseID
	 * @param eCourseID
	 * @return
	 */
	public List<Sscore> sumMinScores(String cCourseID,String mCourseID,String eCourseID){
		List<Sscore> sList = new ArrayList<Sscore>();
		List<Sscore> cList = minScores(cCourseID);
		List<Sscore> mList = minScores(mCourseID);
		List<Sscore> eList = minScores(eCourseID);
		
		for(int i = 0 ;i < cList.size(); i++){
			Sscore cSscore = cList.get(i);
			Sscore mSscore = mList.get(i);
			Sscore eSscore = eList.get(i);
			Sscore sSscore = new Sscore();
			sSscore.setStudentID(cSscore.getStudentID());
			sSscore.setCourseID("00000");
			sSscore.setTestID(cSscore.getTestID());
			sSscore.setPr(cSscore.getPr());
			sSscore.setScore(cSscore.getScore() + mSscore.getScore() + eSscore.getScore());
			sList.add(sSscore);
		}
		return sList;
	}
	
	/**
	 * 通过三科courseID得到历次学生平均分总分（伪总分！）
	 * @param cCourseID
	 * @param mCourseID
	 * @param eCourseID
	 * @return
	 */
	public List<Sscore> sumAvgScores(String cCourseID,String mCourseID,String eCourseID){
		List<Sscore> sList = new ArrayList<Sscore>();
		List<Sscore> cList = avgScores(cCourseID);
		List<Sscore> mList = avgScores(mCourseID);
		List<Sscore> eList = avgScores(eCourseID);
		
		for(int i = 0 ;i < cList.size(); i++){
			Sscore cSscore = cList.get(i);
			Sscore mSscore = mList.get(i);
			Sscore eSscore = eList.get(i);
			Sscore sSscore = new Sscore();
			sSscore.setStudentID(cSscore.getStudentID());
			sSscore.setCourseID("00000");
			sSscore.setTestID(cSscore.getTestID());
			sSscore.setPr(cSscore.getPr());
			sSscore.setScore(cSscore.getScore() + mSscore.getScore() + eSscore.getScore());
			sList.add(sSscore);
		}
		return sList;
	}
	
	/**
	 * 通过三科courseID得到历次学生最低分总分（真总分！）
	 * @param cCourseID
	 * @param mCourseID
	 * @param eCourseID
	 * @return
	 */
	public List<Sscore> sumStuScores(String cCourseID,String mCourseID,String eCourseID,String studentID){
		List<Sscore> sList = new ArrayList<Sscore>();
		List<Sscore> cList = stuScores(cCourseID,studentID);
		List<Sscore> mList = stuScores(mCourseID,studentID);
		List<Sscore> eList = stuScores(eCourseID,studentID);
		
		for(int i = 0 ;i < cList.size(); i++){
			Sscore cSscore = cList.get(i);
			Sscore mSscore = mList.get(i);
			Sscore eSscore = eList.get(i);
			Sscore sSscore = new Sscore();
			sSscore.setStudentID(cSscore.getStudentID());
			sSscore.setCourseID("00000");
			sSscore.setTestID(cSscore.getTestID());
			sSscore.setPr(cSscore.getPr());
			sSscore.setScore(cSscore.getScore() + mSscore.getScore() + eSscore.getScore());
			sList.add(sSscore);
		}
		return sList;
	}
}
