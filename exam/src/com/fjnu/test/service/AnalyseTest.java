package com.fjnu.test.service;

import java.util.ArrayList;
import java.util.List;

import com.fjnu.service.inter.RelationToolClass;

public class AnalyseTest {
	public static void main(String[] args) {
//		2015/11/24 10:00 测试基本信息的显示
		
//		String stuNumSql = "select count(pk_test_main_id)as test_student_num from t_testmain where grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		String maxSql = "select MAX(realscore) from t_testmain where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		String minSql = "select MIN(realscore) from t_testmain where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		String avgSql = "select AVG(realscore) from t_testmain where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		String passSql = "select sum(case when t_testmain.realscore>=60 then 1 else 0 end)/Count(*) from  t_testmain  where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		String excellentSql = "select sum(case when t_testmain.realscore>=80 then 1 else 0 end)/Count(*) from  t_testmain  where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'));";
//		ExamAnalyseImpl ea = new ExamAnalyseImpl();
//		List<Object> tempList = new ArrayList<Object>();
//		String choose = "Unit4 time";
//		tempList.add(choose);
//		int stuNum = ea.getStuNum(tempList);
//		float max = ea.getMaxScore(tempList);
//		float min = ea.getMinScore(tempList);
//		float avg = ea.getAverageScore(tempList);
//		float passRate = ea.getPassRate(tempList);
//		float excellentRate = ea.getExcellentRate(tempList);
//		System.out.println("学生人数:" + stuNum + ",最高分:" + max 
//				+ ",最低分:" + min + ",平均分:" + avg
//				+ ",及格率:" + passRate + ",优秀率" + excellentRate);
		
//		2015/11/24 3:00 测试基本信息的成绩分组  
		
//		String sql = "select realscore from t_testmain where grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版')) and realscore != 0";
//		ExamAnalyseImpl ea = new ExamAnalyseImpl();
//		int count = ea.getStuNum(sql);	//1133
//		System.out.println(count);
//		SqlTool tool = new SqlTool();
//		tool.setSql(sql);
//		ResultSet rs = tool.executeQuery();
//		int underSixty = 0;
//		int underSeventy = 0;
//		int underEighty = 0;
//		int underNinety = 0;
//		int underHundred = 0;
//		try {
//			while(rs.next()){
////				System.out.println(rs.getInt(1));
//				if(rs.getInt(1) < 60){
//					underSixty++;
//				}else if(rs.getInt(1)>60 && rs.getInt(1)<70){
//					underSeventy++;
//				}else if(rs.getInt(1)>70 && rs.getInt(1)<80){
//					underEighty++;
//				}else if(rs.getInt(1)>80 && rs.getInt(1)<90){
//					underNinety++;
//				}else{
//					underHundred++;
//				}
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println("小于60分的人数：" + underSixty + "，小于70分的人数：" + underSeventy
//				 + "，小于80分的人数：" + underEighty + "，小于90分的人数：" + underNinety
//				 + "，小于100分的人数：" + underHundred);
//		List<Integer> tempList = new ArrayList<Integer>();
//		tempList.add(underSixty);
//		tempList.add(underSeventy);
//		tempList.add(underEighty);
//		tempList.add(underNinety);
//		tempList.add(underHundred);
//		for(int i=0; i<tempList.size(); i++){
//			System.out.println(tempList.get(i));
//		}
		
//		2015/11/24 4:40 测试学生分布情况包装显示
		
//		ExamAnalyseImpl ea = new ExamAnalyseImpl();
//		List<Object> params = new ArrayList<Object>();
//		String choose = "人教版";
//		params.add(choose);
//		List<Integer> temp = new ArrayList<Integer>(ea.getDistributeScore(params));
//		System.out.println(temp);
//		System.out.println(temp.get(0));
		
//		2015/11/24 18:30 测试从数据库中读取知识点
		
//		String keySql = "select keyword FROM t_question where fk_question_id in(Select question_fk_question_id from t_test_detail where testmain_pk_test_main_id in (select testmain_pk_test_main_id from t_test_detail where testmain_pk_test_main_id=2))";
//		String paperSql = "";
//		SqlTool tool = new SqlTool();
//		tool.setSql(keySql);
//		ResultSet rs = tool.executeQuery();
//		List<List<String>> paperList = new ArrayList<List<String>>();
//		List<String> keyword = new ArrayList<String>();
//		
//		try {
//			while(rs.next()){
//				
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		2015/11/24 18:37 测试获取学生人数的包装类是否能够工作
//		String choose = "人教版";
//		ExamAnalyseImpl ea = new ExamAnalyseImpl();
//		System.out.println(ea.getNum(choose));
		
//		String choose = "人教版";
//		ExamAnalyseImpl ea = new ExamAnalyseImpl(choose);
//		System.out.println(ea.getNum());
//		System.out.println(ea.getMax());
//		System.out.println(ea.getMin());
//		System.out.println(ea.getAvg());
//		System.out.println(ea.getPass());
//		System.out.println(ea.getExcellent());
//		List<Integer> temp = new ArrayList<Integer>(ea.getDistribute());
//		
//		System.out.println(temp);
		
//		2015/11/24 21:50 标准差测试
//		String sql = "select std(realScore) from t_testmain where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'))";
//		SqlTool tool = new SqlTool();
//		tool.setSql(sql);
//		ResultSet rs = tool.executeQuery();
//		
//		try {
//			while(rs.next()){
//				System.out.println(Math.sqrt(rs.getDouble(1)));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
//		2015/11/24 22:45 测试标准差包装方法
//		List<Object> scopeList = new ArrayList<Object>();
//		String scope = "人教版";
//		scopeList.add(scope);
//		ExamAnalyseImpl ea = new ExamAnalyseImpl(scopeList);
//		System.out.println(ea.getStandard());
		
//		2015/11/25 0:44 测试限制范围的标准差包装方法
//		List<Object> scopeList = new ArrayList<Object>();
//		String scope = "人教版";
//		String grandient = "1";
//		scopeList.add(scope);
//		scopeList.add(grandient);
//		ExamAnalyseImpl ea = new ExamAnalyseImpl(scopeList);
//		System.out.println(ea.getNum());
//		System.out.println(ea.getAvg());
//		System.out.println(ea.getMax());
//		System.out.println(ea.getMin());
//		System.out.println(ea.getExcellent());
//		System.out.println(ea.getPass());
//		System.out.println(ea.getDistribute());
//		System.out.println(ea.getStandard());
		
//		2015/11/25 12:58 测试简易版List知识关联分析
//		{"ID","A","B","C","D","E"},
//		{"1","A","C","D"},
//		{"2","B","C","E"},
//		{"3","A","B","C","E"},
//		{"4","B","E"}
//		List<String> keyword1 = new ArrayList<String>();
//		List<String> keyword2 = new ArrayList<String>();
//		List<String> keyword3 = new ArrayList<String>();
//		List<String> keyword4 = new ArrayList<String>();
//		List<String> keyword5 = new ArrayList<String>();
//		List<List<String>> grandient = new ArrayList<List<String>>();
//		String a = "A";
//		String b = "B";
//		String c = "C";
//		String d = "D";
//		String e = "E";
//		String id = "id";
//		
//		keyword5.add(id);
//		keyword5.add(a);
//		keyword5.add(b);
//		keyword5.add(c);
//		keyword5.add(d);
//		keyword5.add(e);
//		grandient.add(keyword5);
//		
//		keyword1.add("11");
//		keyword1.add(a);
//		keyword1.add(c);
//		keyword1.add(d);
//		grandient.add(keyword1);
//		
//		keyword2.add("23");
//		keyword2.add(b);
//		keyword2.add(c);
//		keyword2.add(e);
//		grandient.add(keyword2);
//		
//		keyword3.add("31");
//		keyword3.add(a);
//		keyword3.add(b);
//		keyword3.add(c);
//		keyword3.add(e);
//		grandient.add(keyword3);
//		
//		keyword4.add("46");
//		keyword4.add(b);
//		keyword4.add(e);
//		grandient.add(keyword4);
//		
//		
//		System.out.println(keyword5);
//		System.out.println(keyword1);
//		System.out.println(keyword2);
//		System.out.println(keyword3);
//		System.out.println(keyword4);
//		System.out.println(grandient);
//		
//		RelationToolImpl relationtool = new RelationToolImpl();
//		relationtool.relationTool(grandient);
//		List<List<String>> list = relationtool.getList();
////		System.out.println(list);
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i));
//		}
		
//		String[][] array = {
//		{"ID","A","B","C","D","E"},
//		{"1","A","C","D"},
//		{"2","B","C","E"},
//		{"3","A","B","C","E"},
//		{"4","B","E"}
//		};
//		RelationToolImpl tool = new RelationToolImpl();
//		tool.getRecord(array);
//		System.out.println(tool.turnRecord());
		
//		2015/11/25	2:07 测试插入数据到list开头
		
//		List<String> list = new ArrayList<String>();
//		list.add("aaa");
//		list.add("bbb");
//		list.add(0, "ccc");
//		System.out.println(list);
	}
}
