package com.fjnu.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.utils.SqlTool;

/**
 * 计算试卷的区分度
 * 区分度：反映学生掌握知识水平的差异能力，学生水平的差异程度
 * 区分度越高，学生的水平差异越大
 * @author vengeance
 *
 */
public class ExamDistinguishImpl {
	private double first = 0;
	private double last = 0;
	private double percent = 0.25;	//选取百分前25和后25的学生
	List<Object> params = null;
	
	/**
	 * 初始化查找范围参数
	 * @param temp
	 */
	public ExamDistinguishImpl(List<Object> temp){
		params = new ArrayList<Object>(temp);
	}
	/**
	 * 计算区分度
	 * @param max 卷面最高分
	 * @param min 卷面最低分
	 * @return 区分度
	 */
	public double getDistinguish(double max, double min){
		first = topScore();
		last = underScore();
		return ((first - last)/(max - min)) * percent;
	}
	
	/**
	 * 
	 * @return 获得前(percent*100)%学生的总分 
	 */
	private double topScore(){
		String sql = "";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				first = rs.getDouble(1);
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
		return first;
	}
	
	/**
	 * 
	 * @return 获得后(percent*100)%学生的总分
	 */
	private double underScore(){
		String sql = "";
		SqlTool tool = new SqlTool();
		tool.setSql(sql);
		tool.setParams(params);
		ResultSet rs = tool.executeQuery();
		
		try {
			while(rs.next()){
				last = rs.getDouble(1);
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
		return last;
	}
}
