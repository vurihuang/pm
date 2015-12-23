package edu.fjnu.test.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.fjnu.dao.QuestionDao;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestMain;
import edu.fjnu.service.RelationService;

public class TestRelationAnalyse {
	QuestionDao qDao = new QuestionDao();
	RelationService rs = new RelationService();

	// 得到指定学科指定年级的所有知识点
	@Test
	public void getKeywordOneYear() {
		List<VQuestion> keywordList = qDao.getKeywordOneYear("语文", "初一%");
		System.out.println(keywordList);
		// for(int i=0; i<keywordList.size(); i++){
		// System.out.print(keywordList.get(i).getKeyword() + "\n");
		// }
	}

	// 得到指定学科指定年级的所有试卷ID
	@Test
	public void getPaperIdOneYear() {
		List<VTestMain> paperIdList = qDao.getPaperIdOneYear("语文", "初一%");
		System.out.println(paperIdList);
		// for(int i=0; i<keywordList.size(); i++){
		// System.out.print(keywordList.get(i).getKeyword() + "\n");
		// }
	}
	//测试获取知识点列表是否成功
	@Test
	public void testGetKeywordList() {
//		rs.aaa("语文", "初一%");
//		RelationAnalyse ra = new RelationAnalyse();
//		ra.getRecordxxx(rs.aaa("语文", "初一%"));
	}
	
	//测试关联分析是否成功
	@Test
	public void testRa(){
		RelationService rs = new RelationService();
//		rs.doRelationByScope("语文", "初一%");
		String[] s = rs.keywordArray("语文", "三年级%");
//		System.out.println(s.toString());
//		System.out.println(s.length);
		Object[][] value = rs.stvArray();
		if(value == null){
			System.out.println("为空");
		}else{
			for(int i=0; i<value.length; i++){
				for(int j=0; j<value[i].length; j++){
					System.out.print(value[i][j]);
				}
				System.out.println();
			}
		}
//		rs.print();
//		for(int i=0; i<s.length; i++){
//			System.out.println(s[i]);
//		}
	}
	
	@Test
	public void testReflect() throws NoSuchMethodException, SecurityException{
//		System.out.println(rs.getClass());//class edu.fjnu.service.RelationService
//		System.out.println(rs.getClass().getName());//edu.fjnu.service.RelationService
//		System.out.println(Object.class.getSimpleName());
//		Constructor<?> constructor = RelationService.class.getDeclaredConstructor();
//		System.out.println(constructor);

	}
	//测试
	@Test
	public void fun(){
		String value = "0.9888";
		System.out.println(value.substring(0, 4));
	}
	
	
}
