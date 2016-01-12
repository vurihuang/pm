package edu.fjnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import edu.fjnu.domain.DifficultInfo;
import edu.fjnu.domain.Keyword;

/**
 * 获取知识点信息
 * 
 * @author vengeance
 *
 */
public class KeywordDao {
	Keyword tmpKeyword = new Keyword();// 知识点信息
	DifficultInfo tmpDifficultInfo = new DifficultInfo();// 知识点所出题目类型题数情况
	QueryRunner qr = new TxQueryRunner();

	/**
	 * 输入知识点名称得到做对做错的情况
	 * 
	 * @param keyword
	 * @return 知识点对象
	 */
	public Keyword getKeywordInfo(Keyword keyword) {
		String sql = "SELECT sum(t_question.successNum) as rightCount,(SUM(t_question.num)-sum(t_question.successNum))as wrongCount "
				+ "from t_question where keyword like ?";
		// String paramsString = "%" + keyword.getKeyName()+"%";
		Object[] params = { "%" + keyword.getKeyName() + "%" };

		try {
			// 查询知识点的做对做错次数情况
			tmpKeyword = qr.query(sql, new BeanHandler<Keyword>(Keyword.class), params);
			tmpKeyword.setKeyName(keyword.getKeyName());
			System.out.println(tmpKeyword);// TEST
		} catch (SQLException e) {
			System.err.println("查询知识点做对做错次数信息出错");
			e.printStackTrace();
			return null;
		}
		return tmpKeyword;
	}

	/**
	 * 输入知识点名称得到这个知识点的难中易题数分布情况
	 * 
	 * @param keyword
	 * @return 难中易题数列表
	 */
	public List<DifficultInfo> getKeyDiffInfo(Keyword keyword) {
		String sql = "select DISTINCT difficultyLevel ,COUNT(DISTINCT t_question.fk_question_id) AS questionCount "
				+ "from t_question where keyword like ? GROUP BY difficultyLevel";
		Object[] params = { "%" + keyword.getKeyName() + "%" };
		List<DifficultInfo> diffList = new ArrayList<DifficultInfo>();

		try {
			// 得到这个知识点的难中易题数分布情况的列表
			diffList = qr.query(sql, new BeanListHandler<DifficultInfo>(DifficultInfo.class), params);
			System.out.println(diffList);// TEST
		} catch (SQLException e) {
			System.err.println("查询知识点难中易分布情况出错");
			e.printStackTrace();
			return null;
		}
		return diffList;
	}
}
