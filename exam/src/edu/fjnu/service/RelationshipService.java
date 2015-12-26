package edu.fjnu.service;

import java.util.ArrayList;
import java.util.List;

import java.io.File;

import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import edu.fjnu.util.CSVUtil;
import edu.fjnu.util.FileTools;
import net.sf.json.JSONObject;

/**
 * 
 * @author Li
 *
 */
public class RelationshipService {

	RelationService relation = new RelationService();

	/**
	 * 构建知识点网图的nodes
	 * 
	 * @param name
	 * @return
	 */
	public List<String> JsonForNodes(List<String> name) {

		JSONObject jsonObject = new JSONObject();
		List<String> jsonStr = new ArrayList<String>();
		for (int i = 0; i < name.size(); i++) {
			jsonObject.put("name", name.get(i));
			jsonStr.add(jsonObject.toString());
		}
		return jsonStr;
	}

	/**
	 * 构建知识网图的links
	 * 
	 * @param link
	 * @return
	 */
	public List<String> JsonForLinks(int[][] link) {
		JSONObject jsonObject = new JSONObject();
		List<String> jsonStr = new ArrayList<String>();
		for (int i = 0; i < link.length; i++) {
			for (int j = 1; j < link[i].length; j++) {
				jsonObject.put("source", link[i][0]);
				jsonObject.put("target", link[i][j]);
				jsonStr.add(jsonObject.toString());
			}
		}
		return jsonStr;
	}

	// 获取关联分析得到的结果的使用示例
	public void getRelationship() {
		RelationService rs = new RelationService();
		String courseName = "语文";
		String year = "三年级%";
		// 标准关联分析的结果，格式为[知识点A,知识点B，sup,conf]
		List<List<String>> standardList = rs.doRelationByScope(courseName, year);

		// 关联分析后得到的所有有关联的知识点，前端绘制点的数组
		String[] keywordArr = rs.keywordArray(courseName, year);

		// 关联分析后得到的关联数组，格式为[source,target,value]，前端绘制线的数组
		Object[][] stvArr = rs.stvArray();

		// 判断结果是否为空
		if (stvArr == null) {
			// 如果为空，没有连线
		} else {
			// 把它们连起来
		}
	}

	/**
	 * 根据知识点列表生成关联分析文档
	 * 
	 * @param item
	 * @throws REngineException
	 */
	public void createAnalysisPDF(List<List<String>> item) throws REngineException {
		RConnection rconn = new RConnection();

		String[] strR = new String[200];

		try {
			for (int i = 0; i < item.size(); i++) {
				for (int j = 0; j < item.get(i).size(); j++) {
					strR[j] = item.get(i).get(j);
				}

				rconn.assign(("x" + i).toString(), strR);
			}
		} catch (RserveException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * 处理为关联的知识列表的数据
	 * 
	 * @param courseName
	 * @param year
	 * @return
	 */
	public static List<String> dealRelationList(String courseName, String year) {
		RelationService relation = new RelationService();
		List<String> dealList = new ArrayList<String>();
		List<List<String>> initial = new ArrayList<List<String>>();
		initial.addAll(relation.getRelationListForRtool(courseName, year));
//		System.out.println(initial);
		String temp;
		for (int i = 0; i < initial.size(); i++) {
			temp = initial.get(i).toString();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");
			temp = temp.replace(" ", "");
			dealList.add(temp);
		}
//		for (int i1 = 0; i1 < initial.size(); i1++) {
//			System.out.println(initial.get(i1));
//		}
//		for (int i1 = 0; i1 < dealList.size(); i1++) {
//			System.out.println(dealList.get(i1));
//		}
		return dealList;
	}

	/**
	 * 
	 * @param courseName
	 * @param year
	 */
	public void createRelationListCSV(String courseName, String year) {

		String path = "/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/Rimag/"; // 在这里改文件路径
		FileTools filetool = new FileTools();
		filetool.createFolder(path);
		CSVUtil csvtool = new CSVUtil();
		List<String> relationlist = dealRelationList(courseName, year);
		File file = new File(path + "temp.csv");// 读取数据文件的路径
		boolean isCSVSuccess = csvtool.exportCsv(file, relationlist);
		System.out.println(isCSVSuccess);
	}

	/**
	 * 
	 * @param courseName
	 * @param year
	 * @throws RserveException
	 */
	public void createRForRelastion(String courseName, String year) throws RserveException {
		RelationshipService rs = new RelationshipService();
		rs.createRelationListCSV(courseName, year);
		RConnection rconn = new RConnection();

		try {
//			rconn.eval("source('" + System.getProperty("user.dir").replace("\\", "/")
//					+ "/R/RScript/aprioriForJava.R')");
//			rconn.eval("scourse(/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/RScript/aprioriForJava.R)");
			rconn.eval("source('" 
					+ "/Users/vengeance/Documents/workspaceMars/exam/WebContent/R/RScript/aprioriForJava.R')");
			rconn.eval("aprioriForJava()");
		} catch (RserveException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws RserveException {
//		RelationshipService rs = new RelationshipService();
//		rs.createRForRelastion("数学", "四年%");
//
//	}
}
