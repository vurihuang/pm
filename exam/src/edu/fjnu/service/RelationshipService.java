package edu.fjnu.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.rosuda.REngine.Rserve.RserveException;

import edu.fjnu.util.CSVUtil;
import net.sf.json.JSONObject;

public class RelationshipService 
{
	/**
	 * 构建知识点网图的nodes
	 * @param name
	 * @return
	 */
	public List<String> JsonForNodes( List<String> name)
	{
		
		JSONObject jsonObject = new JSONObject();
		List<String> jsonStr = new ArrayList<String>();
		for( int i=0; i<name.size(); i++)
		{
			jsonObject.put("name", name.get(i));
			jsonStr.add(jsonObject.toString());
		}
		return jsonStr;
	}
	
	/**
	 * 构建知识网图的links
	 * @param link
	 * @return
	 */
	public List<String> JsonForLinks(int[][] link)
	{
		JSONObject jsonObject = new JSONObject();
		List<String> jsonStr = new ArrayList<String>();
		for( int i=0; i<link.length; i++)
		{
			for( int j=1; j<link[i].length; j++)
			{
				jsonObject.put("source", link[i][0]);
				jsonObject.put("target", link[i][j]);
				jsonStr.add(jsonObject.toString());
			}
		}
		return jsonStr;
	}
	
	//获取关联分析得到的结果的使用示例
	public void getRelationship(){
		RelationService rs = new RelationService();
		String courseName = "语文";
		String year = "三年级%";
		//标准关联分析的结果，格式为[知识点A,知识点B，sup,conf]
		List<List<String>> standardList = rs.doRelationByScope(courseName, year);
		
		//关联分析后得到的所有有关联的知识点，前端绘制点的数组
		String[] keywordArr = rs.keywordArray(courseName, year);
		
		//关联分析后得到的关联数组，格式为[source,target,value]，前端绘制线的数组
		Object[][] stvArr = rs.stvArray();
		
		//判断结果是否为空
		if(stvArr == null){
			//如果为空，没有连线
		}else{
			//把它们连起来
		}
	}
	
	/**
	 * 处理为关联的知识列表的数据
	 * @param courseName
	 * @param year
	 * @return
	 */
	public static List<String> dealRelationList( String courseName, String year)
	{
		RelationService relation = new RelationService();
		List<String> dealList = new ArrayList<String>();
		List<List<String>> initial = new ArrayList<List<String>>();
		initial.addAll(relation.getRelationListForRtool(courseName, year));
		System.out.println(initial);
		String temp;
		for( int i=0; i<initial.size(); i++)
		{
			temp = initial.get(i).toString();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");
			dealList.add(temp);
		}
		for( int i1=0; i1<initial.size(); i1++)
		{
			System.out.println(initial.get(i1));
		}
		for( int i1=0; i1<dealList.size(); i1++)
		{
			System.out.println(dealList.get(i1));
		}
		return dealList;
	}
	
	/**
	 * 
	 * @param courseName
	 * @param year
	 */
	public void createRelationListCSV( String courseName, String year)
	{
		CSVUtil csvtool = new CSVUtil();
		List<String> relationlist = dealRelationList(courseName, year);
		File file = new File(System.getProperty("user.dir").replace("\\", "/")
							+"/WebContent/R/temp.csv");
	    boolean isCSVSuccess = csvtool.exportCsv(file, relationlist);
	    System.out.println(isCSVSuccess);
	}
	
	
	public static void main( String[] args) throws RserveException
	{
		RelationshipService r = new RelationshipService();
		r.createRelationListCSV("语文", "三年%");
	
	}
}
