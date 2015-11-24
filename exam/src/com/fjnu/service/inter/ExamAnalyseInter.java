package com.fjnu.service.inter;

import java.util.List;

/**
 * 定义试卷基本信息分析的接口
 * @author vengeance
 *
 */
public interface ExamAnalyseInter {
	/*
	 * 获取学生人数
	 */
	public int getStuNum(List<Object> params);
	
	/*
	 * 获取平均分
	 */
	public float getAverageScore(List<Object> params);
	
	/*
	 * 获取最高分
	 */
	public float getMaxScore(List<Object> params);
	
	/*
	 * 获取最低分
	 */
	public float getMinScore(List<Object> params);
	
	/*
	 * 获取及格率
	 */
	public float getPassRate(List<Object> params);
	
	/*
	 * 获取优秀率
	 */
	public float getExcellentRate(List<Object> params);
	
	/*
	 * 获取标准差
	 */
	public float getStandardScore(List<Object> params);
	
	/*
	 * 获取学生成绩分布情况
	 */
	public List<Integer> getDistributeScore(String sql);
}
