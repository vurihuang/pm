package edu.fjnu.service;

import java.util.ArrayList;
import java.util.List;

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
	}
}
