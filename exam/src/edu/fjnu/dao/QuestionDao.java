package edu.fjnu.dao;

import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.VQuestion;

/**
 * 对题目的操作
 * @author vengeance
 *
 */
public class QuestionDao {
	VQuestion question = new VQuestion();//操作数据库题目表的对象
	QueryRunner qr = new TxQueryRunner();//操作数据库的对象
	
	public double getHard(VQuestion question) {
		
		return 0;
	}
}
