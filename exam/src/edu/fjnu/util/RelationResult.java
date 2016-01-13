package edu.fjnu.util;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来得到关联分析最后的结果集
 * 
 * @author vengeance
 *
 */
public class RelationResult {

	/**
	 * 根据输入的科目、年级获得处理过的关联规则列表，再得到去重的知识点列表
	 * 
	 * @param year
	 * @param course
	 * @return 知识点列表
	 */
	public List<String> getKeywordList(String year, String course) {
		// 调用得到规则列表的方法，获得剔除知识对的关联规则列表
		List<String[]> rulesData = getRulesData(year, course);
		// 如果未空就返回空
		if (rulesData == null || rulesData.size() == 0) {
			return null;
		}

		List<String> keywordList = new ArrayList<String>();// 存储一个个知识点
		int beginA, beginB, endA, endB; // 控制截取知识点的下标
		// 保存不重复的知识点列表
		for (int i = 0; i < rulesData.size(); i++) {
			// 得到前一个知识点A
			beginA = rulesData.get(i)[0].indexOf("{");
			endA = rulesData.get(i)[0].indexOf("}");
			// 得到后一个知识点B
			beginB = rulesData.get(i)[0].indexOf(" {");
			endB = rulesData.get(i)[0].indexOf("}\"");

			// 如果列表为空，就添加一个知识点进去
			if (keywordList.size() == 0 || keywordList == null) {
				keywordList.add(rulesData.get(i)[0].substring(beginA + 1, endA));
			}
			// 如果不为空，判断是否已经包含这个知识点，没有就添加进去
			if (!keywordList.contains(rulesData.get(i)[0].substring(beginA + 1, endA))) {
				keywordList.add(rulesData.get(i)[0].substring(beginA + 1, endA));
			}
			// 如果不为空，判断是否已经包含这个知识点，没有就添加进去
			if (!keywordList.contains(rulesData.get(i)[0].substring(beginB + 2, endB))) {
				keywordList.add(rulesData.get(i)[0].substring(beginB + 2, endB));
			}
		}

		return keywordList;
	}

	/**
	 * 根据输入的课程、年级返回source-target-value结构列表
	 * 
	 * @param year
	 * @param course
	 * @return s-t-v列表
	 */
	public List<List<Object>> getStvList(String year, String course) {
		// 调用得到规则列表的方法，获得剔除知识对的关联规则列表
		List<String[]> rulesData = getRulesData(year, course);
		// 如果为空就返回空
		if (rulesData == null || rulesData.size() == 0) {
			return null;
		}

		// 调用得到知识点列表的方法，获得所有不重复的知识点
		List<String> keywordList = getKeywordList(year, course);
		if (keywordList == null || keywordList.size() == 0) {
			return null;
		}

		// 存储结果集，格式类型为source,target,value(源知识点，目标知识点，关联值)
		List<List<Object>> resultList = new ArrayList<List<Object>>();
		// 遍历整个知识点规则列表
		int indexA = 0, indexB = 0;// 保存知识点A下标为source,知识点B下标为target
		int beginA, beginB, endA, endB; // 控制截取知识点的下标
		String keyA, keyB; // 保存知识点A，知识点B
		for (int i = 0; i < rulesData.size(); i++) {
			beginA = rulesData.get(i)[0].indexOf("{");
			endA = rulesData.get(i)[0].indexOf("}");
			beginB = rulesData.get(i)[0].indexOf(" {");
			endB = rulesData.get(i)[0].indexOf("}\"");

			keyA = rulesData.get(i)[0].substring(beginA + 1, endA);
			keyB = rulesData.get(i)[0].substring(beginB + 2, endB);

			for (int j = 0; j < keywordList.size(); j++) {
				if (keyA.equals(keywordList.get(j))) {
					indexA = j;
				}
			}
			for (int j = 0; j < keywordList.size(); j++) {
				if (keyB.equals(keywordList.get(j))) {
					indexB = j;
				}
			}
			List<Object> tmpList = new ArrayList<Object>();
			tmpList.add(indexA);
			tmpList.add(indexB);
			tmpList.add(rulesData.get(i)[2]);

			resultList.add(tmpList);
		}
		return resultList;
	}

	/**
	 * 根据输入的科目年级获得关联规则列表
	 * 
	 * @param year
	 * @param course
	 * @return 两两知识对的关联规则列表
	 */
	private List<String[]> getRulesData(String year, String course) {
		List<String[]> rulesData = null;
		// 读取CSV文件，获得规则
		try {
//			rulesData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/") + "/relation/" + course
//					+ "/" + year + "/rules.csv");
			rulesData = CSVUtil.importCsv("/Users/vengeance/Documents/workspaceMars/exam/WebContent/relation/" + course + "/" + year + "/rules.csv");
		} catch (FileNotFoundException e) {
			System.err.println("路径文件不存在！");
			return null;
		}

		// 如果文件内容为空或者文件为空，返回空
		if (rulesData.size() == 0 || rulesData == null) {
			return null;
		}
		rulesData.remove(0);// 删除第一行

		// 对知识对的剔除，只需要两两关系的知识对
		for (int i = 0; i < rulesData.size(); i++) {
			if (rulesData.get(i)[0].contains(",")) {
				rulesData.remove(i); // 删除多个知识点的元素
				i--;// 因为List的动态变化特性，需要--
			}
		}

		return rulesData;
	}

	/**
	 * 格式转换，把知识点List转换成String数组
	 * 
	 * @param year
	 * @param course
	 * @return 知识点数组
	 */
	public String[] getKeywordArr(String year, String course) {
		List<String> tmpKeywordList = getKeywordList(year, course);
		if (tmpKeywordList == null || tmpKeywordList.size() == 0) {
			return null;
		}
		String[] keywordArr = new String[tmpKeywordList.size()];
		for (int i = 0; i < keywordArr.length; i++) {
			keywordArr[i] = tmpKeywordList.get(i);
		}

		return keywordArr;
	}

	/**
	 * 格式化，把知识点关系网转换成Object[][]二维数组
	 * 
	 * @param year
	 * @param course
	 * @return 关系网二维数组
	 */
	public Object[][] getStvArr(String year, String course) {
		List<List<Object>> tmpStvList = getStvList(year, course);
		if (tmpStvList == null || tmpStvList.size() == 0) {
			return null;
		}
		Object[][] stvArr = new Object[tmpStvList.size()][tmpStvList.get(0).size()];
		for (int i = 0; i < stvArr.length; i++) {
			Object[] tmpArr = tmpStvList.get(i).toArray(new Object[tmpStvList.get(0).size()]);
			stvArr[i] = tmpArr;
		}

		return stvArr;
	}
}
