package com.fjnu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.inter.ExamAnalyseClass;

/**
 * 继承ExamAnalyseClass中的方法；
 * 输入范围，直接调用方法得到数据
 * @author vengeance
 *
 */
public class ExamAnalyseImpl extends ExamAnalyseClass {
	private List<Object> tempList;	//存储范围
	String choose = null;	//范围
	
	/**
	 * 初始化范围
	 * @param choose
	 */
	public ExamAnalyseImpl(List<Object> choose){
		tempList = new ArrayList<Object>(choose);
	}

	/**
	 * 
	 * @return 返回学生人数
	 */
	public int getNum(){
		return getStuNum(tempList);
	}
	
	/**
	 * 
	 * @return 返回平均分
	 */
	public double getAvg(){
		return getAverageScore(tempList);
	}
	
	/**
	 *
	 * @return 返回最高分
	 */
	public double getMax(){
		return getMaxScore(tempList);
	}
	
	/**
	 * 
	 * @return 返回最低分
	 */
	public double getMin(){
		return getMinScore(tempList);
	}
	
	/**
	 * 
	 * @return 返回及格率
	 */
	public double getPass(){
		return getPassRate(tempList);
	}
	/**
	 * 
	 * @return 返回优秀率
	 */
	public double getExcellent(){
		return getExcellentRate(tempList);
	}
	
	/**
	 * 
	 * @return 返回学生分布情况
	 */
	public List<Integer> getDistribute(){
		return getDistributeScore(tempList);
	}
	
	/**
	 * 
	 * @return 返回成绩标准差
	 */
	public double getStandard(){
		return getStandardScore(tempList);
	}
}
