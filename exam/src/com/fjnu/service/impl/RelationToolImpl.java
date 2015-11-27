package com.fjnu.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.inter.RelationToolClass;
import com.fjnu.utils.SqlTool;

/**
 * 知识点关联的进一步封装
 * @author vengeance
 *
 */
public class RelationToolImpl extends RelationToolClass {
	/**
	 * 输入范围进行知识点关联处理
	 * @param params
	 * @return 知识点关联列表
	 */
	public List<List<String>> doRelation(List<Object> params){
		String grandientSql ="select pk_test_main_id from t_testmain "
				+ "where subject like   ?  and grandient_grandientId in  "
				+ "(select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in"
				+ "(SELECT pk_scope_id from t_scope where name like '人教版') ) "
				+ "and grandient_grandientId in(select grandientId from t_grandient "
				+ "where grandientsecequenceno=  ?   ) limit 100";
		String keywordSql = "select distinct keyword from t_question "
				+ "where fk_question_id in(Select question_fk_question_id from t_test_detail "
				+ "where testmain_pk_test_main_id=?) and keyword  <>'' ";
		SqlTool tool = new SqlTool();
		List<String> keywordAll = new ArrayList<String>();		//保存所有出现过的知识点
		List<List<String>> grandientList = new ArrayList<List<String>>();	//保存题目/试卷列表
		tool.setSql(grandientSql);
		tool.setParams(params);
		ResultSet grandientRS = tool.executeQuery();	//获得题目/试卷列表
		
		try {
			while(grandientRS.next()){
				tool.setSql(keywordSql);
				List<Object> paramsList = new ArrayList<Object>();	//保存检索知识点的参数
				paramsList.add(grandientRS.getString(1));
				tool.setParams(paramsList);
				ResultSet keywordRS = tool.executeQuery();
				List<String> keywordList = new ArrayList<String>();	//保存知识点列表
				while(keywordRS.next()){
					List<String> tempList = new ArrayList<String>();
					
					tempList.add(keywordRS.getString(1));
					keywordAll.add(keywordRS.getString(1));
					keywordList.addAll(tempList);
				}
				
				keywordList.add(0, "key");
				grandientList.add(keywordList);	//将知识点列表添加到题目/试卷列表
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		List<String> keywordSort = new ArrayList<String>(getList(keywordAll));
		keywordSort.add(0, "key");
		grandientList.add(0, keywordSort);
		
		relationTool(grandientList);	//调用关联处理函数
		List<List<String>> list = getList();
		
		return list;
	}
	
	/**
	 * 筛选重复的知识点
	 * @param oldList
	 * @return 筛选后的列表
	 */
	private List<String> getList(List<String> oldList){
		List<String> list = new ArrayList<String>();
		
		for(int i=0; i<oldList.size(); i++){
			String str = oldList.get(i);
			
			if(!list.contains(str))
				list.add(str);
		}
		
		return list;
	}
	
	public List<List<String>> changeList(List<List<String>> oldList){
		List<List<String>> newList = new ArrayList<List<String>>();
		for (List<String> oldListSon : oldList) {
			int i = oldListSon.size();
			List<String> newListSon = new ArrayList<String>();
			String newString = "";
			for (String string : oldListSon) {
				if(i > 3){
					newString += string;
					newString += "_";
					i--;
					if(i == 3){
						//添加到newListSon
						newListSon.add(newString);
					}
				}else{
					//添加到newListSon
					newListSon.add(string);
				}
			}
			newList.add(newListSon);
		}
		return newList;
	}
}
