package edu.fjnu.test.servlet;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import edu.fjnu.service.RelationService;
import edu.fjnu.util.CSVUtil;
import edu.fjnu.util.RelationResult;

public class TestRelation {
	RelationService rs = new RelationService();// 关联分析方法

	@Test
	public void test1() {
		String year = "四年级%";
		String courseName = "数学";

//		String[] keywordArr = rs.keywordArray(courseName, year);

//		for (int i = 0; i < keywordArr.length; i++) {
//			System.out.println(keywordArr[i]);
//		}

		System.out.println("------------");

		// courseName = "语文";
		//
		// String[] newArr = rs.keywordArray(courseName, year);
		//
		// for(int i=0; i<newArr.length; i++){
		// System.out.println(newArr[i]);
		// }

		// Object[][] stvArr = rs.stvArray();
		//
		// for(int i=0; i<stvArr.length; i++){
		// for(int j=0; j<stvArr[i].length; j++){
		// System.out.println(stvArr[i][j]);
		// }
		// }

	}

	@Test
	public void test2() throws FileNotFoundException {
		String year = "四年级";
		String courseName = "数学";

		// 读取CSV文件，获得规则
		List<String[]> rulesData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/")
				+ "/WebContent/Relation/" + courseName + "/" + year.replace("%", "") + "/rules.csv");

		if (rulesData.size() == 0 || rulesData == null) {
			return;
		}
		rulesData.remove(0);// 删除第一行

		for (int i = 0; i < rulesData.size(); i++) {
			if (rulesData.get(i)[0].contains(",")) {
				rulesData.remove(i); // 删除多个知识点的元素
				i--;// 因为List的动态变化特性，需要--
			}
		}

		for (int i = 0; i < rulesData.size(); i++) {
			for (int j = 0; j < rulesData.get(i).length; j++)
				System.out.print(rulesData.get(i)[j] + "\t");
			System.out.println();
		}
		System.out.println("******************line******************");

		List<String> keywordList = new ArrayList<String>();// 存储一个个知识点
		int beginA, beginB, endA, endB;
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

		for (int i = 0; i < keywordList.size(); i++) {
			System.out.println(keywordList.get(i));
		}

		System.out.println("******************line******************");

		List<List<Object>> resultList = new ArrayList<List<Object>>();
		// 遍历整个知识点规则列表
		int indexA = 0, indexB = 0;// 保存知识点A下标为source,知识点B下标为target
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
		// beginA = rulesData.get(5)[0].indexOf("{");
		// endA = rulesData.get(5)[0].indexOf("}");
		// beginB = rulesData.get(5)[0].indexOf(" {");
		// endB = rulesData.get(5)[0].indexOf("}\"");
		// int indexA = 0, indexB = 0;
		// String keyA = rulesData.get(5)[0].substring(beginA+1, endA);
		// String keyB = rulesData.get(5)[0].substring(beginB+2, endB);
		// for(int i=0; i<keywordList.size(); i++){
		// if(keywordList.get(i).equals(keyA)){
		// indexA = i;
		// break;
		// }
		// }
		// for(int i=0; i<keywordList.size(); i++){
		// if(keywordList.get(i).equals(keyB)){
		// indexB = i;
		// break;
		// }
		// }
		// System.out.println("indexA:" + indexA + ",indexB:"+indexB);
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	@Test
	public void test3() {
		RelationResult rr = new RelationResult();
		String year = "四年级";
		String course = "英文";
		List<String> keywordList = rr.getKeywordList(year, course);
		if (keywordList == null) {
			System.out.println("null!!!");
			return;
		}
		System.out.println(keywordList);
		List<List<Object>> resultList = rr.getStvList(year, course);

		if (resultList == null) {
			System.out.println("null!!!");
			return;
		}
		for (int i = 0; i < resultList.size(); i++) {
			System.out.println(resultList.get(i));
		}
	}

	@Test
	public void test4() {
		RelationResult rr = new RelationResult();
		String year = "二年级";
		String course = "语文";

		String[] keywordArr = rr.getKeywordArr(year, course);
		for (String x : keywordArr) {
			System.out.println(x);
		}
		Object[][] stvArr = rr.getStvArr(year, course);
		for (int i = 0; i < stvArr.length; i++) {
			for (int j = 0; j < stvArr[i].length; j++) {
				System.out.print(stvArr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
