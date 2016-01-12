package edu.fjnu.service;

import java.util.ArrayList;
import java.util.List;

import edu.fjnu.dao.KeywordDao;
import edu.fjnu.dao.QuestionDao;
import edu.fjnu.domain.DifficultInfo;
import edu.fjnu.domain.Keyword;
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
	KeywordDao keywordDao = new KeywordDao();// 得到知识点信息
	List<List<String>> keywordList = null;// 知识点列表
	String[] keywordArr = null;// 存储关联分析的知识点，用来描点

	/**
	 * 根据知识点的名称得到这个知识点的相关信息(做对做错次数,相关题目难中易题数分布)
	 * 
	 * @param keyword
	 * @return 知识点对象
	 */
	public Keyword getKeywordInfoByName(Keyword keyword) {
		keyword = keywordDao.getKeywordInfo(keyword);
		List<DifficultInfo> diffList = new ArrayList<DifficultInfo>();// 存储知识点相关题目难中易题数分布
		diffList = keywordDao.getKeyDiffInfo(keyword);// 得到相关题目难中易题数分布

		for (int i = 0; i < diffList.size(); i++) {
			switch (diffList.get(i).getDifficultyLevel()) {
			case 1: {
				keyword.setEasyCount(diffList.get(i).getQuestionCount());
				break;
			}
			case 3: {
				keyword.setMiddleCount(diffList.get(i).getQuestionCount());
				break;
			}
			case 5: {
				keyword.setHardCount(diffList.get(i).getQuestionCount());
				break;
			}
			default:
				keyword.setEasyCount(0);
				keyword.setMiddleCount(0);
				keyword.setHardCount(0);
				break;
			}
		}
		System.out.println(keyword);// TEST
		return keyword;
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

		return waitRelationList;
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
