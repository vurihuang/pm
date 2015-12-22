package edu.fjnu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.fjnu.dao.QuestionDao;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestMain;
import edu.fjnu.util.RelationAnalyse;

/**
 * 处理关联分析数据
 * 
 * @author vengeance
 *
 */
public class RelationService {
	QuestionDao qDao = new QuestionDao();
	RelationAnalyse ra = new RelationAnalyse();// 关联分析处理工具
	List<List<String>> keywordList = null;//知识点列表
	String[] keywordArr = null;//存储关联分析的知识点，用来描点

	/**
	 * 获得关联分析后的有关联的知识点
	 * 
	 * @param courseName
	 * @param year
	 * @return 相关联的知识点
	 */
	public String[] keywordArray(String courseName, String year) {
		keywordList = doRelationByScope(courseName, year);
		List<String> tempList = new ArrayList<String>();//用来存储去重的知识点

		for (int i = 0; i < keywordList.size(); i++) {
			tempList.add(keywordList.get(i).get(1));
		}
		
		keywordArr = removeExistItem(tempList.toArray(new String[tempList.size()]));
		return keywordArr;
	}
	
	/**
	 * 返回一个二维数组，存放知识点关联的关联值value
	 * @return
	 */
	public void stvArray(){
		int cnt = 0;
		for(int i=0; i<keywordList.size(); i++){
			if(keywordList.get(i).size() != 4)
				break;
			else{
				cnt++;
			}
		}
		
		String[][] stvArray = new String[cnt][keywordList.get(0).size()];
		
		System.out.println(keywordList.size());
		
		List<List<String>> stvList = new ArrayList<List<String>>();
		for(int i=0; i<keywordList.size(); i++){
			if(keywordList.get(i).size() >4){
				break;
			}else{
					List<String> temp = new ArrayList<String>();
					temp.add(keywordList.get(i).get(0));
					temp.add(keywordList.get(i).get(1));
					temp.add(keywordList.get(i).get(3));
					stvList.add(temp);
			}
		}
		
		//把list转换成array
		for(int i=0; i<stvList.size(); i++){
			if(stvList.get(i).size() <5){
				String[] tempArr = stvList.get(i).toArray(new String[stvList.get(i).size()]);
				stvArray[i] = tempArr;
			}
		}
		
		int[][] value = new int[stvList.size()][stvList.get(0).size()];//存放source,target,value
		for(int i=0; i<value.length; i++){
			for(int j=0; j<value[i].length; j++){
				value[i][j] = 0;
			}
		}
		//测试打印stvArray
		for(int i=0; i<stvArray.length; i++){
			for(int j=0; j<stvArray[i].length; j++){
				System.out.print(stvArray[i][j]);
			}
			System.out.println();
		}
		for(int i=0; i<keywordArr.length; i++){
			for(int j=0; j<stvArray.length; j++){
				for(int k=0; k<2; k++){
					if(stvArray[j][k].equals(keywordArr[i])){
						value[j][k] = i;
					}
				}
			}
		}

		//测试打印value
		for(int i=0; i<value.length; i++){
			for(int j=0; j<value[i].length; j++){
				System.out.print(value[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * 数组元素去重
	 * @param oldArr
	 * @return 去重的数组
	 */
	private String[] removeExistItem(String[] oldArr){
		List<String> list = new ArrayList<String>();
		for(int i=0; i<oldArr.length; i++){
			if(!list.contains(oldArr[i]))
				list.add(oldArr[i]);
		}
		
		return list.toArray(new String[1]); 
	}
//	/**
//	 * 判断数组是否包含某个元素
//	 * 
//	 * @param array
//	 * @param keyword
//	 * @return true 这个元素已存在 false 这个元素不存在
//	 */
//	private boolean haveThiskey(String[] array, String keyword) {
//		return Arrays.asList(array).contains(keyword);
//	}

	/**
	 * 指定学科、年级，得到这个范围的知识点关联列表[知识点A，知识点B，支持度，置信度]
	 * 
	 * @param courseName
	 * @param year
	 */
	public List<List<String>> doRelationByScope(String courseName, String year) {
		List<VTestMain> paperList = getPaperIdByYear(courseName, year);
		List<List<String>> waitRelationList = new ArrayList<List<String>>();
		List<List<String>> resultList = null;
		// waitRelationList.add(getKeywordList(qDao.getKeywordOneYear(courseName,
		// year)));
		waitRelationList.add(getKeywordByScope(courseName, year));

		for (int i = 0; i < paperList.size(); i++) {
			// waitRelationList.add(getKeywordList(qDao.getKeywordByPaperId(paperList.get(i))));
			waitRelationList.add(getQuestionObjListByPaperId(paperList.get(i)));
		}

		resultList = ra.calRelation(waitRelationList);
		// ra.printConfItemset(resultList);
		System.out.println("RelationService:" + resultList);

		return resultList;
	}

	/**
	 * 指定科目、年级得到知识点列表
	 * 
	 * @param courseName
	 * @param year
	 */
	private List<String> getKeywordByScope(String courseName, String year) {
		List<VQuestion> keywordObjList = null;
		List<String> tempList = new ArrayList<String>();// 存放知识点的列表

		keywordObjList = qDao.getKeywordOneYear(courseName, year);
		tempList = getKeywordList(keywordObjList);

		return tempList;
	}

	/**
	 * 把从数据库读取的知识点对象列表转化为知识点列表
	 * 
	 * @param keywordObjList
	 * @return
	 */
	private List<String> getKeywordList(List<VQuestion> keywordObjList) {
		List<String> tempList = new ArrayList<String>();// 存放知识点的列表

		for (int i = 0; i < keywordObjList.size(); i++) {
			tempList.add(keywordObjList.get(i).getKeyword());
		}
		return tempList;
	}

	/**
	 * 指定学科、年级得到这个范围内所有的试卷ID
	 * 
	 * @param courseName
	 * @param year
	 * @return
	 */
	private List<VTestMain> getPaperIdByYear(String courseName, String year) {
		return qDao.getPaperIdOneYear(courseName, year);
	}

	/**
	 * 指定试卷ID得到这份试卷出现的知识点
	 * 
	 * @param testmain
	 * @return
	 */
	private List<String> getQuestionObjListByPaperId(VTestMain testmain) {
		return getKeywordList(qDao.getKeywordByPaperId(testmain));
	}
}
