package com.fjnu.test.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;

import com.fjnu.service.impl.ExamAnalyseImpl;
import com.fjnu.service.impl.RelationToolImpl;

public class fuckServlet extends BaseServlet {

	
	public String fuck(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RelationToolImpl rt = new RelationToolImpl();
		List<Object> params = new ArrayList<Object>();
		String scope = "";
		String subject = request.getParameter("subject");
		System.out.println(subject);
		if(subject.equals("chinese")){
			scope = "语文";
		}else if(subject.equals("math")){
			scope = "数学";
		}else if(subject.equals("english")){
			scope = "英文";
		}else{
			scope = "英文";//此处替换为想要的范围名
		}
		String id = "7";
		params.add(scope);
		params.add(id);
		System.out.println(params);
		List<List<String>> oldList = new ArrayList<List<String>>(rt.doRelation(params));
		List<List<String>> newList = rt.changeList(oldList);
		
//		System.out.println("relationsize:" + (rt.doRelation(params)).size());
//		System.out.println("oldsize:" + oldList.size());
		
		request.setAttribute("fuckList", newList);
		return "f:/index/relation.jsp";
	}
	
	public String getBaseData(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Object> scopeList = new ArrayList<Object>();
		String scope = "";
		String subject = request.getParameter("scope");
		if(subject.equals("chinese")){
			scope = "语文";
		}else if(subject.equals("math")){
			scope = "数学";
		}else if(subject.equals("english")){
			scope = "英文";
		}else{
			scope = "英文";//此处替换为想要的范围名
		}
		String grandient = "1";
		scopeList.add(scope);
		scopeList.add(grandient);
		ExamAnalyseImpl ea = new ExamAnalyseImpl(scopeList);
		request.setAttribute("excellent", ea.getExcellent());
		request.setAttribute("pass", ea.getPass());
		request.setAttribute("standard", ea.getStandard());
		return "f:/index/total_score.jsp";
	}

	
}
