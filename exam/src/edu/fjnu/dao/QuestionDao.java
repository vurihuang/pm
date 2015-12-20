package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestDetail;
import edu.fjnu.domain.VTestMain;

/**
 * 对题目的操作
 * 
 * @author vengeance
 *
 */
public class QuestionDao {
	VQuestion question = new VQuestion();// 操作数据库题目表的对象
	QueryRunner qr = new TxQueryRunner();// 操作数据库的对象

	/**
	 * 得到指定试卷ID的试卷难度
	 * 
	 * @return
	 * @throws SQLException
	 */
	public VQuestion getHard(int testID) throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong from t_question,t_testmain,t_test_detail"
				+ " where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.pk_test_main_id=?";
		Object[] params = {testID};
		question = qr.query(sql, new BeanHandler<VQuestion>(VQuestion.class), params);
		return question;
	}

	/**
	 * 根据题目ID得到该题平均得分
	 * 
	 * @return
	 * @throws SQLException
	 */
	public VTestDetail getScoreBySubjectId() throws SQLException {
		String sql = "select ((sum(t_test_detail.score))/count(*)) as score  " + "from t_test_detail,t_testmain "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id='2' and stuAnswer <>''";
		return qr.query(sql, new BeanHandler<VTestDetail>(VTestDetail.class));
	}

	/**
	 * 得到每份试卷的错误率
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VQuestion> getWrong() throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong, t_testmain.realScore "
				+ "from t_question,t_testmain,t_test_detail "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.realScore!='0' " + "and t_testmain.useTime>='5'"
				+ "GROUP BY t_testmain.pk_test_main_id";
		List list = qr.query(sql, new BeanListHandler<VQuestion>(VQuestion.class));
		return list;
	}

	/**
	 * 得到每份试卷的得分
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VTestDetail> getScore() throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong, t_testmain.realScore "
				+ "from t_question,t_testmain,t_test_detail "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.realScore!='0' " + "and t_testmain.useTime>='5'"
				+ "GROUP BY t_testmain.pk_test_main_id";
		List list = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class));
		return list;
	}

	/**
	 * 获取指定ID题目的得分情况，用来计算该题标准差
	 * 
	 * @param questionID
	 * @return
	 * @throws SQLException
	 */
	public List<VTestDetail> getStdDeviation(Long questionID) throws SQLException {
		String sql = "select  t_testmain.student_memberId,t_test_detail.answer,t_test_detail.stuAnswer,t_test_detail.score"
				+ " from t_test_detail,t_testmain"
				+ " where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id"
				+ " and t_test_detail.question_fk_question_id=?" + " and t_test_detail.stuAnswer !=''";
		Object[] params = { questionID };
		List list = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class), params);

		return list;
	}

	/**
	 * 根据试卷ID得到题目ID列表
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VTestDetail> getQstListById(int testID) throws SQLException {
		String sql = "select t_test_detail.question_fk_question_id from t_testmain,t_test_detail "
				+ " where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id"
				+ " and t_testmain.pk_test_main_id=?" + " ORDER BY t_test_detail.sequence ASC";
		Object[] params = { testID };
		List list = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class), params);

		return list;
	}

	/**
	 * 得到所有过滤过的试卷ID
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VTestMain> getAllTestId() throws SQLException {
		String sql = "select t_testmain.pk_test_main_id " + "from t_question,t_testmain,t_test_detail "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.realScore!='0' " + "and t_testmain.useTime>='5'"
				+ "GROUP BY t_testmain.pk_test_main_id";
		List<VTestMain> list = qr.query(sql, new BeanListHandler<VTestMain>(VTestMain.class));

		return list;
	}

	/**
	 * 根据试卷的题目ID得到做过这道题的所有学生得分情况
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VTestMain> getStuIdAndScoreByQstId(VTestDetail testdetail) throws SQLException {
		String sql = "select  t_testmain.student_memberId,t_test_detail.answer,t_test_detail.stuAnswer, "
				+ " case when t_test_detail.stuanswer != t_test_detail.answer  then t_test_detail.score='0' else t_test_detail.score end AS realscore "
				+ " from t_test_detail,t_testmain  "
				+ " where  t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ " and t_test_detail.question_fk_question_id=? " + " and t_test_detail.stuAnswer !='' "
				+ " ORDER BY student_memberId ";
		Object[] params = {testdetail.getQuestion_fk_question_id()};
		List<VTestMain> stuIdList = qr.query(sql, new BeanListHandler<VTestMain>(VTestMain.class), params);
		List<VTestDetail> scoreList = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class), params);

		for (int i = 0; i < stuIdList.size(); i++) {
			stuIdList.get(i).setTestdetail(scoreList.get(i));
		}

		return stuIdList;
	}
	
	/**
	 * 通过学生ID得到这个学生的阶段平均分（普通使用版）
	 * @param testmain
	 * @return
	 * @throws SQLException
	 */
	public List<VTestMain> getStuAvgScoreById(VTestMain testmain) throws SQLException {
		String sql = "select t_testmain.pk_test_main_id,avg(t_testmain.realScore)as realscore "
				+ " from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member,t_testmain  "
				+ " where t_course_t_member.courses_courseId=t_course.courseId "
				+ " and t_member_t_member.students_memberId=t_course_t_member.members_memberId "
				+ " and t_coursetype.courseTypeId=t_course.courseTypeID "
				+ " and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id "
				+ " and t_testmain.student_memberId=t_member_t_member.students_memberId "
				+ " and t_member_t_member.students_memberId=? " + " and t_scope.name='初二（上）' "
				+ " and t_testmain.`subject`='语文' " + " group by t_testmain.pk_test_main_id";
		
		Object[] params = {testmain.getStudent_memberId()};
		
		return qr.query(sql, new BeanListHandler<VTestMain>(VTestMain.class), params);
	}

	/**
	 * 根据试卷题目ID得到学生的阶段平均分（待修正）
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<VTestMain> getStuAvgScoreOfScope() throws SQLException {
		String sql = "select t_member_t_member.students_memberId,avg(t_testmain.realScore) as realscore"
				+ " from t_scope,t_course,t_coursetype ,t_member_t_member ,t_course_t_member,t_testmain t_testmain"
				+ " where t_course_t_member.courses_courseId=t_course.courseId"
				+ " and t_member_t_member.students_memberId=t_course_t_member.members_memberId"
				+ " and t_coursetype.courseTypeId=t_course.courseTypeID"
				+ " and t_coursetype.grade_pk_scope_id=t_scope.pk_scope_id"
				+ " and  t_member_t_member.students_memberId=t_testmain.student_memberId"
				+ " and t_member_t_member.students_memberId in (select DISTINCT t_testmain.student_memberId from t_testmain,t_test_detail"
				+ " where  t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id"
				+ " and t_test_detail.question_fk_question_id='02'" + " and t_test_detail.stuAnswer !='' )"
				+ " and t_scope.name='初二（上）'" + " and t_testmain.`subject`='语文'" + " and t_testmain.realScore!='0'"
				+ " GROUP BY t_member_t_member.students_memberId";
		List<VTestMain> avgScoreList = qr.query(sql, new BeanListHandler<VTestMain>(VTestMain.class));

		return avgScoreList;
	}

}
