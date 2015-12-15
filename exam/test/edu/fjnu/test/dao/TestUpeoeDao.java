package edu.fjnu.test.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import com.upeoe.domain.GrandientScope;

import cn.itcast.jdbc.TxQueryRunner;

public class TestUpeoeDao {
	QueryRunner qr = new TxQueryRunner();
	@Test
	public void searchGrandient() throws SQLException{
		GrandientScope tt = new GrandientScope();
		String sql = "select * from t_grandient_t_scope where t_grandient_grandientid = '423'";
		tt = qr.query(sql, new BeanHandler<GrandientScope>(GrandientScope.class));
		System.out.println(tt);
	}
}
