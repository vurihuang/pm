package edu.fjnu.test.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.Testmain;
import edu.fjnu.domain.VGrandientScope;
import edu.fjnu.domain.VMember;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VScope;
import edu.fjnu.domain.VTestDetail;
import edu.fjnu.domain.VTestMain;

public class TestUpeoeDao {
	QueryRunner qr = new TxQueryRunner();
	VMember member = new VMember();
	VGrandientScope gs = new VGrandientScope();
	VQuestion question = new VQuestion();
	VScope scope = new VScope();
	VTestMain testmain = new VTestMain();
	VTestDetail testdetail = new VTestDetail();
	String sql ="";
	@Test
	public void searchGrandient() throws SQLException{
		sql = "select * from t_grandient_t_scope where t_grandient_grandientid = '423'";
		gs = qr.query(sql, new BeanHandler<VGrandientScope>(VGrandientScope.class));
		System.out.println(gs);
	}
	
	@Test
	public void searchMember() throws SQLException {
		sql = "select * from t_member where memberid = '100'";
		member = qr.query(sql, new BeanHandler<VMember>(VMember.class));
		System.out.println(member);
	}
	
	@Test
	public void searchQuestion() throws SQLException {
		sql = "select * from t_question where fk_question_id = '1'";
		question = qr.query(sql, new BeanHandler<VQuestion>(VQuestion.class));
		System.out.println(question);
	}
	
	@Test
	public void searchScope() throws SQLException {
		sql = "select * from t_scope where pk_scope_id = '1'";
		scope = qr.query(sql, new BeanHandler<VScope>(VScope.class));
		System.out.println(scope);
	}
	
	@Test
	public void searchTestMain() throws SQLException {
		sql = "select * from t_testmain where pk_test_main_id = '1'";
		testmain = qr.query(sql, new BeanHandler<VTestMain>(VTestMain.class));
		System.out.println(testmain);
	}
	
	@Test
	public void searchTestDetail() throws SQLException {
		sql = "select * from t_test_detail where pk_test_id = '1'";
		testdetail = qr.query(sql, new BeanHandler<VTestDetail>(VTestDetail.class));
		System.out.println(testdetail);
	}
}
