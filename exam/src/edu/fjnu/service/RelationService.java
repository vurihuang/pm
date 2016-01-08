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
	 * 
	 * @param courseName
	 * @param year
	 * @return 返回一个关联分析的标准列表
	 */
	public List<List<String>> doRelationByScope(String courseName, String year) {
		List<List<String>> resultList = null;
		resultList = ra.calRelation(getRelationList(courseName, year));// 存储关联分析过的结果集

		return resultList;
	}

	/**
	 * 得到没有关联分析的知识点列表，用于传递给R绘制的数据
	 * 
	 * @param courseName
	 * @param year
	 * @return 未关联的知识点列表
	 */
	public List<List<String>> getRelationListForRtool(String courseName, String year) {
		List<List<String>> tempKeywordList = null;
		tempKeywordList = getRelationList(courseName, year);// 得到未处理的知识点列表
		tempKeywordList.remove(0);// 移除列表中的第一个元素，其中存放的是所有出现过的知识点

		return tempKeywordList;
	}

	/**
	 * 根据课程名、年级得到知识点关联列表
	 * 
	 * @param courseName
	 * @param year
	 * @return
	 */
	public List<List<String>> getKeywordList(String courseName, String year) {
		// keywordList = doRelationByScope(courseName, year);
		return doRelationByScope(courseName, year);
	}

	/**
	 * 获得关联分析后的有关联的所有知识点
	 * 
	 * @param courseName
	 * @param year
	 * @return 相关联的知识点的一维数组
	 */
	public String[] keywordArray(String courseName, String year) {
		keywordList = getKeywordList(courseName, year);
		List<String> tempList = new ArrayList<String>();// 用来存储去重的知识点

		for (int i = 0; i < keywordList.size(); i++) {
			tempList.add(keywordList.get(i).get(1));
		}

		keywordArr = removeExistItem(tempList.toArray(new String[tempList.size()]));// 知识点去重

		return removeExistItem(tempList.toArray(new String[tempList.size()]));// 知识点去重
	}

	/**
	 * 返回一个二维数组，格式为source、target、value
	 * 
	 * @return 用于关联分析画图的数组
	 */
	public Object[][] stvArray() {
		int cnt = 0;// 用以计算要返回的stvArray的大小

		// List<List<String>> tmpKeywordList = getKeywordList(courseName, year);
		// 得到A、B、sup、conf格式的一个二维数组
		for (int i = 0; i < keywordList.size(); i++) {
			if (keywordList.get(i).size() != 4)
				break;
			else {
				cnt++;
			}
		}
		if (cnt == 0) {// 如果算出的知识点关联列表为空，则返回一个空
			return null;
		}

		List<List<String>> stvList = new ArrayList<List<String>>();// 保存source、target、value格式的列表
		for (int i = 0; i < keywordList.size(); i++) {
			if (keywordList.get(i).size() > 4) {// 如果超过四列，就停止添加
				break;
			} else {// 保存到指定格式的列表
				List<String> temp = new ArrayList<String>();
				temp.add(keywordList.get(i).get(0));// 添加知识点A
				temp.add(keywordList.get(i).get(1));// 添加知识点B
				temp.add(keywordList.get(i).get(3));// 添加关联程度
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
						value[i][j] = stvArray[i][j].substring(0, 3);// 格式化，保存为{#.#}格式
					} else {
						value[i][j] = 0;// source、target赋初始值
					}
				}
			}

			// String[] tmpKeywordArr = keywordArray(courseName, year);

			// 给source、target做标记，找到点之间的关系
			for (int i = 0; i < keywordArr.length; i++) {
				for (int j = 0; j < stvArray.length; j++) {
					for (int k = 0; k < 2; k++) {
						if (stvArray[j][k].equals(keywordArr[i])) {// 如果出现知识点列表的知识点，记录下标
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
	 * 把关联分析得出的一级项集结果集list转换成String数组
	 * 
	 * @param courseName
	 * @param year
	 * @return String数组
	 */
	public String[][] getRelationArray(String courseName, String year) {
		List<List<String>> relationList = getRelationListForRtool(courseName, year);
		String[][] relationArr = new String[relationList.size()][relationList.get(0).size()];

		for (int i = 0; i < relationList.size(); i++) {
			String[] tempArr = relationList.get(i).toArray(new String[relationList.get(0).size()]);
			relationArr[i] = tempArr;
		}
		
		return relationArr;
	}

	/**
	 * 得到没有关联分析过的知识点列表
	 * 
	 * @param courseName
	 * @param year
	 * @return 未关联的知识点列表
	 */
	public List<List<String>> getRelationList(String courseName, String year) {
		List<VTestMain> paperList = getPaperIdByYear(courseName, year);// 试卷ID结果集
		List<List<String>> waitRelationList = new ArrayList<List<String>>();// 知识点结果集

		// 试卷知识点结果集，这里首先添加一个所有出现过的知识点列表，用于算法使用，供其他出现知识点做概率比较
		waitRelationList.add(getKeywordByScope(courseName, year));
		for (int i = 0; i < paperList.size(); i++) {
			waitRelationList.add(getQuestionObjListByPaperId(paperList.get(i)));// 根据试卷ID得到每一份试卷的知识点
		}
		// System.out.println("getRelationList:" + waitRelationList);// TEST

		return waitRelationList;
	}

	/**
	 * 数组元素去重
	 * 
	 * @param oldArr
	 * @return 去重的数组
	 */
	private String[] removeExistItem(String[] oldArr) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < oldArr.length; i++) {// 去掉重复的知识点
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

		keywordObjList = qDao.getKeywordOneYear(courseName, year);// 得到指定范围的所有知识点
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

		for (int i = 0; i < keywordObjList.size(); i++) {// 把知识点对象列表转化成知识点列表
			tempList.add(keywordObjList.get(i).getKeyword());
		}

		return tempList;
	}

	/**
	 * 指定学科、年级得到这个范围内所有的试卷ID
	 * 
	 * @param courseName
	 * @param year
	 * @return 返回指定范围的所有试卷ID
	 */
	private List<VTestMain> getPaperIdByYear(String courseName, String year) {
		return qDao.getPaperIdOneYear(courseName, year);
	}

	/**
	 * 指定试卷ID得到这份试卷出现的知识点
	 * 
	 * @param testmain
	 * @return 返回指定试卷ID的所有知识点
	 */
	private List<String> getQuestionObjListByPaperId(VTestMain testmain) {
		return getKeywordList(qDao.getKeywordByPaperId(testmain));
	}

}
