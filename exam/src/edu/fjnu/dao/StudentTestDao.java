/**
 * 
 */
package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestMain;

/**
 * 这是操作学生考卷的dao
 * @author Administrator
 *
 */
public class StudentTestDao {
	private QueryRunner qr = new TxQueryRunner();//执行数据库操作并存储返回的结果
	/**
	 * 传入学生名字，年级，科目查询该学生的所有试卷信息list
	 * @param studentName
	 * @param gradeName
	 * @param subject
	 * @return
	 */
	public List<VTestMain> findTestMainId(String subject,String studentName,String gradeName){
		try{
			Object[] params = {subject,studentName,gradeName};
			String sql= "select * from  t_testmain where "  
					+ " subject like ? " 
					+ " and student_memberId in "
					+ " (select memberid from t_member " 
					+ " 	where name like ?) "
					+ " and  grandient_grandientId in(select DISTINCT t_grandient.grandientId as `grandientId` "
						+ " 	from t_grandient,t_grandient_t_scope,t_scope as `chapter`,t_scope as `unit`,t_scope as `grade` "
						+ " 	where  t_grandient.grandientId=t_grandient_t_scope.t_grandient_grandientId "
						+ " 	and t_grandient_t_scope.scopes_pk_scope_id=chapter.pk_scope_id "
						+ " 	and chapter.fk_parent_id=unit.pk_scope_id "
						+ " 	and unit.fk_parent_id=grade.pk_scope_id "
						+ " 	and grade.name like ?)";
			return  qr.query(sql, new BeanListHandler<VTestMain>(VTestMain.class),params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	/**
	 * 传入试卷的id 得到 这张试卷所有的题目表VQuestion的list
	 * @param testMainId
	 * @return List<VQuestion>
	 */
	public List<VQuestion> searchQuestionList(int testMainId){
		
		try {
			
			 Object[] params = {testMainId};
			 String sql = "select * from t_question "
				          +"   where fk_question_id in (select pk_test_id from t_test_detail "
						  +"   where testmain_pk_test_main_id=?)";
			 return  qr.query(sql, new BeanListHandler<VQuestion>(VQuestion.class),params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 输入知识点范围 scope 得到  知识点keyword 和该知识点的错误率
	 * @param scope
	 * @return keyword wrong
	 */
public List<VQuestion> searchWrongRate(String scope){
		
		try {
			
			 Object[] params = {scope};
			 String sql = "select keyword,sum(case "
			              +" when t_test_detail.answer!=t_test_detail.stuanswer "
			              +" then 1 else 0 end)/Count(*) as wrong "
			              +" from t_test_detail,t_question,t_testmain "
			              +" where t_test_detail.question_fk_question_id=t_question.fk_question_id  "
			              +" and t_testmain.pk_test_main_id=t_test_detail.testmain_pk_test_main_id "
			              +" and t_testmain.scope like ? "
			              +" and keyword !='' group by keyword";
			return qr.query(sql, new BeanListHandler<VQuestion>(VQuestion.class),params);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}

}
