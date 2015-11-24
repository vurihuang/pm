package com.fjnu.service.impl;

/**
 * 计算试卷的难易程度
 * 难度值越高，试卷难度越大
 * @author vengeance
 *
 */
public class ExamHardLevelImpl {
	private double k = 100;
	/**
	 * 计算试卷难度
	 * @param d
	 * @return 试卷难度
	 */
	public double getHardLevel(double d){
		return (1-d/k);
	}
}
