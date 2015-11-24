package com.fjnu.service.inter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.utils.SqlTool;

/**
 * 分析学生试卷的基本信息数据
 * @author vengeance
 *
 */
public class ExamAnalyseClass implements ExamAnalyseInter{
	private float averageScore = 0;
	private int stuNum = 0;
	private float maxScore = 0;
	private float minScore = 0;
	private float passRate = 0;
	private float excellentRate = 0;
	private float standardDeviation = 0;
	private List<Integer> distributeScore = new ArrayList<Integer>(); 
	/**
	 * 获取学生测试人数
	 * @param sql
	 * @return 学生测试人数
	 */
	public int getStuNum(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				stuNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return stuNum;
	}
	
	/**
	 * 等待客户端选择传值，获取学生人数
	 * @param params
	 * @return 学生人数
	 * 
	 */
	@Override
	public int getStuNum(List<Object> params) {
		String sql = "select count(pk_test_main_id)as test_student_num from t_testmain "
				+ "where grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?))";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		try {
			while(rs.next()){
				stuNum = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return stuNum;
	}
	
	/**
	 * 计算学生试卷的平均分
	 * @param sql
	 * @return 平均分
	 */
	public float getAverageScore(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs;
		rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				averageScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return averageScore;
	}
	
	/**
	 * 等待客户端选择传值，获取试卷平均分
	 * @param params
	 * @return 平均分
	 * 
	 */
	@Override
	public float getAverageScore(List<Object> params) {
		String sql = "select AVG(realscore) from t_testmain "
				+ "where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?))";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs;
		rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				averageScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return averageScore;
	}
	
	/**
	 * 获得学生试卷的最高分
	 * @param sql
	 * @return 最高分
	 */
	public float getMaxScore(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				maxScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return maxScore;
	}
	
	/**
	 * 等待客户端传值，计算试卷最高分数
	 * @param params
	 * @return 最高分
	 */
	@Override
	public float getMaxScore(List<Object> params) {
		String sql = "select MAX(realscore) from t_testmain "
				+ "where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?))";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				maxScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return maxScore;
	}
	
	/**
	 * 获得学生试卷的最低分
	 * @param sql
	 * @return 最低分
	 */
	public float getMinScore(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				minScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return minScore;
	}
	
	/**
	 * 等待客户端传值，计算试卷最低分
	 * @param
	 * @return 最低分 
	 */
	@Override
	public float getMinScore(List<Object> params) {
		String sql = "select MIN(realscore) from t_testmain "
				+ "where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?))";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				minScore = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return minScore;
	}
	
	/**
	 * 获取试卷及格率
	 * @param sql
	 * @return 及格率
	 */
	public float getPassRate(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				passRate = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return passRate;
	}
	
	/**
	 * 等待客户端传值，计算试卷及格率
	 * @param
	 * @return 及格率
	 */
	@Override
	public float getPassRate(List<Object> params) {
		String sql = "select sum(case when t_testmain.realscore>=60 then 1 else 0 end)/Count(*) from  t_testmain  "
				+ "where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?))";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				passRate = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return passRate;
	}
	
	/**
	 * 获取试卷优秀率
	 * @param sql
	 * @return	优秀率
	 */
	public float getExcellentRate(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				excellentRate = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return excellentRate;
	}
	
	/**
	 * 等待客户端传值，计算试卷优秀率
	 * @param
	 * @return 优秀率
	 */
	@Override
	public float getExcellentRate(List<Object> params) {
		String sql = "select sum(case when t_testmain.realscore>=80 then 1 else 0 end)/Count(*) from  t_testmain  "
				+ "where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?));";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				excellentRate = rs.getFloat(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return excellentRate;
	}

	
	/**
	 * 得到学生成绩的分布情况
	 * @param sql
	 * @return 学生分布情况
	 */
	public List<Integer> getDistributeScore(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		
		int[] distributeArray = new int[5];
		
		try {
			while(rs.next()){
				if(rs.getInt(1) < 60){
					distributeArray[0]++;
				}else if(rs.getInt(1)>60 && rs.getInt(1)<70){
					distributeArray[1]++;
				}else if(rs.getInt(1)>70 && rs.getInt(1)<80){
					distributeArray[2]++;
				}else if(rs.getInt(1)>80 && rs.getInt(1)<90){
					distributeArray[3]++;
				}else{
					distributeArray[4]++;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=0; i<distributeArray.length; i++){
			distributeScore.add(distributeArray[i]);
		}
	
		return distributeScore;
	}
	
	/**
	 * 等待客户端传值，计算学生成绩分布情况
	 * @param params
	 * @return 成绩分布列表
	 */
	public List<Integer> getDistributeScore(List<Object> params){
		String sql = "select realscore from t_testmain "
				+ "where grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope "
				+ "where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like ?)) and realscore != 0";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		int[] distributeArray = new int[5];
		
			try {
				while(rs.next()){
					if(rs.getInt(1) < 60){
						distributeArray[0]++;
					}else if(rs.getInt(1)>60 && rs.getInt(1)<70){
						distributeArray[1]++;
					}else if(rs.getInt(1)>70 && rs.getInt(1)<80){
						distributeArray[2]++;
					}else if(rs.getInt(1)>80 && rs.getInt(1)<90){
						distributeArray[3]++;
					}else{
						distributeArray[4]++;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		for(int i=0; i<distributeArray.length; i++){
			distributeScore.add(distributeArray[i]);
		}
		
		return distributeScore;
	}
	
	/**
	 * 计算学生成绩标准差
	 * @param sql
	 * @return 成绩标准差 
	 */
	public float getStandardScore(String sql){
		return standardDeviation;
	}
	
	/**
	 * 计算学生成绩标准差
	 * @param params 选项
	 * @return 成绩标准差 
	 */
	@Override
	public float getStandardScore(List<Object> params) {
		return 0;
	}
}
