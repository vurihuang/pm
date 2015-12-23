package edu.fjnu.service;

import java.util.ArrayList;
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
	List<List<String>> keywordList = null;// 知识点列表
	String[] keywordArr = null;// 存储关联分析的知识点，用来描点
	
	/**
	 * 指定学科、年级，得到这个范围的知识点关联列表[知识点A，知识点B，支持度，置信度]
	 * @param courseName
	 * @param year
	 * @return 返回一个关联分析的标准列表
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
	 * 获得关联分析后的有关联的所有知识点
	 * 
	 * @param courseName
	 * @param year
	 * @return 相关联的知识点的一维数组
	 */
	public String[] keywordArray(String courseName, String year) {
		keywordList = doRelationByScope(courseName, year);
		List<String> tempList = new ArrayList<String>();// 用来存储去重的知识点

		for (int i = 0; i < keywordList.size(); i++) {
			tempList.add(keywordList.get(i).get(1));
		}

		keywordArr = removeExistItem(tempList.toArray(new String[tempList.size()]));
		return keywordArr;
	}
	
	/**
	 * 返回一个二维数组，格式为source、target、value
	 * 
	 * @return 用于关联分析画图的数组
	 */
	public Object[][] stvArray() {
		int cnt = 0;// 用以计算要返回的stvArray的大小

		// 测试输出keywordList
		for (int i = 0; i < keywordList.size(); i++) {
			for (int j = 0; j < keywordList.get(i).size(); j++) {
				System.out.print(keywordList.get(i).get(j));
			}
		}
		// 得到A、B、sup、conf格式的一个二维数组
		for (int i = 0; i < keywordList.size(); i++) {
			if (keywordList.get(i).size() != 4)
				break;
			else {
				cnt++;
			}
		}
		if (cnt == 0) {//如果算出的知识点关联列表为空，则返回一个空
			return null;
		}

		List<List<String>> stvList = new ArrayList<List<String>>();// 保存source、target、value格式的列表
		for (int i = 0; i < keywordList.size(); i++) {
			if (keywordList.get(i).size() > 4) {// 如果超过四列，就停止添加
				break;
			} else {// 保存到指定格式的列表
				List<String> temp = new ArrayList<String>();
				temp.add(keywordList.get(i).get(0));
				temp.add(keywordList.get(i).get(1));
				temp.add(keywordList.get(i).get(3));
				stvList.add(temp);
			}
		}

		try {
			String[][] stvArray = new String[cnt][stvList.get(0).size()];// 保存source、target、value格式的数组
			// 把list转换成array
			for (int i = 0; i < stvList.size(); i++) {
				if (stvList.get(i).size() < 5) {
					String[] tempArr = stvList.get(i).toArray(new String[stvList.get(i).size()]);
					stvArray[i] = tempArr;
				}
			}

			Object[][] value = new Object[stvArray.length][3];// 存放source,target,value(String)
			// 给value赋值，source、target为0，value为关系度
			for (int i = 0; i < value.length; i++) {
				for (int j = 0; j < value[i].length; j++) {
					if (j == value[i].length - 1) {// 最后一列为关系度value，表示两个点之间的长度
						// Object obj = stvArray[i][j];
						value[i][j] = stvArray[i][j].substring(0, 3);// 格式化，保存为{#.#}格式
					} else {
						value[i][j] = 0;// source、target赋初始值
					}
				}
			}

			// 给source、target做标记，找到点之间的关系
			for (int i = 0; i < keywordArr.length; i++) {
				for (int j = 0; j < stvArray.length; j++) {
					for (int k = 0; k < 2; k++) {
						if (stvArray[j][k].equals(keywordArr[i])) {
							value[j][k] = i;
						}
					}
				}
			}
			return value;
		} catch (Exception e) {
			System.err.println("关系为空，关系数组长度为:" + cnt);
			throw new RuntimeException(e);
		}
	}

	/**
	 * 数组元素去重
	 * 
	 * @param oldArr
	 * @return 去重的数组
	 */
	private String[] removeExistItem(String[] oldArr) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < oldArr.length; i++) {
			if (!list.contains(oldArr[i]))
				list.add(oldArr[i]);
		}

		return list.toArray(new String[1]);
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
