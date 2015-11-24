package com.fjnu.test.service;

import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.impl.RelationToolImpl;

/**
 * 测试知识点关联分析类是否能正常工作
 * @author vengeance
 *
 */
public class RelationToolImplTest {
	public static void main(String[] args) {
//		RelationToolImpl tool = new RelationToolImpl();
//		String[][] array = {
//				{"ID","A","B","C","D","E"},
//				{"1","A","C","D"},
//				{"2","B","C","E"},
//				{"3","A","B","C","E"},
//				{"4","B","E"}
//		};
		
//		2015/11/24 9:00 测试知识点关联结果列表是否正常显示
//		tool.relationTool(array);
//		List<List<String>> list = tool.getList();	//得到知识点关联分析结果列表
//		System.out.println(list);
		
//		2015/11/24 11:37 测试从数据库中获取数据进行知识点关联
//		SqlTool tool = new SqlTool();
//		String grandientSql = "select pk_test_main_id from t_testmain where subject like   '数学'  and grandient_grandientId in  (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版') )and grandient_grandientId<500 and grandient_grandientId in(select grandientId from t_grandient where grandientsecequenceno=  1   )ORDER BY RAND() LIMIT 20";
//		String keywordSql = "select distinct keyword FROM t_question where fk_question_id in(Select question_fk_question_id from t_test_detail where testmain_pk_test_main_id=?)";
//		String grandientId;
//		String keyword;
//		
//		tool.setSql(grandientSql);
//		ResultSet rs = tool.executeQuery();
//		List<String> keywordList  = new ArrayList<String>();
//		List<List<String>> grandientList = new ArrayList<List<String>>();
//		try {
//			while(rs.next()){
//				grandientId = rs.getString(1);
//				List<Object> tempList = new ArrayList<Object>();
//				tempList.add(grandientId);
//				SqlTool keyTool = new SqlTool();
//				keyTool.setSql(keywordSql);
//				keyTool.setParams(tempList);
//				
//				ResultSet keyRS = keyTool.executeQuery();
//				
//				while(keyRS.next()){
//					keyword = keyRS.getString(1);
//					keywordList.add(keyword);
//				}
//				
//				grandientList.add(keywordList);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(grandientList);
//		System.out.println(keywordList);
//		RelationToolImpl relationTool = new RelationToolImpl();
//		relationTool.relationTool(grandientList);
//		List<List<String>> list = relationTool.getList();
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
		
//		String grandientSql = "select pk_test_main_id from t_testmain "
//				+ "where subject like   '数学'  and grandient_grandientId in  "
//				+ "(select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in"
//				+ "(SELECT pk_scope_id from t_scope where name like '人教版') ) "
//				+ "and grandient_grandientId in(select grandientId from t_grandient "
//				+ "where grandientsecequenceno=  3   ) limit 5";
//		String keywordSql = "select distinct keyword FROM t_question "
//				+ "where fk_question_id in(Select question_fk_question_id from t_test_detail "
//				+ "where testmain_pk_test_main_id=?)";
//		
//		SqlTool tool = new SqlTool();
//		tool.setSql(grandientSql);
//		ResultSet rs = tool.executeQuery();
//		List<String> keywordAll = new ArrayList<String>();
//		List<List<String>> grandientList = new ArrayList<List<String>>();
//		
//		try {
//			while(rs.next()){
////				System.out.println(rs.getString(1));
//				tool.setSql(keywordSql);
//				List<Object> tempList = new ArrayList<Object>();
//				tempList.add(rs.getString(1));
//				tool.setParams(tempList);
//				ResultSet keyRs = tool.executeQuery();
//				List<String> keywordList = new ArrayList<String>();
//				while(keyRs.next()){
////					System.out.println(keyRs.getString(1));
//					List<String> temp = new ArrayList<String>();
//					
//					temp.add(keyRs.getString(1));
//					keywordAll.add(keyRs.getString(1));
//					keywordList.addAll(temp);
//				}
//				keywordList.add(0,"keyword");
//				grandientList.add(keywordList);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
////		System.out.println("全部知识点筛选前：" + keywordAll);
//		List<String> keywordSort = new ArrayList<String>(getList(keywordAll));
////		System.out.println("全部知识点筛选后：" + keywordSort);
//		keywordSort.add(0, "keyword");
//		grandientList.add(0, keywordSort);
//		
//		for(int i=0; i<grandientList.size(); i++){
//			System.out.println(grandientList.get(i));
//		}
////		for(int i=0; i<keywordList.size(); i++){
////			System.out.println(keywordList.get(i));
////		}
//		
//		RelationToolClass rt = new RelationToolClass();
//		rt.relationTool(grandientList);
//		List<List<String>> list = rt.getList();
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
		
//		2015/11/25 3:48 对知识点关联包装进行测试
		List<Object> params = new ArrayList<Object>();
		String scope = "语文";
		String id = "3";
		params.add(scope);
		params.add(id);
		RelationToolImpl rt = new RelationToolImpl();
		List<List<String>> list = rt.doRelation(params);
//		System.out.println(list);
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i));
		}
	}
	
//	public static List<String> getList(List<String> old){
//		List<String> list = new ArrayList<String>();
//		for(int i=0; i<old.size(); i++){
//			String str = old.get(i);
//			if(!list.contains(str))
//				list.add(str);
//		}
//		
//		return list;
//	}
}
