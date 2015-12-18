package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestDetail;

/**
 * 对题目的操作
 * @author vengeance
 *
 */
public class QuestionDao {
	VQuestion question = new VQuestion();//操作数据库题目表的对象
	QueryRunner qr = new TxQueryRunner();//操作数据库的对象
	
	/**
	 * 得到指定试卷ID的试卷难度
	 * @return
	 * @throws SQLException
	 */
	public VQuestion getHard() throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong from t_question,t_testmain,t_test_detail"
				+ " where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.pk_test_main_id='02'";
		question = qr.query(sql, new BeanHandler<VQuestion>(VQuestion.class));
		return question;
	}
	
	/**
	 * 根据题目ID得到该题平均得分
	 * @return
	 * @throws SQLException
	 */
	public VTestDetail getScoreBySubjectId() throws SQLException{
		String sql = "select ((sum(t_test_detail.score))/count(*)) as score  " 
				+ "from t_test_detail,t_testmain "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id='2' and stuAnswer <>''";
		return  qr.query(sql, new BeanHandler<VTestDetail>(VTestDetail.class));
	}
	
	/**
	 * 得到每份试卷的错误率
	 * @return
	 * @throws SQLException
	 */
	public List<VQuestion> getWrong() throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong, t_testmain.realScore "
				+ "from t_question,t_testmain,t_test_detail "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.realScore!='0' "
				+ "and t_testmain.useTime>='5'"
				+ "GROUP BY t_testmain.pk_test_main_id";
		List list = qr.query(sql, new BeanListHandler<VQuestion>(VQuestion.class));
		return list;
	}
	
	/**
	 * 得到每份试卷的得分
	 * @return
	 * @throws SQLException
	 */
	public List<VTestDetail> getScore() throws SQLException {
		String sql = "select sum((t_question.num-t_question.successNum)/t_question.num) as wrong, t_testmain.realScore "
				+ "from t_question,t_testmain,t_test_detail "
				+ "where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id "
				+ "and t_test_detail.question_fk_question_id=t_question.fk_question_id "
				+ "and t_testmain.realScore!='0' "
				+ "and t_testmain.useTime>='5'"
				+ "GROUP BY t_testmain.pk_test_main_id";
		List list = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class));
		return list;
	}
	
	/**
	 * 获取指定ID题目的得分情况，用来计算该题标准差
	 * @return
	 * @throws SQLException
	 */
	public List<VTestDetail> getStdDeviation() throws SQLException {
		String sql = "select  t_testmain.student_memberId,t_test_detail.answer,t_test_detail.stuAnswer,t_test_detail.score" 
				+" from t_test_detail,t_testmain"
				+" where t_testmain.pk_test_main_id=t_test_detail.testMain_pk_test_main_id"
				+" and t_test_detail.question_fk_question_id='51719'"
				+" and t_test_detail.stuAnswer !=''";
		
		List list = qr.query(sql, new BeanListHandler<VTestDetail>(VTestDetail.class));
		
		return list;
	}
}
