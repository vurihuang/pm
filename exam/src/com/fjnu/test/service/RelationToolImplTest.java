package com.fjnu.test.service;

import java.util.List;

import com.fjnu.service.impl.RelationToolImpl;

/**
 * 测试知识点关联分析类是否能正常工作
 * @author vengeance
 *
 */
public class RelationToolImplTest {
	public static void main(String[] args) {
		RelationToolImpl tool = new RelationToolImpl();
		String[][] array = {
				{"ID","A","B","C","D","E"},
				{"1","A","C","D"},
				{"2","B","C","E"},
				{"3","A","B","C","E"},
				{"4","B","E"}
		};
		
		tool.relationTool(array);
		List<List<String>> list = tool.getList();	//得到知识点关联分析结果列表
		System.out.println(list);
	}
}
