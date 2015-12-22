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
//				jsonObject.put("value", value);
				jsonStr.add(jsonObject.toString());
			}
		}
		return jsonStr;
	}
	
	
}
