package com.fjnu.service.impl;

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
public class ExamAnalyseImpl {
	private float averageScore = 0;
	private int stuNum = 0;
	private float maxScore = 0;
	private float minScore = 0;
	private float passRate = 0;
	private float excellentRate = 0;
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
	 * 计算学生试卷的平均分
	 * @param sql
	 * @return 平均分
	 */
	public float getAverageScore(String sql){
		SqlTool tool = new SqlTool();
		ResultSet rs;
		tool.setSql(sql);
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
	 * 得到学生成绩的分布情况
	 * @param sql
	 * @return 学生分布情况
	 */
	public List<Integer> getDistributeScore(String sql){
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		ResultSet rs = tool.executeQuery();
		int raw = 1;
		try {
			while(rs.next()){
				distributeScore.add(rs.getInt(raw));
				raw++;
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
		
		return distributeScore;
	}
	
}
