package com.fjnu.test.service;

import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.impl.ExamAnalyseImpl;
import com.fjnu.service.impl.ExamHardLevelImpl;

/**
 * 测试分析试卷的难度、信度、区分度、效度
 * @author vengeance
 *
 */
public class ExamInfo {
	public static void main(String[] args) {
//		2015/11/24 21:40 测试试卷难度
		ExamHardLevelImpl hardLevel = new ExamHardLevelImpl();
		String scope = "人教版";
		String grandient = "1";
		List<Object> tempList = new ArrayList<Object>();
		tempList.add(scope);
		tempList.add(grandient);
		ExamAnalyseImpl ex = new ExamAnalyseImpl(tempList);
		System.out.println(hardLevel.getHardLevel(ex.getAvg()));;
		
		
	}
}
